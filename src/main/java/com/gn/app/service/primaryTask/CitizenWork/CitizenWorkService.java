package com.gn.app.service.primaryTask.CitizenWork;

import com.gn.app.dto.primaryTask.CitizenWork.CitizenWorkDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface CitizenWorkService {
    DataTablesOutput<CitizenWorkDTO> findAllDataTable(DataTablesInput input);

    List<CitizenWorkDTO> findAll();

    CitizenWorkDTO create (CitizenWorkDTO citizenWork);

    CitizenWorkDTO findById (Integer sid);

    void delete(Integer sid);
}
