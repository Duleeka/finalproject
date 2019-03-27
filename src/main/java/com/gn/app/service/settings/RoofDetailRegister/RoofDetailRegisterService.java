package com.gn.app.service.settings.RoofDetailRegister;

import com.gn.app.dto.settings.RoofDetailRegister.RoofDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface RoofDetailRegisterService {
    DataTablesOutput<RoofDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<RoofDetailRegisterDTO> findAll();

    RoofDetailRegisterDTO create (RoofDetailRegisterDTO roofDetailRegister);

    RoofDetailRegisterDTO findById (Integer id);

    void delete(Integer id);
}
