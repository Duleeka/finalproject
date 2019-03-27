package com.gn.app.service.settings.WallDetailRegister;

import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.dto.settings.WallDetailRegister.WallDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface WallDetailRegisterService {
    DataTablesOutput<WallDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<WallDetailRegisterDTO> findAll();

    WallDetailRegisterDTO create(WallDetailRegisterDTO wallDetailRegister);

    WallDetailRegisterDTO findById(Integer id);

    void delete(Integer id);
}
