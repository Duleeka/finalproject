package com.gn.app.mappers.citizenProfileTask.DonationDetail;

import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetail;

import java.text.SimpleDateFormat;

public class DonationDetailMapper extends GenericMapper<DonationDetail, DonationDetailDTO> {

    private static DonationDetailMapper instance = null;

    private DonationDetailMapper(){

    }
    public static DonationDetailMapper getInstance(){
        if (instance==null) {
            instance = new DonationDetailMapper();
        }
        return instance;
    }


    @Override
    public DonationDetailDTO domainToDto(DonationDetail donationDetail) throws Exception {
        DonationDetailDTO dto = new DonationDetailDTO();
        dto.setId(donationDetail.getId());
        dto.setHouseholderId(donationDetail.getHouseholderId());
        dto.setVersion(donationDetail.getVersion());
        dto.setDonationType(donationDetail.getDonationType());

        if (donationDetail.getReceivedDate()!=null) {
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(donationDetail.getReceivedDate()));
        }
        dto.setDescription(donationDetail.getDescription());
        return dto;
    }

    @Override
    public DonationDetailDTO domainToDtoForDataTable(DonationDetail donationDetail) throws Exception {
        DonationDetailDTO dto = new DonationDetailDTO();
        dto.setId(donationDetail.getId());
        dto.setHouseholderId(donationDetail.getHouseholderId());
        dto.setDonationType(donationDetail.getDonationType());

        if (donationDetail.getReceivedDate()!=null) {
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(donationDetail.getReceivedDate()));
        }
        dto.setDescription(donationDetail.getDescription());

        return dto;
    }

    @Override
    public void dtoToDomain(DonationDetailDTO dto, DonationDetail donationDetail) throws Exception {
        donationDetail.setId(dto.getId());
        donationDetail.setHouseholderId(dto.getHouseholderId());
        donationDetail.setVersion(dto.getVersion());
        donationDetail.setDonationType(dto.getDonationType());
        donationDetail.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getReceivedDate()));
        donationDetail.setDescription(dto.getDescription());
    }
}
