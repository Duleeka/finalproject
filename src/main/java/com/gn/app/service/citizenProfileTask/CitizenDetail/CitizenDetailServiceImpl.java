package com.gn.app.service.citizenProfileTask.CitizenDetail;

import com.gn.app.dao.citizenProfileTask.CitizenDetail.CitizenDetailDao;
import com.gn.app.dao.settings.EducationLevelRegister.EducationLevelRegisterDao;
import com.gn.app.dao.settings.GnDivisionRegister.GnDivisionRegisterDao;
import com.gn.app.dao.settings.NationalityRegister.NationalityRegisterDao;
import com.gn.app.dao.settings.ReligionRegister.ReligionRegisterDao;
import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.mappers.citizenProfileTask.CitizenDetail.CitizenDetailMapper;
import com.gn.app.model.Settings.EducationLevelRegister.EducationLevelRegister;
import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import com.gn.app.model.Settings.ReligionRegister.ReligionRegister;
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

    @Autowired
    NationalityRegisterDao nationalityRegisterDao;

    @Autowired
    ReligionRegisterDao religionRegisterDao;

    @Autowired
    GnDivisionRegisterDao gnDivisionRegisterDao;

    @Autowired
    EducationLevelRegisterDao educationLevelRegisterDao;


    @Override
    @Transactional(readOnly = true)
    public DataTablesOutput<CitizenDetailDTO> findAllDataTable(DataTablesInput input) {

        DataTablesOutput<CitizenDetail> output = citizenDetailDao.findAll(input);
        DataTablesOutput<CitizenDetailDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = CitizenDetailMapper.getInstance().domainToDTODataTablesOutput(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<CitizenDetailDTO> findAll() {
        List<CitizenDetailDTO> profiles = null;
        try {
            profiles = CitizenDetailMapper.getInstance().domainToDTOList(citizenDetailDao.findAll());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public CitizenDetailDTO create(CitizenDetailDTO citizenDetailDTO) {


        if (citizenDetailDTO.getId() != null) {
            return update(citizenDetailDTO);
        } else {
            return save(citizenDetailDTO);
        }


    }

    private CitizenDetailDTO update(CitizenDetailDTO citizenDetailDTO) {
        CitizenDetail citizenDetail = findByIdEntity(citizenDetailDTO.getId()).get();

        try {
            CitizenDetailMapper.getInstance().dtoToDomain(citizenDetailDTO, citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveOrUpdate(citizenDetail);
        return citizenDetailDTO;
    }

    private CitizenDetailDTO save(CitizenDetailDTO citizenDetailDTO) {
        CitizenDetail citizenDetail = new CitizenDetail();
        try {
            CitizenDetailMapper.getInstance().dtoToDomain(citizenDetailDTO, citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setCommonData(citizenDetail, citizenDetailDTO);
        saveOrUpdate(citizenDetail);
        return citizenDetailDTO;
    }

    private void setCommonData(CitizenDetail citizenDetail, CitizenDetailDTO citizenDetailDTO) {
        setNationalityRegister(citizenDetail, citizenDetailDTO);
        setReligionRegister(citizenDetail, citizenDetailDTO);

        setGnDivisionRegister(citizenDetail, citizenDetailDTO);

        setEducationLevelRegister(citizenDetail,citizenDetailDTO);
    }

    /*RELATIONSHIP OF NATIONALITY & CITIZEN*/

    private void setNationalityRegister(CitizenDetail citizenDetail, CitizenDetailDTO citizenDetailDTO) {

        if(citizenDetailDTO != null && citizenDetailDTO.getNationalityId()!=null) {

        citizenDetail.setNationalityRegister(nationalityRegisterDao.findOne(findNationalityRegisterSpecification
                (citizenDetailDTO.getNationalityId())).get());
    }}

    private Specification<NationalityRegister> findNationalityRegisterSpecification(Integer id) {
        Specification<NationalityRegister> specification = new Specification<NationalityRegister>() {
            @Override
            public Predicate toPredicate(Root<NationalityRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);

            }
        };
        return specification;
    }


/*RELATIONSHIP OF RELIGION & CITIZEN*/

    private void setReligionRegister(CitizenDetail citizenDetail, CitizenDetailDTO citizenDetailDTO){

        if(citizenDetailDTO != null && citizenDetailDTO.getReligionId()!=null) {

        citizenDetail.setReligionRegister(religionRegisterDao.findOne(findReligionRegisterSpecification(citizenDetailDTO.getReligionId())).get());
    }}

    private Specification<ReligionRegister> findReligionRegisterSpecification(Integer religionId) {
        Specification<ReligionRegister> specification = new Specification<ReligionRegister>() {
            @Override
            public Predicate toPredicate(Root<ReligionRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), religionId);
            }
        };
        return specification;
    }


/*RELATIONSHIP OF GN DIVISION & CITIZEN*/
    private void setGnDivisionRegister(CitizenDetail citizenDetail, CitizenDetailDTO citizenDetailDTO) {

        if(citizenDetailDTO != null && citizenDetailDTO.getGnDivisionId()!=null) {

        citizenDetail.setGnDivisionRegister(gnDivisionRegisterDao.findOne(findGnDivisionRegisterSpecification
                (citizenDetailDTO.getGnDivisionId())).get());
    }}


    private Specification<GnDivisionRegister> findGnDivisionRegisterSpecification(Integer id) {
        Specification<GnDivisionRegister> specification = new Specification<GnDivisionRegister>() {
            @Override
            public Predicate toPredicate(Root<GnDivisionRegister> root, CriteriaQuery<?>
                    criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return specification;
    }
/*END OF RELETIONSHIP OF DIVISION & CITIZEN*/

    private void setEducationLevelRegister(CitizenDetail citizenDetail, CitizenDetailDTO citizenDetailDTO) {

        if(citizenDetailDTO != null && citizenDetailDTO.getEducationId()!=null) {

        citizenDetail.setEducationLevelRegister(educationLevelRegisterDao.findOne(findEducationLevelRegisterSpecification
                (citizenDetailDTO.getEducationId())).get());
    }}

    private Specification<EducationLevelRegister> findEducationLevelRegisterSpecification(Integer educationId) {
        Specification<EducationLevelRegister> specification = new Specification<EducationLevelRegister>() {
            @Override
            public Predicate toPredicate(Root<EducationLevelRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"),educationId);
            }
        };
        return specification;
    }

    private void saveOrUpdate(CitizenDetail citizenDetail) {
        citizenDetailDao.save(citizenDetail);
    }

    @Override
    public CitizenDetailDTO findById(Integer id) {
        CitizenDetail citizenDetail = findByIdEntity(id).get();
        CitizenDetailDTO citizenDetailDTO = new CitizenDetailDTO();
        try {
            citizenDetailDTO = CitizenDetailMapper.getInstance().domainToDto(citizenDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return citizenDetailDTO;
    }


    public Optional<CitizenDetail> findByIdEntity(Integer id) {
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
