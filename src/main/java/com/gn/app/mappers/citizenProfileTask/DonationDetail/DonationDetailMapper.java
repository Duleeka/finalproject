package com.gn.app.mappers.citizenProfileTask.DonationDetail;

import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDonationTypeDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetailsDonationType;

import java.text.SimpleDateFormat;

public class DonationDetailMapper extends GenericMapper<DonationDetail, DonationDetailDTO> {

    private static DonationDetailMapper instance = null;

    private DonationDetailMapper() {

    }

    public static DonationDetailMapper getInstance() {
        if (instance == null) {
            instance = new DonationDetailMapper();
        }
        return instance;
    }


    @Override
    public DonationDetailDTO domainToDto(DonationDetail donationDetail) throws Exception {
        DonationDetailDTO dto = new DonationDetailDTO();

        dto.setId(donationDetail.getId());
        dto.setVersion(donationDetail.getVersion());

        if (donationDetail.getCitizenDetail() != null && donationDetail.getCitizenDetail().getId() != null) {
            dto.setCitizenId(donationDetail.getCitizenDetail().getId());
        }

        if (donationDetail.getReceivedDate() != null) {
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(donationDetail.getReceivedDate()));
        }
        dto.setDescription(donationDetail.getDescription());
        setDonationRegisters(donationDetail, dto);
        return dto;

    }

    private void setDonationRegisters(DonationDetail donationDetail, DonationDetailDTO donationDetailDTO) {
        for (DonationDetailsDonationType donationDetailDonationType : donationDetail.getDonationDetailsDonationTypes()) {
                DonationDetailDonationTypeDTO donationDetailDonationTypeDTO = new DonationDetailDonationTypeDTO();
                donationDetailDonationTypeDTO.setId(donationDetailDonationType.getId());
                donationDetailDonationTypeDTO.setVersion(donationDetailDonationType.getVersion());


        if (donationDetailDonationTypeDTO != null && donationDetailDonationType.getDonationRegister() != null && donationDetailDonationType.getDonationRegister().getDescription() != null) {
            donationDetailDonationTypeDTO.setDescription(donationDetailDonationType.getDonationRegister().getDescription());
        }

        if (donationDetailDonationTypeDTO != null && donationDetailDonationType.getDonationRegister() != null && donationDetailDonationType.getDonationRegister().getDonationType() != null) {
            donationDetailDonationTypeDTO.setDonationType(donationDetailDonationType.getDonationRegister().getDonationType());
        }

        if (donationDetailDonationTypeDTO != null && donationDetailDonationType.getDonationRegister() != null && donationDetailDonationType.getDonationRegister().getId() != null) {
            donationDetailDonationTypeDTO.setDonationRegisterId(donationDetailDonationType.getDonationRegister().getId());
        }

    donationDetailDTO.getDonationRegisterDTOS().add(donationDetailDonationTypeDTO);
        }
    }

    @Override
    public DonationDetailDTO domainToDtoForDataTable(DonationDetail donationDetail) throws Exception {
        DonationDetailDTO dto = new DonationDetailDTO();
        DonationDetailDonationTypeDTO donationDetailDonationTypeDTO = new DonationDetailDonationTypeDTO();

        dto.setId(donationDetail.getId());

        if (donationDetail.getCitizenDetail() != null && donationDetail.getCitizenDetail().getId() != null) {
            dto.setCitizenId(donationDetail.getCitizenDetail().getId());
        }
        if (donationDetail.getReceivedDate() != null) {
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(donationDetail.getReceivedDate()));
        }
        dto.setDescription(donationDetail.getDescription());
        return dto;
    }

    @Override
    public void dtoToDomain(DonationDetailDTO dto, DonationDetail donationDetail) throws Exception {
        donationDetail.setId(dto.getId());
        donationDetail.setVersion(dto.getVersion());
        donationDetail.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getReceivedDate()));
        donationDetail.setDescription(dto.getDescription());
    }
}
