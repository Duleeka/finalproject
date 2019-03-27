package com.gn.app.mappers.settings.DonationRegister;


import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.Settings.DonationRegister.DonationRegister;

public class DonationRegisterMapper extends GenericMapper<DonationRegister,DonationRegisterDTO>{

    private static DonationRegisterMapper instance = null;

    private DonationRegisterMapper(){

    }
    public static DonationRegisterMapper getInstance(){
        if (instance==null) {
            instance = new DonationRegisterMapper();
        }
        return instance;
    }


    @Override
    public DonationRegisterDTO domainToDto(DonationRegister donationRegister) throws Exception {
        DonationRegisterDTO dto = new DonationRegisterDTO();
        dto.setId(donationRegister.getId());
        dto.setVersion(donationRegister.getVersion());
        dto.setDonationType(donationRegister.getDonationType());
        dto.setDescription(donationRegister.getDescription());
        return dto;
    }

    @Override
    public DonationRegisterDTO domainToDtoForDataTable(DonationRegister donationRegister) throws Exception {
        DonationRegisterDTO dto = new DonationRegisterDTO();
        dto.setId(donationRegister.getId());
        dto.setDonationType(donationRegister.getDonationType());
        dto.setDescription(donationRegister.getDescription());

        return dto;
    }

    @Override
    public void dtoToDomain(DonationRegisterDTO dto, DonationRegister donationRegister) throws Exception {
        donationRegister.setId(dto.getId());
        donationRegister.setVersion(dto.getVersion());
        donationRegister.setDonationType(dto.getDonationType());
        donationRegister.setDescription(dto.getDescription());

    }
}
