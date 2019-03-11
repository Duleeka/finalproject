package com.gn.app.service.primaryTask.CitizenDonation;

import com.gn.app.dto.primaryTask.CitizenDonation.CitizenDonationDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface CitizenDonationService {

    DataTablesOutput<CitizenDonationDTO> findAllDataTable(DataTablesInput input);

    List<CitizenDonationDTO> findAll();

    CitizenDonationDTO create (CitizenDonationDTO citizenDonation);

    CitizenDonationDTO findById (Integer id);

    void delete (Integer id);
}
