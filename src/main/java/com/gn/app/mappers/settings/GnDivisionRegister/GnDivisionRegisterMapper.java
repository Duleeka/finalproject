package com.gn.app.mappers.settings.GnDivisionRegister;

import com.gn.app.dto.settings.GnDivisionRegister.GnDivisionRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;

public class GnDivisionRegisterMapper extends GenericMapper<GnDivisionRegister, GnDivisionRegisterDTO> {

    private static GnDivisionRegisterMapper instance = null;


    public static GnDivisionRegisterMapper getInstance() {
        if (instance == null) {
            instance = new GnDivisionRegisterMapper();
        }
        return instance;
    }


    @Override
    public GnDivisionRegisterDTO domainToDto(GnDivisionRegister gnDivisionRegister) throws Exception {
        GnDivisionRegisterDTO dto= new GnDivisionRegisterDTO();
        dto.setId(gnDivisionRegister.getId());
        dto.setVersion(gnDivisionRegister.getVersion());
        dto.setDivisionNo(gnDivisionRegister.getDivisionNo());
        dto.setDivisionName(gnDivisionRegister.getDivisionName());
        dto.setDescription(gnDivisionRegister.getDescription());
        return dto;
    }

    @Override
    public GnDivisionRegisterDTO domainToDtoForDataTable(GnDivisionRegister gnDivisionRegister) throws Exception {
        GnDivisionRegisterDTO dto= new GnDivisionRegisterDTO();
        dto.setId(gnDivisionRegister.getId());
        dto.setVersion(gnDivisionRegister.getVersion());
        dto.setDivisionNo(gnDivisionRegister.getDivisionNo());
        dto.setDivisionName(gnDivisionRegister.getDivisionName());
        return dto;
    }

    @Override
    public void dtoToDomain(GnDivisionRegisterDTO dto, GnDivisionRegister gnDivisionRegister) throws Exception {
        gnDivisionRegister.setId(dto.getId());
        gnDivisionRegister.setVersion(dto.getVersion());
        gnDivisionRegister.setDivisionNo(dto.getDivisionNo());
        gnDivisionRegister.setDivisionName(dto.getDivisionName());
        gnDivisionRegister.setDescription(dto.getDescription());
    }
}
