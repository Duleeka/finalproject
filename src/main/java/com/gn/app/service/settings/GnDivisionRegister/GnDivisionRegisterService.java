package com.gn.app.service.settings.GnDivisionRegister;

import com.gn.app.dto.settings.GnDivisionRegister.GnDivisionRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface GnDivisionRegisterService {
    DataTablesOutput<GnDivisionRegisterDTO> findAllDataTable(DataTablesInput input);

    List<GnDivisionRegisterDTO> findAll();

    GnDivisionRegisterDTO create (GnDivisionRegisterDTO gnDivisionRegister);

    GnDivisionRegisterDTO findById(Integer id);

    void delete (Integer id);
}
