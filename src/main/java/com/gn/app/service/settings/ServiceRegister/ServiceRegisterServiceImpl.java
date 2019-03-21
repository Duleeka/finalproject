package com.gn.app.service.settings.ServiceRegister;


import com.gn.app.dao.settings.ServiceRegister.ServiceRegisterDao;
import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.dto.settings.ServiceRegister.ServiceRegisterDTO;
import com.gn.app.mappers.citizenProfileTask.CitizenWork.CitizenWorkMapper;
import com.gn.app.mappers.settings.ServiceRegister.ServiceRegisterMapper;
import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;
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
public class ServiceRegisterServiceImpl implements ServiceRegisterService {

    @Autowired
    ServiceRegisterDao serviceRegisterDao;

    @Override
    public DataTablesOutput<ServiceRegisterDTO> findAllDataTable(DataTablesInput input) {
        DataTablesOutput<ServiceRegister> output = serviceRegisterDao.findAll(input);
        DataTablesOutput<ServiceRegisterDTO> dataTablesOutput = null;
        try {
            dataTablesOutput = ServiceRegisterMapper.getInstance().domainToDTODataTablesOutput(output);
        }catch (Exception e){
            e.printStackTrace();
        }
        return dataTablesOutput;
    }

    @Override
    public List<ServiceRegisterDTO> findAll() {
        List<ServiceRegisterDTO> profiles = null;
        try {
            profiles= ServiceRegisterMapper.getInstance().domainToDTOList(serviceRegisterDao.findAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        return profiles;
    }

    @Override
    public ServiceRegisterDTO create(ServiceRegisterDTO serviceRegisterDTO) {


        if(serviceRegisterDTO.getId() != null){
            return update(serviceRegisterDTO);
        }else{
            return save(serviceRegisterDTO);
        }
    }
    private ServiceRegisterDTO update(ServiceRegisterDTO serviceRegisterDTO) {
        ServiceRegister serviceRegister = findByIdEntity(serviceRegisterDTO.getId()).get();
        try {
            ServiceRegisterMapper.getInstance().dtoToDomain(serviceRegisterDTO, serviceRegister);
        } catch (Exception e) {
            e.printStackTrace();
        }

        saveOrUpdate(serviceRegister);
        return serviceRegisterDTO;
    }

    private ServiceRegisterDTO save(ServiceRegisterDTO serviceRegisterDTO){
        ServiceRegister serviceRegister = new ServiceRegister();
        try {
            ServiceRegisterMapper.getInstance().dtoToDomain(serviceRegisterDTO, serviceRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        saveOrUpdate(serviceRegister);
        return serviceRegisterDTO;
    }

    private void saveOrUpdate(ServiceRegister serviceRegister) {
        serviceRegisterDao.save(serviceRegister);
    }

    @Override
    public ServiceRegisterDTO findById(Integer id) {
        ServiceRegister serviceRegister = findByIdEntity(id).get();
        ServiceRegisterDTO serviceRegisterDTO = new ServiceRegisterDTO();
        try {
            serviceRegisterDTO = ServiceRegisterMapper.getInstance().domainToDto(serviceRegister);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serviceRegisterDTO;
    }

    public Optional<ServiceRegister> findByIdEntity(Integer id){
        Specification<ServiceRegister> specification = new Specification<ServiceRegister>() {
            @Override
            public Predicate toPredicate(Root<ServiceRegister> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.equal(root.get("id"), id);
            }
        };
        return serviceRegisterDao.findOne(specification);
    }

    @Override
    public void delete(Integer id) {
        serviceRegisterDao.delete(findByIdEntity(id).get());
    }
}
