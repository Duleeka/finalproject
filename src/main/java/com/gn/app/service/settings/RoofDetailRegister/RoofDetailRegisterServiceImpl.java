package com.gn.app.service.settings.RoofDetailRegister;

import com.gn.app.dao.settings.RoofDetailRegister.RoofDetailRegisterDao;
import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.dto.settings.RoofDetailRegister.RoofDetailRegisterDTO;
import com.gn.app.mappers.settings.LandDetailRegister.LandDetailRegisterMapper;
import com.gn.app.mappers.settings.RoofDetailRegister.RoofDetailRegisterMapper;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import com.gn.app.model.Settings.RoofDetailRegister.RoofDetailRegister;
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
public class RoofDetailRegisterServiceImpl implements RoofDetailRegisterService {

    @Autowired
    RoofDetailRegisterDao roofDetailRegisterDao;

    @Override
    public DataTablesOutput<RoofDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<RoofDetailRegister> output = roofDetailRegisterDao.findAll(input);
        DataTablesOutput<RoofDetailRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = RoofDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<RoofDetailRegisterDTO> findAll() {
        List<RoofDetailRegisterDTO> profiles = null;
        try {
            profiles= RoofDetailRegisterMapper.getInstance().domainToDTOList(roofDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public RoofDetailRegisterDTO create(RoofDetailRegisterDTO roofDetailRegisterDTO) {


        if(roofDetailRegisterDTO.getId() != null){
            return update(roofDetailRegisterDTO);
        }else{
            return save(roofDetailRegisterDTO);
        }
    }

    private RoofDetailRegisterDTO update(RoofDetailRegisterDTO roofDetailRegisterDTO) {
        RoofDetailRegister roofDetailRegister = findByIdEntity(roofDetailRegisterDTO.getId()).get();
        try {
            RoofDetailRegisterMapper.getInstance().dtoToDomain(roofDetailRegisterDTO, roofDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(roofDetailRegister);
        return roofDetailRegisterDTO;
    }

    private RoofDetailRegisterDTO save(RoofDetailRegisterDTO roofDetailRegisterDTO){
        RoofDetailRegister roofDetailRegister = new RoofDetailRegister();
        try {
            RoofDetailRegisterMapper.getInstance().dtoToDomain(roofDetailRegisterDTO, roofDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(roofDetailRegister);
        return roofDetailRegisterDTO;
    }

    private void saveOrUpdate(RoofDetailRegister roofDetailRegister)
    {
        roofDetailRegisterDao.save(roofDetailRegister);
    }

    @Override
    public RoofDetailRegisterDTO findById(Integer id) {
        RoofDetailRegister roofDetailRegister = findByIdEntity(id).get();
        RoofDetailRegisterDTO roofDetailRegisterDTO = new RoofDetailRegisterDTO();
        try {
            roofDetailRegisterDTO = RoofDetailRegisterMapper.getInstance().domainToDto(roofDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return roofDetailRegisterDTO;
    }

    public Optional<RoofDetailRegister> findByIdEntity(Integer id){
        Specification<RoofDetailRegister> specification = new Specification<RoofDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<RoofDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return roofDetailRegisterDao.findOne(specification);
    }
    @Override
    public void delete(Integer id) {
        roofDetailRegisterDao.delete(findByIdEntity(id).get());
    }
}
