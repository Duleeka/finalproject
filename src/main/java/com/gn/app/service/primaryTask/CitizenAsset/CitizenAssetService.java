package com.gn.app.service.primaryTask.CitizenAsset;

import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface CitizenAssetService {

    DataTablesOutput<CitizenAssetDTO> findAllDataTable(DataTablesInput input);

    List<CitizenAssetDTO> findAll();

    CitizenAssetDTO create(CitizenAssetDTO citizenAsset);

    CitizenAssetDTO findById(Integer id);

    void delete(Integer id);
}
