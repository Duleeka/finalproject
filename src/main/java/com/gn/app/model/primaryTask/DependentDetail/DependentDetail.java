package com.gn.app.model.primaryTask.DependentDetail;


import com.gn.app.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_dependent")
public class DependentDetail extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "de_id")
    private Integer deId;

    @Column(name = "de_family_no")
    private String deFamilyNo;

    @Column(name = "de_nic")
    private String deNic;

    @Column(name = "de_eligibility")
    private String deEligibility;

    @Column(name = "de_initials")
    private String deInitials;

    @Column(name = "de_first_name")
    private String deFirstName;

    @Column(name = "de_middle_name")
    private String deMiddleName;

    @Column(name = "de_last_name")
    private String deLastName;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "de_age")
    private Integer deAge;

    @Column(name = "de_date_of_birth")
    private String deDateOfBirth;

    @Column(name = "de_gender")
    private String deGender;

    @Column(name = "de_marital_status")
    private String deMaritalStatus;

    @Column(name = "de_nationality")
    private String deNationality;

    @Column(name = "de_religion")
    private String deReligion;

    @Column(name = "de_phone_number")
    private Integer dePhoneNumber;

    @Column(name = "de_highest_education_Level")
    private String deHighestEducationLevel;

    @Column(name = "de_email_address")
    private String deEmailAddress;

    @Column(name = "de_birth_district")
    private String deBirthDistrict;

    @Column(name = "de_previous_recidence_area")
    private String dePreviousRecidenceArea;

    @Column(name = "de_status")
    private String deStatus;

    @Column(name = "de_occupation")
    private String deOccupation;

    @Column(name = "de_income")
    private Double deIncome;


    public Integer getDeId() {return deId; }
    public void setDeId(Integer deId) {this.deId = deId;}

    public String getDeFamilyNo() { return deFamilyNo;}
    public void setDeFamilyNo(String deFamilyNo) { this.deFamilyNo = deFamilyNo;}

    public String getDeNic() { return deNic;}
    public void setDeNic(String deNic) { this.deNic=deNic;}

    public String getDeEligibility() { return deEligibility;}
    public void setDeEligibility(String deEligibility) { this.deEligibility = deEligibility;}

    public String getDeInitials() { return deInitials;}
    public void setDeInitialse(String deInitials) { this.deInitials = deInitials;}

    public String getDeFirstName() { return deFirstName;}
    public void setDeFirstName(String deFirstName) { this.deFirstName = deFirstName;}

    public String getDeMiddleName() { return deMiddleName;}
    public void setDeMiddleName(String deMiddleName) { this.deMiddleName = deMiddleName;}

    public String getDeLastName() { return deLastName;}
    public void setDeLastName(String deLastName) { this.deLastName = deLastName;}

    public String getRelationship() { return relationship;}
    public void setRelationship(String relationship) { this.relationship = relationship;}

    public Integer getDeAge() { return deAge;}
    public void setDeAge(Integer deAge) { this.deAge = deAge;}

    public String getDeDateOfBirth() { return deDateOfBirth;}
    public void setDeDateOfBirth(String deDateOfBirth) { this.deDateOfBirth = deDateOfBirth;}

    public String getDeGender() { return deGender;}
    public void setDeGender(String deGender) { this.deGender = deGender;}

    public String getDeMaritalStatus() { return deMaritalStatus;}
    public void setDeMaritalStatus(String deMaritalStatus) { this.deMaritalStatus = deMaritalStatus;}

    public String getDeNationality() { return deNationality;}
    public void setDeNationality(String deNationality) { this.deNationality = deNationality;}

    public String getDeReligion () { return deReligion;}
    public void setDeReligion(String deReligion) { this.deReligion = deReligion;}

    public Integer getDePhoneNumber() { return dePhoneNumber;}
    public void setDePhoneNumber(Integer dePhoneNumber) { this.dePhoneNumber = dePhoneNumber;}

    public String getDeHighestEducationLevel() { return deHighestEducationLevel;}
    public void setDeHighestEducationLevel(String deHighestEducationLevel) { this.deHighestEducationLevel= deHighestEducationLevel;}

   public String getDeEmailAddress(){ return deEmailAddress;}
   public void setDeEmailAddress(String deEmailAddress) { this.deEmailAddress = deEmailAddress;}

    public String getDeBirthDistrict() { return deBirthDistrict; }
    public void setDeBirthDistrict(String deBirthDistrict) { this.deBirthDistrict = deBirthDistrict; }

    public String getDePreviousRecidenceArea() { return dePreviousRecidenceArea; }
    public void setDePreviousRecidenceArea(String dePreviousRecidenceArea) { this.dePreviousRecidenceArea = dePreviousRecidenceArea; }

    public String getDeStatus() { return deStatus; }
    public void setDeStatus(String deStatus) { this.deStatus = deStatus; }

    public String getDeOccupation() { return deOccupation;}
    public void setDeOccupation(String deOccupation) { this.deOccupation = deOccupation;}

    public Double getDeIncome() { return deIncome;}
    public void setDeIncome(Double deIncome) { this.deIncome = deIncome;}


}
