package com.gn.app.service.settings.ReligionRegister;

import com.gn.app.dto.settings.ReligionRegister.ReligionRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface ReligionRegisterService {
    DataTablesOutput<ReligionRegisterDTO> findAllDataTable(DataTablesInput input);

    List<ReligionRegisterDTO> findAll();

    ReligionRegisterDTO create(ReligionRegisterDTO religionRegisterDTO);

    ReligionRegisterDTO findById(Integer id);

    void delete(Integer id);
}
