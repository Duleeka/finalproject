package com.gn.app.service.settings.NationalityRegister;

import com.gn.app.dao.settings.NationalityRegister.NationalityRegisterDao;
import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import com.gn.app.mappers.settings.NationalityRegister.NationalityRegisterMapper;
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
public class NationalityRegisterServiceImpl implements NationalityRegisterService  {

    @Autowired
    NationalityRegisterDao nationalityRegisterDao;

    @Override
    public DataTablesOutput<NationalityRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<NationalityRegister> output = nationalityRegisterDao.findAll(input);
        DataTablesOutput<NationalityRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = NationalityRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }


    @Override
    public List<NationalityRegisterDTO> findAll() {
        List<NationalityRegisterDTO> profiles = null;
        try {
            profiles= NationalityRegisterMapper.getInstance().domainToDTOList(nationalityRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public NationalityRegisterDTO create(NationalityRegisterDTO nationalityRegisterDTO) {


        if(nationalityRegisterDTO.getId() != null){
            return update(nationalityRegisterDTO);
        }else{
            return save(nationalityRegisterDTO);
        }
    }
    private NationalityRegisterDTO update(NationalityRegisterDTO nationalityRegisterDTO) {
        NationalityRegister nationalityRegister = findByIdEntity(nationalityRegisterDTO.getId()).get();
        try {
            NationalityRegisterMapper.getInstance().dtoToDomain(nationalityRegisterDTO, nationalityRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(nationalityRegister);
        return nationalityRegisterDTO;
    }

    private NationalityRegisterDTO save(NationalityRegisterDTO nationalityRegisterDTO){
        NationalityRegister nationalityRegister = new NationalityRegister();
        try {
            NationalityRegisterMapper.getInstance().dtoToDomain(nationalityRegisterDTO, nationalityRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(nationalityRegister);
        return nationalityRegisterDTO;
    }

    private void saveOrUpdate(NationalityRegister nationalityRegister) {
        nationalityRegisterDao.save(nationalityRegister);
    }
    @Override
    public NationalityRegisterDTO findById(Integer id) {
        NationalityRegister nationalityRegister = findByIdEntity(id).get();
        NationalityRegisterDTO nationalityRegisterDTO = new NationalityRegisterDTO();
        try {
            nationalityRegisterDTO = NationalityRegisterMapper.getInstance().domainToDto(nationalityRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return nationalityRegisterDTO;
    }

    public Optional<NationalityRegister> findByIdEntity(Integer id){
        Specification<NationalityRegister> specification = new Specification<NationalityRegister>() {
            @Override
            public Predicate toPredicate(Root<NationalityRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return nationalityRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        nationalityRegisterDao.delete(findByIdEntity(id).get());
    }

    }

