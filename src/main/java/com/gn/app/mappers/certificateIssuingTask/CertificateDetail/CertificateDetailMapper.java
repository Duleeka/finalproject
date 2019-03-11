package com.gn.app.mappers.certificateIssuingTask.CertificateDetail;

import com.gn.app.dto.BaseDTO;
import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.dto.certificateIssuingTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.mappers.administrativeTask.DiaryLog.DiaryLogMapper;
import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;
import com.gn.app.model.certificateIssuingTask.CertificateDetail.CertificateDetail;

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
            dto.setCertificateId(certificateDetail.getCertificateId());
            dto.setCFamilyNo(certificateDetail.getCFamilyNo());
            dto.setCNic(certificateDetail.getCNic());
            dto.setCertificateType(certificateDetail.getCertificateType());
            dto.setIssueDate(certificateDetail.getIssueDate());
            dto.setReceiverFullName(certificateDetail.getReceiverFullName());
            dto.setStatus(certificateDetail.getStatus());
            dto.setValidPeriod(certificateDetail.getValidPeriod());
        return dto;
    }

    @Override
    public CertificateDetailDTO domainToDtoForDataTable(CertificateDetail certificateDetail) throws Exception {
        CertificateDetailDTO dto= new CertificateDetailDTO();
        dto.setCertificateId(certificateDetail.getCertificateId());
        dto.setCertificateType(certificateDetail.getCertificateType());
        dto.setReceiverFullName(certificateDetail.getReceiverFullName());
        dto.setIssueDate(certificateDetail.getIssueDate());
        dto.setStatus(certificateDetail.getStatus());
        return dto;
    }

    @Override
    public void dtoToDomain(CertificateDetailDTO dto, CertificateDetail certificateDetail) throws Exception {
        certificateDetail.setId(dto.getId());
        certificateDetail.setCertificateId(dto.getCertificateId());
        certificateDetail.setCFamilyNo(dto.getCFamilyNo());
        certificateDetail.setCNic(dto.getCNic());
        certificateDetail.setCertificateType(dto.getCertificateType());
        certificateDetail.setIssueDate(dto.getIssueDate());
        certificateDetail.setReceiverFullName(dto.getReceiverFullName());
        certificateDetail.setStatus(dto.getStatus());
        certificateDetail.setValidPeriod(dto.getValidPeriod());
    }
}

