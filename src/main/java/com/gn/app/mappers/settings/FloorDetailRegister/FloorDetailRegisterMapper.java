package com.gn.app.mappers.settings.FloorDetailRegister;

import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.mappers.settings.LandDetailRegister.LandDetailRegisterMapper;
import com.gn.app.model.Settings.FloorDetailRegister.FloorDetailRegister;

public class FloorDetailRegisterMapper extends GenericMapper<FloorDetailRegister, FloorDetailRegisterDTO> {

    private static FloorDetailRegisterMapper instance = null;


    public static FloorDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new FloorDetailRegisterMapper();
        }
        return instance;
    }



    @Override
    public FloorDetailRegisterDTO domainToDto(FloorDetailRegister floorDetailRegister) throws Exception {
        FloorDetailRegisterDTO dto = new FloorDetailRegisterDTO();
        dto.setId(floorDetailRegister.getId());
        dto.setVersion(floorDetailRegister.getVersion());
        dto.setFloorType(floorDetailRegister.getFloorType());
        dto.setFloorDescription(floorDetailRegister.getFloorDescription());

        return dto;
    }

    @Override
    public FloorDetailRegisterDTO domainToDtoForDataTable(FloorDetailRegister floorDetailRegister) throws Exception {
        FloorDetailRegisterDTO dto = new FloorDetailRegisterDTO();
        dto.setId(floorDetailRegister.getId());
        dto.setFloorType(floorDetailRegister.getFloorType());
        dto.setFloorDescription(floorDetailRegister.getFloorDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(FloorDetailRegisterDTO dto, FloorDetailRegister floorDetailRegister) throws Exception {
        floorDetailRegister.setVersion(dto.getVersion());
        floorDetailRegister.setId(dto.getId());
        floorDetailRegister.setFloorType(dto.getFloorType());
        floorDetailRegister.setFloorDescription(dto.getFloorDescription());

    }
}
