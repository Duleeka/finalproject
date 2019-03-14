package com.gn.app.service.citizenProfileTask.DonationDetail;

import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface DonationDetailService {


    DataTablesOutput<DonationDetailDTO> findAllDataTable(DataTablesInput input);

    List<DonationDetailDTO> findAll();

    DonationDetailDTO create(DonationDetailDTO donationDetail);

    DonationDetailDTO findById(Integer id);

    void delete(Integer id);
}
