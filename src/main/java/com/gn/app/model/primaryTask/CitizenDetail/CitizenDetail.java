package com.gn.app.model.primaryTask.CitizenDetail;


import com.gn.app.model.BaseModel;
import org.springframework.stereotype.Controller;


import javax.persistence.*;

@Entity
@Table(name = "tbl_citizen")
public class CitizenDetail extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "c_family_no")
    private String cFamilyNo;

    @Column(name = "c_initials")
    private String cInitials;

    @Column(name = "c_first_name")
    private String cFirstName;

    @Column(name = "c_middle_name")
    private String cMiddleName;

    @Column(name = "c_last_name")
    private String cLastName;

    @Column(name = "eligibility_type")
    private String eligibilityType;

    @Column(name = "c_nic")
    private String cNic;

    @Column(name = "c_date_of_birth")
    private String cDateOfBirth;

    @Column(name = "c_age")
    private Integer cAge;

    @Column(name = "c_gender")
    private String cGender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "c_address")
    private String cAddress;

    @Column(name = "c_phone_number")
    private Integer cPhoneNumber;

    @Column(name = "c_highest_education_Level")
    private String cHighestEducationLevel;

    @Column(name = "c_occupation")
    private String cOccupation;

    @Column(name = "c_income")
    private Double cIncome;

    @Column(name = "no_of_family_members")
    private Integer noOfFamilyMembers;

    @Column(name = "c_nationality")
    private String cNationality;

    @Column(name = "c_religion")
    private String cReligion;

    @Column(name = "c_birth_district")
    private String cBirthDistrict;

    @Column(name = "c_email_address")
    private String cEmailAddress;

    /*@Column(name = "c_domain_name")
    private String cDomainName;*/

    @Column(name = "status")
    private String status;


    /*@JoinColumn(name = "gn_domain_id")
    @ManyToOne(targetEntity = GnDomain.class, fetch = FetchType.LAZY)
    private GnDomain gnDomain;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCFamilyNo() {
        return cFamilyNo;
    }

    public void setCFamilyNo(String cFamilyNo) {
        this.cFamilyNo = cFamilyNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCInitials() {
        return cInitials;
    }

    public void setCInitials(String cInitials) {
        this.cInitials = cInitials;
    }

    public String getCFirstName() {
        return cFirstName;
    }

    public void setCFirstName(String cFirstName) {
        this.cFirstName = cFirstName;
    }

    public String getCMiddleName() {
        return cMiddleName;
    }

    public void setCMiddleName(String cMiddleName) {
        this.cMiddleName = cMiddleName;
    }

    public String getCLastName() {
        return cLastName;
    }

    public void setCLastName(String cLastName) {
        this.cLastName = cLastName;
    }

    public String getEligibilityType() {
        return eligibilityType;
    }

    public void setEligibilityType(String eligibilityType) {
        this.eligibilityType = eligibilityType;
    }

    public String getCNic() {
        return cNic;
    }

    public void setCNic(String cNic) {
        this.cNic = cNic;
    }

    public String getCDateOfBirth() {
        return cDateOfBirth;
    }

    public void setCDateOfBirth(String cDateOfBirth) {
        this.cDateOfBirth = cDateOfBirth;
    }

    public Integer getCAge() {
        return cAge;
    }

    public void setCAge(Integer cAge) {
        this.cAge = cAge;
    }

    public String getCGender() {
        return cGender;
    }

    public void setCGender(String cGender) {
        this.cGender = cGender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public Integer getCPhoneNumber() {
        return cPhoneNumber;
    }

    public void setCPhoneNumber(Integer cPhoneNumber) {
        this.cPhoneNumber = cPhoneNumber;
    }

    public String getCHighestEducationLevel() {
        return cHighestEducationLevel;
    }

    public void setCHighestEducationLevel(String cHighestEducationLevel) {
        this.cHighestEducationLevel = cHighestEducationLevel;
    }

    public String getCOccupation() {
        return cOccupation;
    }

    public void setCOccupation(String cOccupation) {
        this.cOccupation = cOccupation;
    }

    public Double getCIncome() {
        return cIncome;
    }

    public void setCIncome(Double cIncome) {
        this.cIncome = cIncome;
    }

    public Integer getNoOfFamilyMembers() {
        return noOfFamilyMembers;
    }

    public void setNoOfFamilyMembers(Integer noOfFamilyMembers) {
        this.noOfFamilyMembers = noOfFamilyMembers;
    }

    public String getCNationality() {
        return cNationality;
    }

    public void setCNationality(String cNationality) {
        this.cNationality = cNationality;
    }

    public String getCReligion() {
        return cReligion;
    }

    public void setCReligion(String cReligion) {
        this.cReligion = cReligion;
    }

    public String getCBirthDistrict() {
        return cBirthDistrict;
    }

    public void setCBirthDistrict(String cBirthDistrict) {
        this.cBirthDistrict = cBirthDistrict;
    }

    public String getCEmailAddress() {
        return cEmailAddress;
    }

    public void setCEmailAddress(String cEmailAddress) {
        this.cEmailAddress = cEmailAddress;
    }

    /*public String getCDomainName() {
        return cDomainName;
    }

    public void setCDomainName(String cDomainName) {
        this.cDomainName = cDomainName;
    }*/


}

