package com.gn.app.dto.citizenProfileTask.CitizenDetail;

import com.gn.app.constant.District;
import com.gn.app.constant.Gender;
import com.gn.app.constant.MaritalStatus;
import com.gn.app.constant.Relationship;
import com.gn.app.dto.BaseDTO;


public class CitizenDetailDTO extends BaseDTO {

    private Integer id;
    private Integer nationalityId;
    private Integer religionId;
    private Integer gnDivisionId;
    private Integer educationId;
    private Boolean isHouseholder;
    private String citizenFamilyNo;
    private Boolean citizenStatus = Boolean.FALSE;
    private Relationship relationship;
    private String citizenInitials;
    private String citizenFirstName;
    private String citizenMiddleName;
    private String citizenLastName;
    private String nic;
    private String citizenDateOfBirth;
    private Gender citizenGender;
    private MaritalStatus maritalStatus;
    private Integer phoneNumber;
    private String citizenEmailAddress;
    private String citizenOccupation;
    private Double citizenIncome;
    private String citizenNationality;
    private String citizenReligion;

    private String citizenAddress;
    private String citizenGnDivision;
    private District citizenBirthDistrict;
    private District previousResidentialArea;
    private String reasonToChangeResidentialArea;

    private String highestEducationLevel;

    private String deathPlace;
    private String deathReason;
    private String dateOfDeath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNationalityId() {
        return nationalityId;
    }

    public void setNationalityId(Integer nationalityId) {
        this.nationalityId = nationalityId;
    }

    public Integer getReligionId() {
        return religionId;
    }

    public void setReligionId(Integer religionId) {
        this.religionId = religionId;
    }

    public Integer getGnDivisionId() {
        return gnDivisionId;
    }

    public void setGnDivisionId(Integer gnDivisionId) {
        this.gnDivisionId = gnDivisionId;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public Boolean getIsHouseholder() {
        return isHouseholder;
    }

    public void setIsHouseholder(Boolean householder) {
        isHouseholder = householder;
    }

    public String getCitizenFamilyNo() {
        return citizenFamilyNo;
    }

    public void setCitizenFamilyNo(String citizenFamilyNo) {
        this.citizenFamilyNo = citizenFamilyNo;
    }

    public Boolean getCitizenStatus() {
        return citizenStatus;
    }

    public void setCitizenStatus(Boolean citizenStatus) {
        this.citizenStatus = citizenStatus;
    }

    public Relationship getRelationship() {
        return relationship;
    }

    public void setRelationship(Relationship relationship) {
        this.relationship = relationship;
    }

    public String getCitizenInitials() {
        return citizenInitials;
    }

    public void setCitizenInitials(String citizenInitials) {
        this.citizenInitials = citizenInitials;
    }

    public String getCitizenFirstName() {
        return citizenFirstName;
    }

    public void setCitizenFirstName(String citizenFirstName) {
        this.citizenFirstName = citizenFirstName;
    }

    public String getCitizenMiddleName() {
        return citizenMiddleName;
    }

    public void setCitizenMiddleName(String citizenMiddleName) {
        this.citizenMiddleName = citizenMiddleName;
    }

    public String getCitizenLastName() {
        return citizenLastName;
    }

    public void setCitizenLastName(String citizenLastName) {
        this.citizenLastName = citizenLastName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getCitizenDateOfBirth() {
        return citizenDateOfBirth;
    }

    public void setCitizenDateOfBirth(String citizenDateOfBirth) {
        this.citizenDateOfBirth = citizenDateOfBirth;
    }

    public Gender getCitizenGender() {
        return citizenGender;
    }

    public void setCitizenGender(Gender citizenGender) {
        this.citizenGender = citizenGender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCitizenEmailAddress() {
        return citizenEmailAddress;
    }

    public void setCitizenEmailAddress(String citizenEmailAddress) {
        this.citizenEmailAddress = citizenEmailAddress;
    }

    public String getCitizenOccupation() {
        return citizenOccupation;
    }

    public void setCitizenOccupation(String citizenOccupation) {
        this.citizenOccupation = citizenOccupation;
    }

    public Double getCitizenIncome() {
        return citizenIncome;
    }

    public void setCitizenIncome(Double citizenIncome) {
        this.citizenIncome = citizenIncome;
    }

    public String getCitizenNationality() {
        return citizenNationality;
    }

    public void setCitizenNationality(String citizenNationality) {
        this.citizenNationality = citizenNationality;
    }

    public String getCitizenReligion() {
        return citizenReligion;
    }

    public void setCitizenReligion(String citizenReligion) {
        this.citizenReligion = citizenReligion;
    }

    public String getCitizenAddress() {
        return citizenAddress;
    }

    public void setCitizenAddress(String citizenAddress) {
        this.citizenAddress = citizenAddress;
    }

    public String getCitizenGnDivision() {
        return citizenGnDivision;
    }

    public void setCitizenGnDivision(String citizenGnDivision) {
        this.citizenGnDivision = citizenGnDivision;
    }

    public District getCitizenBirthDistrict() {
        return citizenBirthDistrict;
    }

    public void setCitizenBirthDistrict(District citizenBirthDistrict) {
        this.citizenBirthDistrict = citizenBirthDistrict;
    }

    public District getPreviousResidentialArea() {
        return previousResidentialArea;
    }

    public void setPreviousResidentialArea(District previousResidentialArea) {
        this.previousResidentialArea = previousResidentialArea;
    }

    public String getReasonToChangeResidentialArea() {
        return reasonToChangeResidentialArea;
    }

    public void setReasonToChangeResidentialArea(String reasonToChangeResidentialArea) {
        this.reasonToChangeResidentialArea = reasonToChangeResidentialArea;
    }

    public String getHighestEducationLevel() {
        return highestEducationLevel;
    }

    public void setHighestEducationLevel(String highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public String getDeathReason() {
        return deathReason;
    }

    public void setDeathReason(String deathReason) {
        this.deathReason = deathReason;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }
}
