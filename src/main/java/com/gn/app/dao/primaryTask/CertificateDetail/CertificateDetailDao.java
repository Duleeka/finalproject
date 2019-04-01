package com.gn.app.dao.primaryTask.CertificateDetail;

import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetail;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificateDetailDao extends DataTablesRepository<CertificateDetail, Integer> {
}
