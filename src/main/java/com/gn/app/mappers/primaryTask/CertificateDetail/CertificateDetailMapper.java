package com.gn.app.mappers.primaryTask.CertificateDetail;

import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDonationTypeDTO;
import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailCertificateTypeDTO;
import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetailsDonationType;
import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetail;
import com.gn.app.model.primaryTask.CertificateDetail.CertificateDetailsCertificateType;

import java.text.SimpleDateFormat;

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
            dto.setVersion(certificateDetail.getVersion());

            dto.setCertificateNo(certificateDetail.getCertificateNo());

            if (certificateDetail.getCertificateNo() != null && certificateDetail.getCertificateNo() != null) {
                dto.setCertificateNo(certificateDetail.getCertificateNo());
            }

            if (certificateDetail.getCitizenDetail() != null && certificateDetail.getCitizenDetail().getId() != null) {
                dto.setCitizenId(certificateDetail.getCitizenDetail().getId());
            }
            if (certificateDetail.getCertificateIssuedDate()!=null) {
                dto.setCertificateIssuedDate(new SimpleDateFormat("yyyy-MM-dd").format(certificateDetail.getCertificateIssuedDate()));
            }

        dto.setCdDescription(certificateDetail.getCdDescription());
        setCertificateDetailRegisters(certificateDetail,dto);
        return dto;

    }

    private void setCertificateDetailRegisters(CertificateDetail certificateDetail, CertificateDetailDTO certificateDetailDTO) {
        for (CertificateDetailsCertificateType certificateDetailsCertificateType : certificateDetail.getCertificateDetailsCertificateTypes()) {
            CertificateDetailCertificateTypeDTO certificateDetailCertificateTypeDTO = new CertificateDetailCertificateTypeDTO();
            certificateDetailCertificateTypeDTO.setId(certificateDetailsCertificateType.getId());
            certificateDetailCertificateTypeDTO.setVersion(certificateDetailsCertificateType.getVersion());

            if (certificateDetailCertificateTypeDTO != null && certificateDetailsCertificateType.getCertificateDetailRegister() != null && certificateDetailsCertificateType.getCertificateDetailRegister().getCrCertificateType() != null) {
                certificateDetailCertificateTypeDTO.setCrCertificateType(certificateDetailsCertificateType.getCertificateDetailRegister().getCrCertificateType());
            }

            if (certificateDetailCertificateTypeDTO != null && certificateDetailsCertificateType.getCertificateDetailRegister() != null && certificateDetailsCertificateType.getCertificateDetailRegister().getCertificateNo() != null) {
                certificateDetailCertificateTypeDTO.setCertificateNo(certificateDetailsCertificateType.getCertificateDetailRegister().getCertificateNo());
            }

            if (certificateDetailCertificateTypeDTO != null && certificateDetailsCertificateType.getCertificateDetailRegister() != null && certificateDetailsCertificateType.getCertificateDetailRegister().getId() != null) {
                certificateDetailCertificateTypeDTO.setCertificateRegisterId(certificateDetailsCertificateType.getCertificateDetailRegister().getId());
            }

            certificateDetailDTO.getCertificateRegisterDTOS().add(certificateDetailCertificateTypeDTO);
        }
    }


    @Override
    public CertificateDetailDTO domainToDtoForDataTable(CertificateDetail certificateDetail) throws Exception {
        CertificateDetailDTO dto= new CertificateDetailDTO();
        CertificateDetailCertificateTypeDTO certificateDetailCertificateTypeDTO = new CertificateDetailCertificateTypeDTO();

        dto.setId(certificateDetail.getId());

        if (certificateDetail.getCertificateNo() != null && certificateDetail.getCertificateNo() != null) {
            dto.setCertificateNo(certificateDetail.getCertificateNo());
        }
        if (certificateDetail.getCitizenDetail() !=null && certificateDetail.getCitizenDetail().getNic() !=null) {
            dto.setNic(certificateDetail.getCitizenDetail().getNic());
        }
        if (certificateDetail.getCitizenDetail() !=null && certificateDetail.getCitizenDetail().getCitizenFirstName() !=null) {
            dto.setReceiverFullName(certificateDetail.getCitizenDetail().getCitizenFirstName() + " " + certificateDetail.getCitizenDetail().getCitizenLastName());
        }
        return dto;
    }

    @Override
    public void dtoToDomain(CertificateDetailDTO dto, CertificateDetail certificateDetail) throws Exception {
        certificateDetail.setId(dto.getId());
        certificateDetail.setVersion(certificateDetail.getVersion());
        certificateDetail.setCertificateNo(dto.getCertificateNo());
        certificateDetail.setCertificateIssuedDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getCertificateIssuedDate()));
        certificateDetail.setCdDescription(dto.getCdDescription());

        }
}

