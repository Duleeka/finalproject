package com.gn.app.mappers.settings.CertificateDetailRegister;

import com.gn.app.dto.settings.CertificateDetailRegister.CertificateDetailRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.CertificateDetailRegister.CertificateDetailRegister;

import java.text.SimpleDateFormat;


public class CertificateDetailRegisterMapper extends GenericMapper<CertificateDetailRegister, CertificateDetailRegisterDTO> {

    private static CertificateDetailRegisterMapper instance = null;


    public static CertificateDetailRegisterMapper getInstance() {
        if (instance == null) {
            instance = new CertificateDetailRegisterMapper();
        }
        return instance;
    }

    @Override
    public CertificateDetailRegisterDTO domainToDto(CertificateDetailRegister certificateDetailRegister) throws Exception {
        CertificateDetailRegisterDTO dto= new CertificateDetailRegisterDTO();
        dto.setId(certificateDetailRegister.getId());
        dto.setVersion(certificateDetailRegister.getVersion());
        dto.setCertificateNo(certificateDetailRegister.getCertificateNo());
        dto.setCrCertificateType(certificateDetailRegister.getCrCertificateType());
        return dto;
    }

    @Override
    public CertificateDetailRegisterDTO domainToDtoForDataTable(CertificateDetailRegister certificateDetailRegister) throws Exception {
        CertificateDetailRegisterDTO dto= new CertificateDetailRegisterDTO();
        dto.setId(certificateDetailRegister.getId());
        dto.setCertificateNo(certificateDetailRegister.getCertificateNo());
        dto.setCrCertificateType(certificateDetailRegister.getCrCertificateType());

            return dto;
    }

    @Override
    public void dtoToDomain(CertificateDetailRegisterDTO dto, CertificateDetailRegister certificateDetailRegister) throws Exception {
        certificateDetailRegister.setId(dto.getId());
        dto.setVersion(certificateDetailRegister.getVersion());
        certificateDetailRegister.setCertificateNo(dto.getCertificateNo());
        certificateDetailRegister.setCrCertificateType(dto.getCrCertificateType());


    }
}

