package com.gn.app.service.settings.CertificateDetailRegister;

import com.gn.app.dto.settings.CertificateDetailRegister.CertificateDetailRegisterDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

public interface CertificateDetailRegisterService {

    DataTablesOutput<CertificateDetailRegisterDTO> findAllDataTable(DataTablesInput input);

    List<CertificateDetailRegisterDTO> findAll();

    CertificateDetailRegisterDTO create(CertificateDetailRegisterDTO certificateDetailRegister);

    CertificateDetailRegisterDTO findById(Integer id);

    void delete(Integer id);

}
