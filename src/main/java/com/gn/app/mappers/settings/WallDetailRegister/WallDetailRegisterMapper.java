package com.gn.app.mappers.settings.WallDetailRegister;

import com.gn.app.dto.settings.WallDetailRegister.WallDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.mappers.settings.RoofDetailRegister.RoofDetailRegisterMapper;
import com.gn.app.model.Settings.WallDetailRegister.WallDetailRegister;

public class WallDetailRegisterMapper extends GenericMapper<WallDetailRegister, WallDetailRegisterDTO> {

    private static WallDetailRegisterMapper instance = null;


    public static WallDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new WallDetailRegisterMapper();
        }
        return instance;
    }

    @Override
    public WallDetailRegisterDTO domainToDto(WallDetailRegister wallDetailRegister) throws Exception {
        WallDetailRegisterDTO dto = new WallDetailRegisterDTO();
        dto.setVersion(wallDetailRegister.getVersion());
        dto.setId(wallDetailRegister.getId());
        dto.setWallType(wallDetailRegister.getWallType());
        dto.setWallDescription(wallDetailRegister.getWallDescription());
        return dto;
    }

    @Override
    public WallDetailRegisterDTO domainToDtoForDataTable(WallDetailRegister wallDetailRegister) throws Exception {
        WallDetailRegisterDTO dto = new WallDetailRegisterDTO();
        dto.setId(wallDetailRegister.getId());
        dto.setWallType(wallDetailRegister.getWallType());
        dto.setWallDescription(wallDetailRegister.getWallDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(WallDetailRegisterDTO dto, WallDetailRegister wallDetailRegister) throws Exception {
        wallDetailRegister.setVersion(dto.getVersion());
        wallDetailRegister.setId(dto.getId());
        wallDetailRegister.setWallType(dto.getWallType());
        wallDetailRegister.setWallDescription(dto.getWallDescription());
    }
}
