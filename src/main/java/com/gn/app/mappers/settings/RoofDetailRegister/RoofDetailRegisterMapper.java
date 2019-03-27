package com.gn.app.mappers.settings.RoofDetailRegister;

import com.gn.app.dto.settings.RoofDetailRegister.RoofDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.RoofDetailRegister.RoofDetailRegister;

public class RoofDetailRegisterMapper extends GenericMapper<RoofDetailRegister, RoofDetailRegisterDTO> {

    private static RoofDetailRegisterMapper instance = null;


    public static RoofDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new RoofDetailRegisterMapper();
        }
        return instance;
    }

    @Override
    public RoofDetailRegisterDTO domainToDto(RoofDetailRegister roofDetailRegister) throws Exception {
        RoofDetailRegisterDTO dto = new RoofDetailRegisterDTO();
        dto.setVersion(roofDetailRegister.getVersion());
        dto.setId(roofDetailRegister.getId());
        dto.setRoofType(roofDetailRegister.getRoofType());
        dto.setRoofDescription(roofDetailRegister.getRoofDescription());
        return dto;
    }

    @Override
    public RoofDetailRegisterDTO domainToDtoForDataTable(RoofDetailRegister roofDetailRegister) throws Exception {
        RoofDetailRegisterDTO dto = new RoofDetailRegisterDTO();
        dto.setId(roofDetailRegister.getId());
        dto.setRoofType(roofDetailRegister.getRoofType());
        dto.setRoofDescription(roofDetailRegister.getRoofDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(RoofDetailRegisterDTO dto, RoofDetailRegister roofDetailRegister) throws Exception {
        roofDetailRegister.setVersion(dto.getVersion());
        roofDetailRegister.setId(dto.getId());
        roofDetailRegister.setRoofType(dto.getRoofType());
        roofDetailRegister.setRoofDescription(dto.getRoofDescription());
    }
}
