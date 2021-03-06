package com.gn.app.service.citizenProfileTask.CitizenWork;

import com.gn.app.dao.citizenProfileTask.CitizenDetail.CitizenDetailDao;
import com.gn.app.dao.citizenProfileTask.CitizenWork.CitizenWorkDao;
import com.gn.app.dao.settings.ServiceRegister.ServiceRegisterDao;
import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkCitizenWorkTypeDTO;
import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDonationTypeDTO;
import com.gn.app.mappers.citizenProfileTask.CitizenWork.CitizenWorkMapper;
import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWork;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWorksCitizenWorkType;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetailsDonationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CitizenWorkServiceImpl implements CitizenWorkService {

    @Autowired
    CitizenWorkDao citizenWorkDao;

    @Autowired
    CitizenDetailDao citizenDetailDao;

    @Autowired
    ServiceRegisterDao serviceRegisterDao;



    public DataTablesOutput<CitizenWorkDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<CitizenWork> output = citizenWorkDao.findAll(input);
        DataTablesOutput<CitizenWorkDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = CitizenWorkMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<CitizenWorkDTO> findAll() {
        List<CitizenWorkDTO> profiles = null;
        try {
            profiles= CitizenWorkMapper.getInstance().domainToDTOList(citizenWorkDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }



    @Override
    public CitizenWorkDTO create(CitizenWorkDTO citizenWorkDTO) {


        if(citizenWorkDTO.getId() != null){
            return update(citizenWorkDTO);
        }else{
            return save(citizenWorkDTO);
        }
    }

    private CitizenWorkDTO update(CitizenWorkDTO citizenWorkDTO) {
        CitizenWork citizenWork = findByIdEntity(citizenWorkDTO.getId()).get();
        try {
            CitizenWorkMapper.getInstance().dtoToDomain(citizenWorkDTO, citizenWork);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(citizenWork);
        return citizenWorkDTO;
    }


    private CitizenWorkDTO save(CitizenWorkDTO citizenWorkDTO){
        CitizenWork citizenWork = new CitizenWork();
        try {
            CitizenWorkMapper.getInstance().dtoToDomain(citizenWorkDTO, citizenWork);
        }catch (Exception e){
            e.printStackTrace();
        }


        setCommonData(citizenWork,citizenWorkDTO);
        saveOrUpdate(citizenWork);
        return citizenWorkDTO;
    }

    private void saveOrUpdate(CitizenWork citizenWork) {
        citizenWorkDao.save(citizenWork);
    }


    private void setCommonData(CitizenWork citizenWork,CitizenWorkDTO citizenWorkDTO){
        setCitizen(citizenWork,citizenWorkDTO);
        setServiceRegister(citizenWork, citizenWorkDTO);
    }
    //associate citizen table with citizen work
    private void setCitizen(CitizenWork citizenWork,CitizenWorkDTO citizenWorkDTO){

        if(citizenWorkDTO != null && citizenWorkDTO.getCitizenId()!=null) {

        citizenWork.setCitizenDetail(citizenDetailDao.findOne(findCitizenSpecification
                (citizenWorkDTO.getCitizenId())).get());
    }}


    public Specification<CitizenDetail> findCitizenSpecification(Integer id){
        Specification<CitizenDetail> specification = new Specification<CitizenDetail>() {
            @Override
            public Predicate toPredicate(Root<CitizenDetail> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);

            }
        };
        return specification;
    }
//end



    private void setServiceRegister(CitizenWork citizenWork, CitizenWorkDTO citizenWorkDTO){
        Set<CitizenWorksCitizenWorkType> citizenWorksCitizenWorkTypes = new HashSet<>();
        CitizenWorksCitizenWorkType citizenWorksCitizenWorkType;

        for(CitizenWorkCitizenWorkTypeDTO serviceRegisterDTO:citizenWorkDTO.getServiceRegisterDTOS()){
            if(citizenWorkDTO!= null && citizenWorkDTO.getId()!=null && citizenWorkDTO.getServiceRegisterDTOS() != null ){
                Optional<CitizenWorksCitizenWorkType>
                        optional=citizenWork.getCitizenWorksCitizenWorkTypes().stream().filter((x)-> x.getId().equals(citizenWorkDTO.getId())).findAny();

                if(optional.isPresent()){
                    citizenWorksCitizenWorkType=optional.get();
                }else{
                    citizenWorksCitizenWorkType=new CitizenWorksCitizenWorkType();
                }
            }else {
                citizenWorksCitizenWorkType= new CitizenWorksCitizenWorkType();
            }

            citizenWorksCitizenWorkType.setServiceRegister(serviceRegisterDao.findOne(findServiceRegisterSpecification(serviceRegisterDTO.getServiceRegisterID())).get());
            citizenWorksCitizenWorkType.setCitizenWork(citizenWork);
            citizenWorksCitizenWorkType.setId(citizenWorkDTO.getId());
            citizenWorksCitizenWorkType.setVersion(serviceRegisterDTO.getVersion());
            citizenWorksCitizenWorkType.add(citizenWorksCitizenWorkType);
        }
        citizenWork.setCitizenWorksCitizenWorkTypes(citizenWorksCitizenWorkTypes);
    }

    public Specification<ServiceRegister> findServiceRegisterSpecification(Integer id){
        Specification<ServiceRegister> specification = new Specification<ServiceRegister>() {
            @Override
            public Predicate toPredicate(Root<ServiceRegister> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return specification;
    }




    @Override
    public CitizenWorkDTO findById(Integer id) {
        CitizenWork citizenWork = findByIdEntity(id).get();
        CitizenWorkDTO citizenWorkDTO = new CitizenWorkDTO();
        try {
            citizenWorkDTO = CitizenWorkMapper.getInstance().domainToDto(citizenWork);
        }catch (Exception e){
            e.printStackTrace();
        }
        return citizenWorkDTO;
    }

    public Optional<CitizenWork> findByIdEntity(Integer id){
        Specification<CitizenWork> specification = new Specification<CitizenWork>() {
            @Override
            public Predicate toPredicate(Root<CitizenWork> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return citizenWorkDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        citizenWorkDao.delete(findByIdEntity(id).get());

    }
}
