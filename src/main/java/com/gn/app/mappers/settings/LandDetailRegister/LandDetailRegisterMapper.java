package com.gn.app.mappers.settings.LandDetailRegister;

import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;

public class LandDetailRegisterMapper extends GenericMapper<LandDetailRegister, LandDetailRegisterDTO> {

    private static LandDetailRegisterMapper instance = null;


    public static LandDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new LandDetailRegisterMapper();
        }
        return instance;
    }

    @Override
    public LandDetailRegisterDTO domainToDto(LandDetailRegister landDetailRegister) throws Exception {
        LandDetailRegisterDTO dto = new LandDetailRegisterDTO();
        dto.setId(landDetailRegister.getId());
        dto.setLandType(landDetailRegister.getLandType());
        dto.setLandName(landDetailRegister.getLandName());
        dto.setLandDescription(landDetailRegister.getLandDescription());
        dto.setVersion(landDetailRegister.getVersion());
        return dto;
    }

    @Override
    public LandDetailRegisterDTO domainToDtoForDataTable(LandDetailRegister landDetailRegister) throws Exception {
        LandDetailRegisterDTO dto = new LandDetailRegisterDTO();
        dto.setId(landDetailRegister.getId());
        dto.setLandType(landDetailRegister.getLandType());
        dto.setLandName(landDetailRegister.getLandName());
        dto.setLandDescription(landDetailRegister.getLandDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(LandDetailRegisterDTO dto, LandDetailRegister landDetailRegister) throws Exception {
        landDetailRegister.setId(dto.getId());
        landDetailRegister.setLandType(dto.getLandType());
        landDetailRegister.setLandName(dto.getLandName());
        landDetailRegister.setLandDescription(dto.getLandDescription());
        landDetailRegister.setVersion(dto.getVersion());
    }
}
