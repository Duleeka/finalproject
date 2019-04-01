package com.gn.app.mappers.settings.VehicleDetailRegister;

import com.gn.app.dto.settings.VehicleDetailRegister.VehicleDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.VehicleDetailRegister.VehicleDetailRegister;

public class VehicleDetailRegisterMapper extends GenericMapper<VehicleDetailRegister, VehicleDetailRegisterDTO> {

    private static VehicleDetailRegisterMapper instance = null;

    public static VehicleDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new VehicleDetailRegisterMapper();
        }
        return instance;
    }
    @Override
    public VehicleDetailRegisterDTO domainToDto(VehicleDetailRegister vehicleDetailRegister) throws Exception {
        VehicleDetailRegisterDTO dto = new VehicleDetailRegisterDTO();
        dto.setId(vehicleDetailRegister.getId());
        dto.setVersion(vehicleDetailRegister.getVersion());
        dto.setVehicleNo(vehicleDetailRegister.getVehicleNo());
        dto.setVehicleType(vehicleDetailRegister.getVehicleType());
        dto.setVehicleDescription(vehicleDetailRegister.getVehicleDescription());
        return dto;
    }

    @Override
    public VehicleDetailRegisterDTO domainToDtoForDataTable(VehicleDetailRegister vehicleDetailRegister) throws Exception {
        VehicleDetailRegisterDTO dto = new VehicleDetailRegisterDTO();
        dto.setId(vehicleDetailRegister.getId());
        dto.setVehicleNo(vehicleDetailRegister.getVehicleNo());
        dto.setVehicleType(vehicleDetailRegister.getVehicleType());
        dto.setVehicleDescription(vehicleDetailRegister.getVehicleDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(VehicleDetailRegisterDTO dto, VehicleDetailRegister vehicleDetailRegister) throws Exception {
        vehicleDetailRegister.setId(dto.getId());
        vehicleDetailRegister.setVersion(dto.getVersion());
        vehicleDetailRegister.setVehicleNo(dto.getVehicleNo());
        vehicleDetailRegister.setVehicleType(dto.getVehicleType());
        vehicleDetailRegister.setVehicleDescription(dto.getVehicleDescription());
    }
}
