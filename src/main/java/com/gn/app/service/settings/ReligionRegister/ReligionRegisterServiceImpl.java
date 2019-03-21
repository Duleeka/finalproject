package com.gn.app.service.settings.ReligionRegister;

import com.gn.app.dao.settings.ReligionRegister.ReligionRegisterDao;
import com.gn.app.dto.settings.ReligionRegister.ReligionRegisterDTO;
import com.gn.app.mappers.settings.ReligionRegister.ReligionRegisterMapper;
import com.gn.app.model.Settings.ReligionRegister.ReligionRegister;
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
public class ReligionRegisterServiceImpl implements ReligionRegisterService {

    @Autowired
    ReligionRegisterDao religionRegisterDao;

    @Override
    public DataTablesOutput<ReligionRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<ReligionRegister> output = religionRegisterDao.findAll(input);
        DataTablesOutput<ReligionRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = ReligionRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<ReligionRegisterDTO> findAll() {
        List<ReligionRegisterDTO> profiles = null;
        try {
            profiles= ReligionRegisterMapper.getInstance().domainToDTOList(religionRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public ReligionRegisterDTO create(ReligionRegisterDTO religionRegisterDTO) {


        if(religionRegisterDTO.getId() != null){
            return update(religionRegisterDTO);
        }else{
            return save(religionRegisterDTO);
        }
    }
    private ReligionRegisterDTO update(ReligionRegisterDTO religionRegisterDTO) {
        ReligionRegister religionRegister = findByIdEntity(religionRegisterDTO.getId()).get();
        try {
            ReligionRegisterMapper.getInstance().dtoToDomain(religionRegisterDTO, religionRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(religionRegister);
        return religionRegisterDTO;
    }

    private ReligionRegisterDTO save(ReligionRegisterDTO nationalityRegisterDTO){
        ReligionRegister religionRegister = new ReligionRegister();
        try {
            ReligionRegisterMapper.getInstance().dtoToDomain(nationalityRegisterDTO, religionRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(religionRegister);
        return nationalityRegisterDTO;
    }

    private void saveOrUpdate(ReligionRegister religionRegister) {
        religionRegisterDao.save(religionRegister);
    }
    @Override
    public ReligionRegisterDTO findById(Integer id) {
        ReligionRegister religionRegister = findByIdEntity(id).get();
        ReligionRegisterDTO religionRegisterDTO = new ReligionRegisterDTO();
        try {
            religionRegisterDTO = ReligionRegisterMapper.getInstance().domainToDto(religionRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return religionRegisterDTO;
    }

    public Optional<ReligionRegister> findByIdEntity(Integer id){
        Specification<ReligionRegister> specification = new Specification<ReligionRegister>() {
            @Override
            public Predicate toPredicate(Root<ReligionRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return religionRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        religionRegisterDao.delete(findByIdEntity(id).get());
    }

}

