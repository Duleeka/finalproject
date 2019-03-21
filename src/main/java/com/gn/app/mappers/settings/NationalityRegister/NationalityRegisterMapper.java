package com.gn.app.mappers.settings.NationalityRegister;

import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;

public class NationalityRegisterMapper extends GenericMapper<NationalityRegister, NationalityRegisterDTO> {
    private static NationalityRegisterMapper instance = null;


    public static NationalityRegisterMapper getInstance() {
        if (instance == null) {
            instance = new NationalityRegisterMapper();
        }
        return instance;
    }
    @Override
    public NationalityRegisterDTO domainToDto(NationalityRegister nationalityRegister) throws Exception {
        NationalityRegisterDTO dto = new NationalityRegisterDTO();
        dto.setId(nationalityRegister.getId());
        dto.setNationalityType(nationalityRegister.getNationalityType());
        dto.setNationalityDescription(nationalityRegister.getNationalityDescription());
        dto.setVersion(nationalityRegister.getVersion());
        return dto;
    }

    @Override
    public NationalityRegisterDTO domainToDtoForDataTable(NationalityRegister nationalityRegister) throws Exception {
        NationalityRegisterDTO dto = new NationalityRegisterDTO();
        dto.setId(nationalityRegister.getId());
        dto.setNationalityType(nationalityRegister.getNationalityType());
        dto.setNationalityDescription(nationalityRegister.getNationalityDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(NationalityRegisterDTO dto, NationalityRegister nationalityRegister) throws Exception {
        nationalityRegister.setId(dto.getId());
        nationalityRegister.setNationalityType(dto.getNationalityType());
        nationalityRegister.setNationalityDescription(dto.getNationalityDescription());
        nationalityRegister.setVersion(dto.getVersion());
    }
}
