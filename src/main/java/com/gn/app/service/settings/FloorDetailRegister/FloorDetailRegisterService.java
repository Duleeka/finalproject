package com.gn.app.service.settings.FloorDetailRegister;

import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface FloorDetailRegisterService {
    DataTablesOutput<FloorDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<FloorDetailRegisterDTO> findAll();

    FloorDetailRegisterDTO create(FloorDetailRegisterDTO floorDetailRegisterDTO);

    FloorDetailRegisterDTO findById(Integer id);

    void delete(Integer id);
}
