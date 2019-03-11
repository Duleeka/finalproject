package com.gn.app.dao.certificateIssuingTask.CertificateDetail;

import com.gn.app.model.certificateIssuingTask.CertificateDetail.CertificateDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateDetailDao extends DataTablesRepository<CertificateDetail,Integer> {
}
