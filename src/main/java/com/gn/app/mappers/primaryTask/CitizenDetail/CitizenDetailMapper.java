package com.gn.app.mappers.primaryTask.CitizenDetail;

import com.gn.app.dto.primaryTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.CitizenDetail.CitizenDetail;

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
        dto.setCFamilyNo(citizenDetail.getCFamilyNo());
        dto.setStatus(citizenDetail.getStatus());
        dto.setVersion(citizenDetail.getVersion());
        dto.setCInitials(citizenDetail.getCInitials());
        dto.setCFirstName(citizenDetail.getCFirstName());
        dto.setCMiddleName(citizenDetail.getCMiddleName());
        dto.setCLastName(citizenDetail.getCLastName());
        dto.setEligibilityType(citizenDetail.getEligibilityType());
        dto.setCNic(citizenDetail.getCNic());
        dto.setCDateOfBirth(citizenDetail.getCDateOfBirth());
        dto.setCAge(citizenDetail.getCAge());
        dto.setCGender(citizenDetail.getCGender());
        dto.setMaritalStatus(citizenDetail.getMaritalStatus());
        dto.setCAddress(citizenDetail.getCAddress());
        dto.setCPhoneNumber(citizenDetail.getCPhoneNumber());
        dto.setCHighestEducationLevel(citizenDetail.getCHighestEducationLevel());
        dto.setCOccupation(citizenDetail.getCOccupation());
        dto.setCIncome(citizenDetail.getCIncome());
        dto.setNoOfFamilyMembers(citizenDetail.getNoOfFamilyMembers());
        dto.setCNationality(citizenDetail.getCNationality());
        dto.setCReligion(citizenDetail.getCReligion());
        dto.setCBirthDistrict(citizenDetail.getCBirthDistrict());
        dto.setCEmailAddress(citizenDetail.getCEmailAddress());

        return dto;

    }

    @Override
    public CitizenDetailDTO domainToDtoForDataTable(CitizenDetail citizenDetail) throws Exception{
        CitizenDetailDTO dto = new CitizenDetailDTO();
        dto.setId(citizenDetail.getId());
        dto.setCFamilyNo(citizenDetail.getCFamilyNo());
        dto.setStatus(citizenDetail.getStatus());
        dto.setVersion(citizenDetail.getVersion());
        dto.setCFirstName(citizenDetail.getCFirstName());
        dto.setCLastName(citizenDetail.getCLastName());
        dto.setCNic(citizenDetail.getCNic());
        dto.setCHighestEducationLevel(citizenDetail.getCHighestEducationLevel());
        dto.setCOccupation(citizenDetail.getCOccupation());
        dto.setCPhoneNumber(citizenDetail.getCPhoneNumber());
        dto.setCIncome(citizenDetail.getCIncome());
        return dto;

    }
    @Override
    public void dtoToDomain(CitizenDetailDTO dto, CitizenDetail citizenDetail) throws Exception{
        citizenDetail.setId(dto.getId());
        citizenDetail.setCFamilyNo(dto.getCFamilyNo());
        citizenDetail.setStatus(dto.getStatus());
        citizenDetail.setVersion(dto.getVersion());
        citizenDetail.setCInitials(dto.getCInitials());
        citizenDetail.setCFirstName(dto.getCFirstName());
        citizenDetail.setCMiddleName(dto.getCMiddleName());
        citizenDetail.setCLastName(dto.getCLastName());
        citizenDetail.setEligibilityType(dto.getEligibilityType());
        citizenDetail.setCNic(dto.getCNic());
        citizenDetail.setCDateOfBirth(dto.getCDateOfBirth());
        citizenDetail.setCAge(dto.getCAge());
        citizenDetail.setCGender(dto.getCGender());
        citizenDetail.setMaritalStatus(dto.getMaritalStatus());
        citizenDetail.setCAddress(dto.getCAddress());
        citizenDetail.setCPhoneNumber(dto.getCPhoneNumber());
        citizenDetail.setCHighestEducationLevel(dto.getCHighestEducationLevel());
        citizenDetail.setCOccupation(dto.getCOccupation());
        citizenDetail.setCIncome(dto.getCIncome());
        citizenDetail.setNoOfFamilyMembers(dto.getNoOfFamilyMembers());
        citizenDetail.setCNationality(dto.getCNationality());
        citizenDetail.setCReligion(dto.getCReligion());
        citizenDetail.setCBirthDistrict(dto.getCBirthDistrict());
        citizenDetail.setCEmailAddress(dto.getCEmailAddress());


    }

}
