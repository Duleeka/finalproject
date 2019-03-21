package com.gn.app.mappers.primaryTask.CertificateDetail;

import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetail;

public class CertificateDetailMapper extends GenericMapper<CertificateDetail, CertificateDetailDTO> {

    private static CertificateDetailMapper instance = null;


        public static CertificateDetailMapper getInstance() {
            if (instance == null) {
                instance = new CertificateDetailMapper();
            }
            return instance;
        }

    @Override
    public CertificateDetailDTO domainToDto(CertificateDetail certificateDetail) throws Exception {
            CertificateDetailDTO dto= new CertificateDetailDTO();
            dto.setId(certificateDetail.getId());
            dto.setCertificateNo(certificateDetail.getCertificateNo());
            dto.setCertificateType(certificateDetail.getCertificateType());
            dto.setCertificateIssuedDate(certificateDetail.getCertificateIssuedDate());
            dto.setCdDescription(certificateDetail.getCdDescription());

        return dto;
    }

    @Override
    public CertificateDetailDTO domainToDtoForDataTable(CertificateDetail certificateDetail) throws Exception {
        CertificateDetailDTO dto= new CertificateDetailDTO();
        dto.setId(certificateDetail.getId());
        dto.setVersion(certificateDetail.getVersion());
        dto.setCertificateNo(certificateDetail.getCertificateNo());
        dto.setCertificateType(certificateDetail.getCertificateDetailRegister().getCrCertificateType());
        dto.setNic(certificateDetail.getCitizenDetail().getNic());
        dto.setReceiverFullName(certificateDetail.getCitizenDetail().getCitizenFirstName()+" "+certificateDetail.getCitizenDetail().getCitizenLastName());
        return dto;
    }

    @Override
    public void dtoToDomain(CertificateDetailDTO dto, CertificateDetail certificateDetail) throws Exception {
        certificateDetail.setId(dto.getId());
        certificateDetail.setVersion(certificateDetail.getVersion());
        certificateDetail.setCertificateNo(dto.getCertificateNo());
        certificateDetail.setCertificateType(dto.getCertificateType());
        certificateDetail.setCertificateIssuedDate(dto.getCertificateIssuedDate());
        certificateDetail.setCdDescription(dto.getCdDescription());

        }
}

