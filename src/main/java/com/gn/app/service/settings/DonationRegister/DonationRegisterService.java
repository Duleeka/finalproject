package com.gn.app.service.settings.DonationRegister;

import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface DonationRegisterService {

    DataTablesOutput<DonationRegisterDTO> findAllDataTable(DataTablesInput input);

    List<DonationRegisterDTO> findAll();

    DonationRegisterDTO create(DonationRegisterDTO donationRegister);

    DonationRegisterDTO findById(Integer id);

    void delete(Integer id);
}
