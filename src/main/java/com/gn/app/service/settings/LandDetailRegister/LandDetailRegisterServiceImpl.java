package com.gn.app.service.settings.LandDetailRegister;

import com.gn.app.dao.settings.LandDetailRegister.LandDetailRegisterDao;
import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.mappers.settings.LandDetailRegister.LandDetailRegisterMapper;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
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
public class LandDetailRegisterServiceImpl implements LandDetailRegisterService {

    @Autowired
    LandDetailRegisterDao landDetailRegisterDao;

    @Override
    public DataTablesOutput<LandDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<LandDetailRegister> output = landDetailRegisterDao.findAll(input);
        DataTablesOutput<LandDetailRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = LandDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<LandDetailRegisterDTO> findAll() {
        List<LandDetailRegisterDTO> profiles = null;
        try {
            profiles= LandDetailRegisterMapper.getInstance().domainToDTOList(landDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public LandDetailRegisterDTO create(LandDetailRegisterDTO landDetailRegisterDTO) {


        if(landDetailRegisterDTO.getId() != null){
            return update(landDetailRegisterDTO);
        }else{
            return save(landDetailRegisterDTO);
        }
    }
    private LandDetailRegisterDTO update(LandDetailRegisterDTO landDetailRegisterDTO) {
        LandDetailRegister landDetailRegister = findByIdEntity(landDetailRegisterDTO.getId()).get();
        try {
            LandDetailRegisterMapper.getInstance().dtoToDomain(landDetailRegisterDTO, landDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(landDetailRegister);
        return landDetailRegisterDTO;
    }

    private LandDetailRegisterDTO save(LandDetailRegisterDTO landDetailRegisterDTO){
        LandDetailRegister landDetailRegister = new LandDetailRegister();
        try {
            LandDetailRegisterMapper.getInstance().dtoToDomain(landDetailRegisterDTO, landDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(landDetailRegister);
        return landDetailRegisterDTO;
    }

    private void saveOrUpdate(LandDetailRegister landDetailRegister)
    {
        landDetailRegisterDao.save(landDetailRegister);
    }

    @Override
    public LandDetailRegisterDTO findById(Integer id) {
        LandDetailRegister landDetailRegister = findByIdEntity(id).get();
        LandDetailRegisterDTO landDetailRegisterDTO = new LandDetailRegisterDTO();
        try {
            landDetailRegisterDTO = LandDetailRegisterMapper.getInstance().domainToDto(landDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return landDetailRegisterDTO;
    }

    public Optional<LandDetailRegister> findByIdEntity(Integer id){
        Specification<LandDetailRegister> specification = new Specification<LandDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<LandDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return landDetailRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {landDetailRegisterDao.delete(findByIdEntity(id).get());
    }
}
