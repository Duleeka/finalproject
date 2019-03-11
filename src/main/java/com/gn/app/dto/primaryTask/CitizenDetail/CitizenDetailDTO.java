package com.gn.app.dto.primaryTask.CitizenDetail;

import com.gn.app.Province;
import com.gn.app.dto.BaseDTO;



public class CitizenDetailDTO extends BaseDTO {

    private Integer id;
    private String cFamilyNo;
    private String cInitials;
    private String cFirstName;
    private String cMiddleName;
    private String cLastName;
    private String eligibilityType;
    private String cNic;
    private String cDateOfBirth;
    private Integer cAge;
    private String cGender;
    private String maritalStatus;
    private String cAddress;
    private Integer cPhoneNumber;
    private String cHighestEducationLevel;
    private String cOccupation;
    private Double cIncome;
    private Integer noOfFamilyMembers;
    private String cNationality;
    private String cReligion;
    private String cBirthDistrict;
    private String cEmailAddress;
    private String status;


    public Integer getId() { return  id;}
    public void setId(Integer id) { this.id = id;}

    public String getCFamilyNo() { return cFamilyNo;}
    public void setCFamilyNo(String cFamilyNo) { this.cFamilyNo= cFamilyNo;}

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCInitials() { return cInitials;}
    public void setCInitials(String cInitials) { this.cInitials= cInitials;}

    public String getCFirstName() { return cFirstName;}
    public void setCFirstName(String cFirstName) { this.cFirstName= cFirstName;}

    public String getCMiddleName() { return cMiddleName;}
    public void setCMiddleName(String cMiddleName) { this.cMiddleName = cMiddleName;}

    public String getCLastName() { return cLastName;}
    public void setCLastName(String cLastName) { this.cLastName= cLastName;}

    public String getEligibilityType() { return eligibilityType;}
    public void setEligibilityType(String eligibilityType) { this.eligibilityType= eligibilityType;}

    public String getCNic() { return cNic;}
    public void setCNic(String cNic) { this.cNic= cNic;}

    public String getCDateOfBirth() { return cDateOfBirth;}
    public void setCDateOfBirth(String cDateOfBirth) { this.cDateOfBirth= cDateOfBirth;}

    public Integer getCAge() { return cAge;}
    public void setCAge(Integer cAge) { this.cAge= cAge;}

    public String getCGender() { return cGender;}
    public void setCGender(String cGender) { this.cGender= cGender;}

    public String getMaritalStatus() { return maritalStatus;}
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus= maritalStatus;}

    public String getCAddress() { return cAddress;}
    public void setCAddress(String cAddress) { this.cAddress= cAddress;}

    public Integer getCPhoneNumber() { return cPhoneNumber;}
    public void setCPhoneNumber(Integer cPhoneNumber) { this.cPhoneNumber= cPhoneNumber;}

    public String getCHighestEducationLevel() { return cHighestEducationLevel;}
    public void setCHighestEducationLevel(String cHighestEducationLevel) { this.cHighestEducationLevel= cHighestEducationLevel;}

    public String getCOccupation() { return cOccupation;}
    public void setCOccupation(String cOccupation) { this.cOccupation= cOccupation;}

    public Double getCIncome() { return cIncome;}
    public void setCIncome(Double cIncome) { this.cIncome= cIncome;}

    public Integer getNoOfFamilyMembers() { return noOfFamilyMembers;}
    public void setNoOfFamilyMembers(Integer noOfFamilyMembers) { this.noOfFamilyMembers= noOfFamilyMembers;}

    public String getCNationality() { return cNationality;}
    public void setCNationality(String cNationality) { this.cNationality= cNationality;}

    public String getCReligion() { return cReligion;}
    public void setCReligion(String cReligion) { this.cReligion= cReligion;}

    public String getCBirthDistrict() { return cBirthDistrict;}
    public void setCBirthDistrict(String cBirthDistrict) { this.cBirthDistrict= cBirthDistrict;}

    public String getCEmailAddress() { return cEmailAddress;}
    public void setCEmailAddress(String cEmailAddress) { this.cEmailAddress= cEmailAddress;}



}
