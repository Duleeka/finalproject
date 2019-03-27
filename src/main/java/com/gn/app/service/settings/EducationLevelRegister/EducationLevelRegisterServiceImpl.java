package com.gn.app.service.settings.EducationLevelRegister;

import com.gn.app.dao.settings.EducationLevelRegister.EducationLevelRegisterDao;
import com.gn.app.dao.settings.NationalityRegister.NationalityRegisterDao;
import com.gn.app.dto.settings.EducationLevelRegister.EducationLevelRegisterDTO;
import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import com.gn.app.mappers.settings.EducationLevelRegister.EducationLevelRegisterMapper;
import com.gn.app.mappers.settings.NationalityRegister.NationalityRegisterMapper;
import com.gn.app.model.Settings.EducationLevelRegister.EducationLevelRegister;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Service
public class EducationLevelRegisterServiceImpl implements EducationLevelRegisterService {

    @Autowired
    EducationLevelRegisterDao educationLevelRegisterDao;

    @Override
    public DataTablesOutput<EducationLevelRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<EducationLevelRegister> output = educationLevelRegisterDao.findAll(input);
        DataTablesOutput<EducationLevelRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = EducationLevelRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<EducationLevelRegisterDTO> findAll() {
        List<EducationLevelRegisterDTO> profiles = null;
        try {
            profiles= EducationLevelRegisterMapper.getInstance().domainToDTOList(educationLevelRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public EducationLevelRegisterDTO create(EducationLevelRegisterDTO educationLevelRegisterDTO) {


        if(educationLevelRegisterDTO.getId() != null){
            return update(educationLevelRegisterDTO);
        }else{
            return save(educationLevelRegisterDTO);
        }
    }
    private EducationLevelRegisterDTO update(EducationLevelRegisterDTO educationLevelRegisterDTO) {
        EducationLevelRegister educationLevelRegister = findByIdEntity(educationLevelRegisterDTO.getId()).get();
        try {
            EducationLevelRegisterMapper.getInstance().dtoToDomain(educationLevelRegisterDTO, educationLevelRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(educationLevelRegister);
        return educationLevelRegisterDTO;
    }

    private EducationLevelRegisterDTO save(EducationLevelRegisterDTO educationLevelRegisterDTO){
        EducationLevelRegister educationLevelRegister = new EducationLevelRegister();
        try {
            EducationLevelRegisterMapper.getInstance().dtoToDomain(educationLevelRegisterDTO, educationLevelRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(educationLevelRegister);
        return educationLevelRegisterDTO;
    }

    private void saveOrUpdate(EducationLevelRegister educationLevelRegister) {
        educationLevelRegisterDao.save(educationLevelRegister);
    }
    @Override
    public EducationLevelRegisterDTO findById(Integer id) {
        EducationLevelRegister educationLevelRegister = findByIdEntity(id).get();
        EducationLevelRegisterDTO educationLevelRegisterDTO = new EducationLevelRegisterDTO();
        try {
            educationLevelRegisterDTO = EducationLevelRegisterMapper.getInstance().domainToDto(educationLevelRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return educationLevelRegisterDTO;
    }

    public Optional<EducationLevelRegister> findByIdEntity(Integer id){
        Specification<EducationLevelRegister> specification = new Specification<EducationLevelRegister>() {
            @Override
            public Predicate toPredicate(Root<EducationLevelRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return educationLevelRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        educationLevelRegisterDao.delete(findByIdEntity(id).get());
    }

}

