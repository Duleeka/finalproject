package com.gn.app.service.settings.VehicleDetailRegister;

import com.gn.app.dao.settings.vehicleDetailRegister.VehicleDetailRegisterDao;
import com.gn.app.dto.settings.VehicleDetailRegister.VehicleDetailRegisterDTO;
import com.gn.app.mappers.settings.VehicleDetailRegister.VehicleDetailRegisterMapper;
import com.gn.app.model.Settings.VehicleDetailRegister.VehicleDetailRegister;
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
public class VehicleDetailRegisterServiceImpl implements VehicleDetailRegisterService {

    @Autowired
    VehicleDetailRegisterDao vehicleDetailRegisterDao;

    @Override
    public DataTablesOutput<VehicleDetailRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<VehicleDetailRegister> output = vehicleDetailRegisterDao.findAll(input);
        DataTablesOutput<VehicleDetailRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = VehicleDetailRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<VehicleDetailRegisterDTO> findAll() {
        List<VehicleDetailRegisterDTO> profiles = null;
        try {
            profiles= VehicleDetailRegisterMapper.getInstance().domainToDTOList(vehicleDetailRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public VehicleDetailRegisterDTO create(VehicleDetailRegisterDTO vehicleDetailRegisterDTO) {


        if(vehicleDetailRegisterDTO.getId() != null){
            return update(vehicleDetailRegisterDTO);
        }else{
            return save(vehicleDetailRegisterDTO);
        }
    }

    private VehicleDetailRegisterDTO update(VehicleDetailRegisterDTO vehicleDetailRegisterDTO) {
        VehicleDetailRegister vehicleDetailRegister = findByIdEntity(vehicleDetailRegisterDTO.getId()).get();
        try {
            VehicleDetailRegisterMapper.getInstance().dtoToDomain(vehicleDetailRegisterDTO, vehicleDetailRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(vehicleDetailRegister);
        return vehicleDetailRegisterDTO;
    }



    private VehicleDetailRegisterDTO save(VehicleDetailRegisterDTO vehicleDetailRegisterDTO){
        VehicleDetailRegister vehicleDetailRegister = new VehicleDetailRegister();
        try {
            VehicleDetailRegisterMapper.getInstance().dtoToDomain(vehicleDetailRegisterDTO, vehicleDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(vehicleDetailRegister);
        return vehicleDetailRegisterDTO;
    }

    private void saveOrUpdate(VehicleDetailRegister vehicleDetailRegister)
    {
        vehicleDetailRegisterDao.save(vehicleDetailRegister);
    }

    @Override
    public VehicleDetailRegisterDTO findById(Integer id) {
        VehicleDetailRegister vehicleDetailRegister = findByIdEntity(id).get();
        VehicleDetailRegisterDTO vehicleDetailRegisterDTO = new VehicleDetailRegisterDTO();
        try {
            vehicleDetailRegisterDTO = VehicleDetailRegisterMapper.getInstance().domainToDto(vehicleDetailRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return vehicleDetailRegisterDTO;
    }

    public Optional<VehicleDetailRegister> findByIdEntity(Integer id){
        Specification<VehicleDetailRegister> specification = new Specification<VehicleDetailRegister>() {
            @Override
            public Predicate toPredicate(Root<VehicleDetailRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return vehicleDetailRegisterDao.findOne(specification);
    }
    @Override
    public void delete(Integer id) {
        vehicleDetailRegisterDao.delete(findByIdEntity(id).get());

    }
}
