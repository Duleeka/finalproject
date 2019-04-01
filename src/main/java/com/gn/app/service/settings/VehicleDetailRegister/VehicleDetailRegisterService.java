package com.gn.app.service.settings.VehicleDetailRegister;

import com.gn.app.dto.settings.VehicleDetailRegister.VehicleDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface VehicleDetailRegisterService {
    DataTablesOutput<VehicleDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<VehicleDetailRegisterDTO> findAll();

    VehicleDetailRegisterDTO create(VehicleDetailRegisterDTO vehicleDetailRegister);

    VehicleDetailRegisterDTO findById(Integer id);

    void delete(Integer id);


}
