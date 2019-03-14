package com.gn.app.service.citizenProfileTask.CitizenDetail;

import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface CitizenDetailService {

    DataTablesOutput<CitizenDetailDTO> findAllDataTable(DataTablesInput input);

    List<CitizenDetailDTO> findAll();

    CitizenDetailDTO create(CitizenDetailDTO citizenDetail);

    CitizenDetailDTO findById(Integer id);

    void delete(Integer id);
}
