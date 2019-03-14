package com.gn.app.mappers.citizenProfileTask.CitizenDetail;

import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

public class CitizenDetailMapper extends GenericMapper<CitizenDetail, CitizenDetailDTO> {

    private static CitizenDetailMapper instance = null;

    private CitizenDetailMapper(){

    }
    public static CitizenDetailMapper getInstance(){
        if (instance==null) {
            instance = new CitizenDetailMapper();
        }
        return instance;
    }

    @Override
    public CitizenDetailDTO domainToDto(CitizenDetail citizenDetail) throws Exception{
        CitizenDetailDTO dto = new CitizenDetailDTO();
        dto.setId(citizenDetail.getId());
        dto.setCitizenFamilyNo(citizenDetail.getCitizenFamilyNo());
        dto.setHouseholder(citizenDetail.getHouseholder());
        dto.setCitizenStatus(citizenDetail.getCitizenStatus());
        dto.setRelationship(citizenDetail.getRelationship());
        dto.setVersion(citizenDetail.getVersion());
        dto.setCitizenInitials(citizenDetail.getCitizenInitials());
        dto.setCitizenFirstName(citizenDetail.getCitizenFirstName());
        dto.setCitizenMiddleName(citizenDetail.getCitizenMiddleName());
        dto.setCitizenLastName(citizenDetail.getCitizenLastName());
        dto.setNic(citizenDetail.getNic());
        dto.setCitizenDateOfBirth(citizenDetail.getCitizenDateOfBirth());
        dto.setCitizenGender(citizenDetail.getCitizenGender());
        dto.setMaritalStatus(citizenDetail.getMaritalStatus());
        dto.setPhoneNumber(citizenDetail.getPhoneNumber());
        dto.setCitizenEmailAddress(citizenDetail.getCitizenEmailAddress());
        dto.setCitizenOccupation(citizenDetail.getCitizenOccupation());
        dto.setCitizenIncome(citizenDetail.getCitizenIncome());
        dto.setCitizenNationality(citizenDetail.getCitizenNationality());
        dto.setCitizenReligion(citizenDetail.getCitizenReligion());


        dto.setCitizenAddress(citizenDetail.getCitizenAddress());
        dto.setCitizenBirthDistrict(citizenDetail.getCitizenBirthDistrict());
        dto.setCitizenGnDivision(citizenDetail.getCitizenGnDivision());
        dto.setPreviousResidentialArea(citizenDetail.getPreviousResidentialArea());
        dto.setReasonToChangeResidentialArea(citizenDetail.getReasonToChangeResidentialArea());


        dto.setHighestEducationLevel(citizenDetail.getHighestEducationLevel());
        dto.setLanguageProficiency(citizenDetail.getLanguageProficiency());


       /* dto.setDDonationType(citizenDetail.getDDonationType());
        dto.setDReceivingAmount(citizenDetail.getDReceivingAmount());
        dto.setDAccountNumber(citizenDetail.getDAccountNumber());
        dto.setDReceivedDate(citizenDetail.getDReceivedDate());
        dto.setDStatus(citizenDetail.getDStatus());
        dto.setDDescription(citizenDetail.getDDescription());*/


        return dto;

    }

    @Override
    public CitizenDetailDTO domainToDtoForDataTable(CitizenDetail citizenDetail) throws Exception{
        CitizenDetailDTO dto = new CitizenDetailDTO();
        dto.setId(citizenDetail.getId());
        dto.setCitizenFamilyNo(citizenDetail.getCitizenFamilyNo());
        dto.setCitizenStatus(citizenDetail.getCitizenStatus());
        dto.setRelationship(citizenDetail.getRelationship());
        dto.setVersion(citizenDetail.getVersion());
        dto.setCitizenFirstName(citizenDetail.getCitizenFirstName());
        dto.setCitizenLastName(citizenDetail.getCitizenLastName());
        dto.setNic(citizenDetail.getNic());
        dto.setPhoneNumber(citizenDetail.getPhoneNumber());
        return dto;

    }
    @Override
    public void dtoToDomain(CitizenDetailDTO dto, CitizenDetail citizenDetail) throws Exception{
        citizenDetail.setId(dto.getId());
        citizenDetail.setCitizenFamilyNo(dto.getCitizenFamilyNo());
        citizenDetail.setHouseholder(dto.getHouseholder());
        citizenDetail.setCitizenStatus(dto.getCitizenStatus());
        citizenDetail.setRelationship(dto.getRelationship());
        citizenDetail.setVersion(dto.getVersion());
        citizenDetail.setCitizenInitials(dto.getCitizenInitials());
        citizenDetail.setCitizenFirstName(dto.getCitizenFirstName());
        citizenDetail.setCitizenMiddleName(dto.getCitizenMiddleName());
        citizenDetail.setCitizenLastName(dto.getCitizenLastName());
        citizenDetail.setNic(dto.getNic());
        citizenDetail.setCitizenDateOfBirth(dto.getCitizenDateOfBirth());
        citizenDetail.setCitizenGender(dto.getCitizenGender());
        citizenDetail.setMaritalStatus(dto.getMaritalStatus());
        citizenDetail.setPhoneNumber(dto.getPhoneNumber());
        citizenDetail.setCitizenEmailAddress(dto.getCitizenEmailAddress());
        citizenDetail.setCitizenOccupation(dto.getCitizenOccupation());
        citizenDetail.setCitizenIncome(dto.getCitizenIncome());
        citizenDetail.setCitizenNationality(dto.getCitizenNationality());
        citizenDetail.setCitizenReligion(dto.getCitizenReligion());


        citizenDetail.setCitizenAddress(dto.getCitizenAddress());
        citizenDetail.setCitizenBirthDistrict(dto.getCitizenBirthDistrict());
        citizenDetail.setCitizenGnDivision(dto.getCitizenGnDivision());
        citizenDetail.setPreviousResidentialArea(dto.getPreviousResidentialArea());
        citizenDetail.setReasonToChangeResidentialArea(dto.getReasonToChangeResidentialArea());


        citizenDetail.setHighestEducationLevel(dto.getHighestEducationLevel());
        citizenDetail.setLanguageProficiency(dto.getLanguageProficiency());


        /*citizenDetail.setDDonationType(dto.getDDonationType());
        citizenDetail.setDReceivingAmount(dto.getDReceivingAmount());
        citizenDetail.setDAccountNumber(dto.getDAccountNumber());
        citizenDetail.setDReceivedDate(dto.getDReceivedDate());
        citizenDetail.setDStatus(dto.getDStatus());
        citizenDetail.setDDescription(dto.getDDescription());*/

    }

}
