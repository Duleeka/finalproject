package com.gn.app.mappers.primaryTask.DependentDetail;

import com.gn.app.dto.primaryTask.DependentDetail.DependentDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.DependentDetail.DependentDetail;

public class DependentDetailMapper extends GenericMapper<DependentDetail, DependentDetailDTO> {

    private static DependentDetailMapper instance = null;
    private DependentDetailMapper(){

    }

    public static DependentDetailMapper getInstance(){
        if (instance == null) {
            instance = new DependentDetailMapper();
        }
        return instance;
    }
    @Override
    public DependentDetailDTO domainToDto(DependentDetail dependentDetail) throws Exception {
        DependentDetailDTO dto =  new DependentDetailDTO();
        dto.setDeId(dependentDetail.getDeId());
        dto.setDeFamilyNo(dependentDetail.getDeFamilyNo());
        dto.setDeNic(dependentDetail.getDeNic());
        dto.setDeEligibility(dependentDetail.getDeEligibility());
        dto.setDeInitials(dependentDetail.getDeInitials());
        dto.setDeFirstName(dependentDetail.getDeFirstName());
        dto.setDeMiddleName(dependentDetail.getDeMiddleName());
        dto.setDeLastName(dependentDetail.getDeLastName());
        dto.setRelationship(dependentDetail.getRelationship());
        dto.setDeAge(dependentDetail.getDeAge());
        dto.setDeDateOfBirth(dependentDetail.getDeDateOfBirth());
        dto.setDeGender(dependentDetail.getDeGender());
        dto.setDeMaritalStatus(dependentDetail.getDeMaritalStatus());
        dto.setDeNationality(dependentDetail.getDeNationality());
        dto.setDeReligion(dependentDetail.getDeReligion());
        dto.setDePhoneNumber(dependentDetail.getDePhoneNumber());
        dto.setDeHighestEducationLevel(dependentDetail.getDeHighestEducationLevel());
        dto.setDeEmailAddress(dependentDetail.getDeEmailAddress());
        dto.setDeBirthDistrict(dependentDetail.getDeBirthDistrict());
        dto.setDePreviousRecidenceArea(dependentDetail.getDePreviousRecidenceArea());
        dto.setDeStatus(dependentDetail.getDeStatus());
        dto.setDeOccupation(dependentDetail.getDeOccupation());
        dto.setDeIncome(dependentDetail.getDeIncome());

        return dto;
    }

    @Override
    public DependentDetailDTO domainToDtoForDataTable(DependentDetail dependentDetail) throws Exception {
        DependentDetailDTO dto = new DependentDetailDTO();
        dto.setDeId(dependentDetail.getDeId());
        dto.setDeFamilyNo(dependentDetail.getDeFamilyNo());
        dto.setRelationship(dependentDetail.getRelationship());
        dto.setDeFirstName(dependentDetail.getDeFirstName());
        dto.setDeLastName(dependentDetail.getDeLastName());
        dto.setDeNic(dependentDetail.getDeNic());
        dto.setDeEligibility(dependentDetail.getDeEligibility());
        dto.setDePhoneNumber(dependentDetail.getDePhoneNumber());
        dto.setDeHighestEducationLevel(dependentDetail.getDeHighestEducationLevel());
        dto.setDeOccupation(dependentDetail.getDeOccupation());
        return null;
    }

    @Override
    public void dtoToDomain(DependentDetailDTO dto, DependentDetail dependentDetail) throws Exception {
        dependentDetail.setDeId(dto.getDeId());
       dependentDetail.setDeFamilyNo(dto.getDeFamilyNo());
        dependentDetail.setDeNic(dto.getDeNic());
        dependentDetail.setDeEligibility(dto.getDeEligibility());
        dependentDetail.setDeInitialse(dto.getDeInitials());
        dependentDetail.setDeFirstName(dto.getDeFirstName());
        dependentDetail.setDeMiddleName(dto.getDeMiddleName());
        dependentDetail.setDeLastName(dto.getDeLastName());
        dependentDetail.setRelationship(dto.getRelationship());
        dependentDetail.setDeAge(dto.getDeAge());
        dependentDetail.setDeDateOfBirth(dto.getDeDateOfBirth());
        dependentDetail.setDeGender(dto.getDeGender());
        dependentDetail.setDeMaritalStatus(dto.getDeMaritalStatus());
        dependentDetail.setDeNationality(dto.getDeNationality());
        dependentDetail.setDeReligion(dto.getDeReligion());
        dependentDetail.setDePhoneNumber(dto.getDePhoneNumber());
        dependentDetail.setDeHighestEducationLevel(dto.getDeHighestEducationLevel());
        dependentDetail.setDeEmailAddress(dto.getDeEmailAddress());
        dependentDetail.setDeBirthDistrict(dto.getDeBirthDistrict());
        dependentDetail.setDePreviousRecidenceArea(dto.getDePreviousRecidenceArea());
        dependentDetail.setDeStatus(dto.getDeStatus());
        dependentDetail.setDeOccupation(dto.getDeOccupation());
        dependentDetail.setDeIncome(dto.getDeIncome());

    }
}
