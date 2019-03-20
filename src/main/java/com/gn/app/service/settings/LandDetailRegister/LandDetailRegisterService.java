package com.gn.app.service.settings.LandDetailRegister;

import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface LandDetailRegisterService {
    DataTablesOutput<LandDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<LandDetailRegisterDTO> findAll();

    LandDetailRegisterDTO create (LandDetailRegisterDTO landDetailRegister);

    LandDetailRegisterDTO findById (Integer id);

    void delete(Integer id);
}
