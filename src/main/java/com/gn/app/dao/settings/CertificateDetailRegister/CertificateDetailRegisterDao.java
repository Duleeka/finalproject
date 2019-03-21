package com.gn.app.dao.settings.CertificateDetailRegister;

import com.gn.app.model.Settings.CertificateDetailRegister.CertificateDetailRegister;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CertificateDetailRegisterDao extends DataTablesRepository<CertificateDetailRegister,Integer> {
}
