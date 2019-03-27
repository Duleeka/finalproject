package com.gn.app.service.settings.EducationLevelRegister;

import com.gn.app.dto.settings.EducationLevelRegister.EducationLevelRegisterDTO;
import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface EducationLevelRegisterService {

    DataTablesOutput<EducationLevelRegisterDTO> findAllDataTable(DataTablesInput input);

    List<EducationLevelRegisterDTO> findAll();

    EducationLevelRegisterDTO findById(Integer id);

    EducationLevelRegisterDTO create(EducationLevelRegisterDTO educationLevelRegisterDTO);


    void delete(Integer id);
}
