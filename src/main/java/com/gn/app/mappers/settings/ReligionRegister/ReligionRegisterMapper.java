package com.gn.app.mappers.settings.ReligionRegister;


import com.gn.app.dto.settings.ReligionRegister.ReligionRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.ReligionRegister.ReligionRegister;

public class ReligionRegisterMapper extends GenericMapper<ReligionRegister, ReligionRegisterDTO>{
    private static ReligionRegisterMapper instance = null;


    public static ReligionRegisterMapper getInstance() {
        if (instance == null) {
            instance = new ReligionRegisterMapper();
        }
        return instance;
    }

    @Override
    public ReligionRegisterDTO domainToDto(ReligionRegister religionRegister) throws Exception {
        ReligionRegisterDTO dto = new ReligionRegisterDTO();
        dto.setId(religionRegister.getId());
        dto.setReligionType(religionRegister.getReligionType());
        dto.setReligionDescription(religionRegister.getReligionDescription());
        dto.setVersion(religionRegister.getVersion());

        return dto;
    }

    @Override
    public ReligionRegisterDTO domainToDtoForDataTable(ReligionRegister religionRegister) throws Exception {
        ReligionRegisterDTO dto = new ReligionRegisterDTO();
        dto.setId(religionRegister.getId());
        dto.setReligionType(religionRegister.getReligionType());
        dto.setReligionDescription(religionRegister.getReligionDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(ReligionRegisterDTO dto, ReligionRegister religionRegister) throws Exception {
        religionRegister.setId(dto.getId());
        religionRegister.setReligionType(dto.getReligionType());
        religionRegister.setReligionDescription(dto.getReligionDescription());
        religionRegister.setVersion(dto.getVersion());
    }
}
