package com.gn.app.service.AdministrativeTask.GnDomain;

import com.gn.app.dto.administrativeTask.GnDomain.GnDomainDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface GnDomainService {
    DataTablesOutput<GnDomainDTO> findAllDataTable(DataTablesInput input);

    List<GnDomainDTO> findAll();

    GnDomainDTO create(GnDomainDTO gnDomainDTO);

    GnDomainDTO findById(Integer id);

    void delete(Integer id);
}
