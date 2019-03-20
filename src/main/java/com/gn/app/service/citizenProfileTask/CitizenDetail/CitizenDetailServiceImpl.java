package com.gn.app.service.citizenProfileTask.CitizenDetail;

import com.gn.app.dao.citizenProfileTask.CitizenDetail.CitizenDetailDao;
import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.mappers.citizenProfileTask.CitizenDetail.CitizenDetailMapper;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class CitizenDetailServiceImpl implements CitizenDetailService {

    @Autowired
    CitizenDetailDao citizenDetailDao;


    @Override
    @Transactional(readOnly = true)
    public DataTablesOutput<CitizenDetailDTO> findAllDataTable (DataTablesInput input) {

        DataTablesOutput<CitizenDetail> output= citizenDetailDao.findAll(input);
        DataTablesOutput<CitizenDetailDTO> dataTablesOutput=null;
        try{
            dataTablesOutput = CitizenDetailMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<CitizenDetailDTO> findAll() {
        List<CitizenDetailDTO> profiles = null;
        try{
            profiles = CitizenDetailMapper.getInstance().domainToDTOList(citizenDetailDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public CitizenDetailDTO create(CitizenDetailDTO citizenDetailDTO) {


        if(citizenDetailDTO.getId() != null){
            return update(citizenDetailDTO);
        }else{
            return save(citizenDetailDTO);
        }


    }

   /*private void setGnDomain(CitizenDetailDTO citizenDetailDTO,CitizenDetail citizenDetail){
        if(citizenDetailDTO != null && citizenDetailDTO.getGnDomainId()!=null) {
            citizenDetail.setGnDomain(getGnDomainSpecification(citizenDetailDTO).get());
        }
    }*/

   /*private Optional<GnDomain> getGnDomainSpecification(CitizenDetailDTO citizenDetailDTO){

            Specification<GnDomain> specification = new Specification<GnDomain>() {
                @Override
                public Predicate toPredicate(Root<GnDomain> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    return cb.equal(root.get("id"), citizenDetailDTO.getGnDomainId());
                }
            };
            return gnDomainDao.findOne(specification);
    }*/

    private CitizenDetailDTO update(CitizenDetailDTO citizenDetailDTO){
        CitizenDetail citizenDetail= findByIdEntity(citizenDetailDTO.getId()).get();
//        CitizenDetail citizenDetail = getCitizenById(citizenDetailDTO.getCFamilyNo());

        try {
           CitizenDetailMapper.getInstance().dtoToDomain(citizenDetailDTO,citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(citizenDetail);
        return citizenDetailDTO;
    }
    private CitizenDetailDTO  save(CitizenDetailDTO citizenDetailDTO){
        CitizenDetail citizenDetail=new CitizenDetail();
        try {
            CitizenDetailMapper.getInstance().dtoToDomain(citizenDetailDTO,citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*setCommondata(citizenDetail,citizenDetailDTO);*/
        saveOrUpdate(citizenDetail);
        return citizenDetailDTO;
    }

  /* private void setCommondata(CitizenDetail citizenDetail,CitizenDetailDTO citizenDetailDTO ){
        setGnDomain(citizenDetailDTO,citizenDetail);
    }*/
    private void saveOrUpdate(CitizenDetail citizenDetail){
        citizenDetailDao.save(citizenDetail);
    }

    @Override
    public CitizenDetailDTO findById(Integer id) {
        CitizenDetail citizenDetail=findByIdEntity(id).get();
        CitizenDetailDTO citizenDetailDTO=new CitizenDetailDTO();
        try {
            citizenDetailDTO=CitizenDetailMapper.getInstance().domainToDto(citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizenDetailDTO;
    }


    public Optional<CitizenDetail> findByIdEntity(Integer id){
        Specification<CitizenDetail> specification = new Specification<CitizenDetail>() {
            @Override
            public Predicate toPredicate(Root<CitizenDetail> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return citizenDetailDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        citizenDetailDao.delete(findByIdEntity(id).get());
    }

   /* private  CitizenDetail getCitizenById(String c){
       return citizenDetailDao.findCitizenDetailById(c);
    }*/
}
