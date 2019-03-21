package com.gn.app.service.settings.NationalityRegister;

import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface NationalityRegisterService {
    DataTablesOutput<NationalityRegisterDTO> findAllDataTable(DataTablesInput input);

    List<NationalityRegisterDTO> findAll();

    NationalityRegisterDTO create (NationalityRegisterDTO nationalityRegister);

    NationalityRegisterDTO findById (Integer id);

    void delete(Integer id);
}
