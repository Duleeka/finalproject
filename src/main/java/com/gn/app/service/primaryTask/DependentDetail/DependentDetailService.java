package com.gn.app.service.primaryTask.DependentDetail;

import com.gn.app.dto.primaryTask.DependentDetail.DependentDetailDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface DependentDetailService {

    DataTablesOutput<DependentDetailDTO> findAllDataTable(DataTablesInput input);

    List<DependentDetailDTO> findAll();

    DependentDetailDTO create (DependentDetailDTO dependentDetail);

    DependentDetailDTO findById(Integer deid);

    void delete (Integer deid);


}
