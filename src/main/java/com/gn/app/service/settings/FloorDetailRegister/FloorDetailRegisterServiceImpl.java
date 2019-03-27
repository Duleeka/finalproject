package com.gn.app.service.settings.FloorDetailRegister;


import com.gn.app.dao.settings.FloorDetailRegister.FloorDetailRegisterDao;
import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.mappers.settings.FloorDetailRegister.FloorDetailRegisterMapper;
import com.gn.app.mappers.settings.LandDetailRegister.LandDetailRegisterMapper;
import com.gn.app.model.Settings.FloorDetailRegister.FloorDetailRegister;
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
public class FloorDetailRegisterServiceImpl implements FloorDetailRegisterService {

    @Autowired
    FloorDetailRegisterDao floorDetailRegisterDao;

    @Override
    public DataTablesOutput<FloorDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<FloorDetailRegister> output = floorDetailRegisterDao.findAll(input);
        DataTablesOutput<FloorDetailRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = FloorDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<FloorDetailRegisterDTO> findAll() {
        List<FloorDetailRegisterDTO> profiles = null;
        try {
            profiles= FloorDetailRegisterMapper.getInstance().domainToDTOList(floorDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }


    @Override
    public FloorDetailRegisterDTO create(FloorDetailRegisterDTO floorDetailRegisterDTO) {
        if(floorDetailRegisterDTO.getId() != null){
            return update(floorDetailRegisterDTO);
        }else{
            return save(floorDetailRegisterDTO);
        }
    }

    private FloorDetailRegisterDTO update(FloorDetailRegisterDTO floorDetailRegisterDTO) {
        FloorDetailRegister floorDetailRegister = findByIdEntity(floorDetailRegisterDTO.getId()).get();
        try {
            FloorDetailRegisterMapper.getInstance().dtoToDomain(floorDetailRegisterDTO, floorDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(floorDetailRegister);
        return floorDetailRegisterDTO;

    }

    private FloorDetailRegisterDTO save(FloorDetailRegisterDTO floorDetailRegisterDTO) {
        FloorDetailRegister floorDetailRegister = new FloorDetailRegister();
        try {
            FloorDetailRegisterMapper.getInstance().dtoToDomain(floorDetailRegisterDTO, floorDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(floorDetailRegister);
        return floorDetailRegisterDTO;
    }

    private void saveOrUpdate(FloorDetailRegister floorDetailRegister) {
        floorDetailRegisterDao.save(floorDetailRegister);
    }

    @Override
    public FloorDetailRegisterDTO findById(Integer id) {
        FloorDetailRegister floorDetailRegister = findByIdEntity(id).get();
        FloorDetailRegisterDTO floorDetailRegisterDTO = new FloorDetailRegisterDTO();
        try {
            floorDetailRegisterDTO = FloorDetailRegisterMapper.getInstance().domainToDto(floorDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return floorDetailRegisterDTO;
    }
    public Optional<FloorDetailRegister> findByIdEntity(Integer id){
        Specification<FloorDetailRegister> specification = new Specification<FloorDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<FloorDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return floorDetailRegisterDao.findOne(specification);
    }
    @Override
    public void delete(Integer id) {
        floorDetailRegisterDao.delete(findByIdEntity(id).get());
    }
}
