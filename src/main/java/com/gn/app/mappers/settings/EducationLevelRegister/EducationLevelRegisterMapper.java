package com.gn.app.mappers.settings.EducationLevelRegister;

import com.gn.app.dto.settings.EducationLevelRegister.EducationLevelRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.EducationLevelRegister.EducationLevelRegister;

public class EducationLevelRegisterMapper extends GenericMapper<EducationLevelRegister, EducationLevelRegisterDTO> {

    private static EducationLevelRegisterMapper instance = null;


    public static EducationLevelRegisterMapper getInstance() {
        if (instance == null) {
            instance = new EducationLevelRegisterMapper();
        }
        return instance;
    }

    @Override
    public EducationLevelRegisterDTO domainToDto(EducationLevelRegister educationLevelRegister) throws Exception {
        EducationLevelRegisterDTO dto= new EducationLevelRegisterDTO();
        dto.setId(educationLevelRegister.getId());
        dto.setVersion(educationLevelRegister.getVersion());
        dto.setEducationLevel(educationLevelRegister.getEducationLevel());
        dto.setDescription(educationLevelRegister.getDescription());
        return dto;
    }

    @Override
    public EducationLevelRegisterDTO domainToDtoForDataTable(EducationLevelRegister educationLevelRegister) throws Exception {
        EducationLevelRegisterDTO dto= new EducationLevelRegisterDTO();
        dto.setId(educationLevelRegister.getId());
        dto.setEducationLevel(educationLevelRegister.getEducationLevel());
        dto.setDescription(educationLevelRegister.getDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(EducationLevelRegisterDTO dto, EducationLevelRegister educationLevelRegister) throws Exception {
        educationLevelRegister.setVersion(dto.getVersion());
        educationLevelRegister.setId(dto.getId());
        educationLevelRegister.setEducationLevel(dto.getEducationLevel());
        educationLevelRegister.setDescription(dto.getDescription());
    }
}
