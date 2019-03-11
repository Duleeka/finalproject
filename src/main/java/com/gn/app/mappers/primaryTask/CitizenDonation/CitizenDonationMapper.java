package com.gn.app.mappers.primaryTask.CitizenDonation;

import com.gn.app.dto.primaryTask.CitizenDonation.CitizenDonationDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.CitizenDonation.CitizenDonation;

public class CitizenDonationMapper extends GenericMapper<CitizenDonation, CitizenDonationDTO> {

    private static CitizenDonationMapper instance=null;

    public static CitizenDonationMapper getInstance(){
        if (instance ==null){
            instance = new CitizenDonationMapper();
        }
        return instance;
    }



    @Override
    public CitizenDonationDTO domainToDto(CitizenDonation citizenDonation) throws Exception {
        CitizenDonationDTO dto = new CitizenDonationDTO();
        dto.setId(citizenDonation.getId());
        dto.setHouseholderId(citizenDonation.getHouseholderId());
        dto.setdDonationType(citizenDonation.getdDonationType());
        dto.setdReceivingAmount(citizenDonation.getdReceivingAmount());
        dto.setdAccountNumber(citizenDonation.getdAccountNumber());
        dto.setdReceivedDate(citizenDonation.getdReceivedDate());
        dto.setdStatus(citizenDonation.getdStatus());
        dto.setdDescription(citizenDonation.getdDescription());
        return dto;
    }

    @Override
    public CitizenDonationDTO domainToDtoForDataTable(CitizenDonation citizenDonation) throws Exception {
        CitizenDonationDTO dto = new CitizenDonationDTO();
        dto.setHouseholderId(citizenDonation.getHouseholderId());
        dto.setdDonationType(citizenDonation.getdDonationType());
        dto.setdReceivingAmount(citizenDonation.getdReceivingAmount());
        dto.setdReceivedDate(citizenDonation.getdReceivedDate());
        dto.setdStatus(citizenDonation.getdStatus());

        return dto;
    }

    @Override
    public void dtoToDomain(CitizenDonationDTO dto, CitizenDonation citizenDonation) throws Exception {
        citizenDonation.setId(dto.getId());
        citizenDonation.setHouseholderId(dto.getHouseholderId());
        citizenDonation.setdDonationType(dto.getdDonationType());
        citizenDonation.setdReceivingAmount(dto.getdReceivingAmount());
        citizenDonation.setdAccountNumber(dto.getdAccountNumber());
        citizenDonation.setdReceivedDate(dto.getdReceivedDate());
        citizenDonation.setdStatus(dto.getdStatus());
        citizenDonation.setdDescription(dto.getdDescription());

    }
}
