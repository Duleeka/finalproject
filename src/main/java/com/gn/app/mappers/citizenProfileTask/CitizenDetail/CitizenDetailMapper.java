package com.gn.app.mappers.citizenProfileTask.CitizenDetail;

import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

import java.text.SimpleDateFormat;

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
        dto.setVersion(citizenDetail.getVersion());
        dto.setCitizenFamilyNo(citizenDetail.getCitizenFamilyNo());
        dto.setIsHouseholder(citizenDetail.getHouseholder());
        dto.setCitizenStatus(citizenDetail.getCitizenStatus());
        if (citizenDetail.getRelationship()!=null){
        dto.setRelationship(citizenDetail.getRelationship());}
        dto.setVersion(citizenDetail.getVersion());
        dto.setCitizenInitials(citizenDetail.getCitizenInitials());
        dto.setCitizenFirstName(citizenDetail.getCitizenFirstName());
        dto.setCitizenMiddleName(citizenDetail.getCitizenMiddleName());
        dto.setCitizenLastName(citizenDetail.getCitizenLastName());
        if (citizenDetail.getNic()!=null){
        dto.setNic(citizenDetail.getNic());}
        if(citizenDetail.getCitizenDateOfBirth()!=null){
            dto.setCitizenDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").format(citizenDetail.getCitizenDateOfBirth()));
        }
        dto.setCitizenGender(citizenDetail.getCitizenGender());
        dto.setMaritalStatus(citizenDetail.getMaritalStatus());
        dto.setPhoneNumber(citizenDetail.getPhoneNumber());
        dto.setCitizenEmailAddress(citizenDetail.getCitizenEmailAddress());
        dto.setCitizenOccupation(citizenDetail.getCitizenOccupation());
        dto.setCitizenIncome(citizenDetail.getCitizenIncome());
        if(citizenDetail.getNationalityRegister()!=null && citizenDetail.getNationalityRegister().getNationalityType()!=null){
        dto.setCitizenNationality(citizenDetail.getNationalityRegister().getNationalityType());}
        if (citizenDetail.getReligionRegister()!=null && citizenDetail.getReligionRegister().getReligionType()!=null){
        dto.setCitizenReligion(citizenDetail.getReligionRegister().getReligionType());}


        dto.setCitizenAddress(citizenDetail.getCitizenAddress());
        dto.setCitizenBirthDistrict(citizenDetail.getCitizenBirthDistrict());

if (citizenDetail.getGnDivisionRegister()!=null && citizenDetail.getGnDivisionRegister().getDivisionName()!=null){
        dto.setCitizenGnDivision(citizenDetail.getGnDivisionRegister().getDivisionName());}

        dto.setPreviousResidentialArea(citizenDetail.getPreviousResidentialArea());
        dto.setReasonToChangeResidentialArea(citizenDetail.getReasonToChangeResidentialArea());

        dto.setDeathPlace(citizenDetail.getDeathPlace());
        dto.setDeathReason(citizenDetail.getDeathReason());
        if (citizenDetail.getDateOfDeath()!=null){
            dto.setDateOfDeath(new SimpleDateFormat("yyyy-MM-dd").format(citizenDetail.getDateOfDeath()));
        }
if (citizenDetail.getEducationLevelRegister()!=null && citizenDetail.getEducationLevelRegister().getEducationLevel()!=null){
        dto.setHighestEducationLevel(citizenDetail.getEducationLevelRegister().getEducationLevel());}


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


       /* dto.setDeathPlace(citizenDetail.getDeathPlace());
        dto.setDeathReason(citizenDetail.getDeathReason());
        dto.setDateOfDeath(citizenDetail.getDateOfDeath());*/
        return dto;

    }
    @Override
    public void dtoToDomain(CitizenDetailDTO dto, CitizenDetail citizenDetail) throws Exception{
        citizenDetail.setId(dto.getId());
        citizenDetail.setCitizenFamilyNo(dto.getCitizenFamilyNo());
        citizenDetail.setHouseholder(dto.getIsHouseholder());
        citizenDetail.setCitizenStatus(dto.getCitizenStatus());
        citizenDetail.setRelationship(dto.getRelationship());
        citizenDetail.setVersion(dto.getVersion());
        citizenDetail.setCitizenInitials(dto.getCitizenInitials());
        citizenDetail.setCitizenFirstName(dto.getCitizenFirstName());
        citizenDetail.setCitizenMiddleName(dto.getCitizenMiddleName());
        citizenDetail.setCitizenLastName(dto.getCitizenLastName());
        citizenDetail.setNic(dto.getNic());
        if (citizenDetail.getCitizenDateOfBirth()!=null) {
            citizenDetail.setCitizenDateOfBirth(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getCitizenDateOfBirth()));
        }
        citizenDetail.setCitizenGender(dto.getCitizenGender());
       citizenDetail.setMaritalStatus(dto.getMaritalStatus());
        citizenDetail.setPhoneNumber(dto.getPhoneNumber());
        citizenDetail.setCitizenEmailAddress(dto.getCitizenEmailAddress());
        citizenDetail.setCitizenOccupation(dto.getCitizenOccupation());
        citizenDetail.setCitizenIncome(dto.getCitizenIncome());
        citizenDetail.setCitizenNationality(dto.getCitizenNationality());
        citizenDetail.setCitizenReligion(dto.getCitizenReligion());


        citizenDetail.setCitizenAddress(dto.getCitizenAddress());
        citizenDetail.setCitizenGnDivision(dto.getCitizenGnDivision());
        citizenDetail.setCitizenBirthDistrict(dto.getCitizenBirthDistrict());
        citizenDetail.setPreviousResidentialArea(dto.getPreviousResidentialArea());
        citizenDetail.setReasonToChangeResidentialArea(dto.getReasonToChangeResidentialArea());

        citizenDetail.setDeathPlace(dto.getDeathPlace());
        citizenDetail.setDeathReason(dto.getDeathReason());
        if (citizenDetail.getDateOfDeath()!=null) {
            citizenDetail.setDateOfDeath(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getDateOfDeath()));
        }

        citizenDetail.setHighestEducationLevel(dto.getHighestEducationLevel());


    }

}
