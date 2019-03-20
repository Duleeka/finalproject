package com.gn.app.service.settings.ServiceRegister;

import com.gn.app.dto.settings.ServiceRegister.ServiceRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface ServiceRegisterService {
    DataTablesOutput<ServiceRegisterDTO> findAllDataTable(DataTablesInput input);

    List<ServiceRegisterDTO> findAll();

    ServiceRegisterDTO create (ServiceRegisterDTO serviceRegister);

    ServiceRegisterDTO findById (Integer id);

    void delete(Integer id);
}
