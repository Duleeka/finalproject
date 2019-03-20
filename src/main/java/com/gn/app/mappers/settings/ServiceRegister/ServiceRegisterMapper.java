package com.gn.app.mappers.settings.ServiceRegister;


import com.gn.app.dto.settings.ServiceRegister.ServiceRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;

public class ServiceRegisterMapper extends GenericMapper<ServiceRegister,ServiceRegisterDTO>{
    private static ServiceRegisterMapper instance = null;


    public static ServiceRegisterMapper getInstance() {
        if (instance == null) {
            instance = new ServiceRegisterMapper();
        }
        return instance;
    }

    @Override
    public ServiceRegisterDTO domainToDto(ServiceRegister serviceRegister) throws Exception {
        ServiceRegisterDTO dto = new ServiceRegisterDTO();
        dto.setId(serviceRegister.getId());
        dto.setServiceNo(serviceRegister.getServiceNo());
        dto.setServiceType(serviceRegister.getServiceType());
        dto.setVersion(serviceRegister.getVersion());

        return dto;
    }

    @Override
    public ServiceRegisterDTO domainToDtoForDataTable(ServiceRegister serviceRegister) throws Exception {
        ServiceRegisterDTO dto = new ServiceRegisterDTO();
        dto.setId(serviceRegister.getId());
        dto.setServiceNo(serviceRegister.getServiceNo());
        dto.setServiceType(serviceRegister.getServiceType());
        return dto;
    }

    @Override
    public void dtoToDomain(ServiceRegisterDTO dto, ServiceRegister serviceRegister) throws Exception {
        serviceRegister.setId(dto.getId());
        serviceRegister.setServiceNo(dto.getServiceNo());
        serviceRegister.setServiceType(dto.getServiceType());
        serviceRegister.setVersion(dto.getVersion());
    }
}
