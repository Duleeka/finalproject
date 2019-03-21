package com.gn.app.service.primaryTask.CertificateDetail;

import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

/**
 * Created by hp on 1/7/2019.
 */
public interface CertificateDetailService {


    DataTablesOutput<CertificateDetailDTO> findAllDataTable(DataTablesInput input);

    List<CertificateDetailDTO> findAll();

    CertificateDetailDTO create(CertificateDetailDTO certificateDetail);

    CertificateDetailDTO findById(Integer id);

    void delete(Integer id);




}
