package com.gn.app.model.citizenProfileTask.CitizenDetail;


import com.gn.app.model.BaseModel;


import javax.persistence.*;

@Entity
@Table(name = "tbl_citizen")
public class CitizenDetail extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "citizen_family_no")
    private  String citizenFamilyNo;

    @Column(name = "is_householder")
    private Boolean isHouseholder;

    @Column(name = "citizen_status")
    private Boolean citizenStatus;

    @Column(name = "relationship")
    private String relationship;

    @Column(name = "citizen_initials")
    private String citizenInitials;

    @Column(name = "citizen_first_name")
    private String citizenFirstName;

    @Column(name = "citizen_middle_name")
    private String citizenMiddleName;

    @Column(name = "citizen_last_name")
    private String citizenLastName;

    @Column(name = "nic")
    private String nic;

    @Column(name = "citizen_date_of_birth")
    private String citizenDateOfBirth;

    @Column(name = "citizen_gender")
    private String citizenGender;

    @Column(name = "marital_status")
    private String maritalStatus;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "citizen_email_address")
    private String citizenEmailAddress;

    @Column(name = "citizen_occupation")
    private String citizenOccupation;

    @Column(name = "citizen_income")
    private Double citizenIncome;

    @Column(name = "citizen_nationality")
    private String citizenNationality;

    @Column(name = "citizen_religion")
    private String citizenReligion;




    @Column(name = "citizen_address")
    private String citizenAddress;

    @Column(name = "citizen_gn_division")
    private String citizenGnDivision;

    @Column(name = "citizen_birth_district")
    private String citizenBirthDistrict;

    @Column(name = "previous_residential_area")
    private String previousResidentialArea;

    @Column(name = "reason_to_change_residential_area")
    private String reasonToChangeResidentialArea;


    @Column(name = "highest_education_Level")
    private String highestEducationLevel;

    @Column(name = "language_proficiency")
    private String languageProficiency;



    /*@Column(name = "d_donation_type")
    private String dDonationType;

    @Column(name = "d_receiving_amount")
    private Double dReceivingAmount;

    @Column(name = "d_account_number")
    private Integer dAccountNumber;

    @Column(name = "d_received_date")
    private String dReceivedDate;

    @Column(name = "d_status")
    private String dStatus;

    @Column(name = "d_description")
    private String dDescription;*/




    /*@JoinColumn(name = "gn_domain_id")
    @ManyToOne(targetEntity = GnDomain.class, fetch = FetchType.LAZY)
    private GnDomain gnDomain;*/

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCitizenFamilyNo() {
        return citizenFamilyNo;
    }

    public void setCitizenFamilyNo(String citizenFamilyNo) {
        this.citizenFamilyNo = citizenFamilyNo;
    }

    public Boolean getHouseholder() {
        return isHouseholder;
    }

    public void setHouseholder(Boolean householder) {
        isHouseholder = householder;
    }

    public Boolean getCitizenStatus() {
        return citizenStatus;
    }

    public void setCitizenStatus(Boolean citizenStatus) {
        this.citizenStatus = citizenStatus;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
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

    public String getCitizenGender() {
        return citizenGender;
    }

    public void setCitizenGender(String citizenGender) {
        this.citizenGender = citizenGender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
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

    public String getHighestEducationLevel() {
        return highestEducationLevel;
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

    public String getCitizenBirthDistrict() {
        return citizenBirthDistrict;
    }

    public void setCitizenBirthDistrict(String citizenBirthDistrict) {
        this.citizenBirthDistrict = citizenBirthDistrict;
    }

    public String getPreviousResidentialArea() {
        return previousResidentialArea;
    }

    public void setPreviousResidentialArea(String previousResidentialArea) {
        this.previousResidentialArea = previousResidentialArea;
    }

    public String getReasonToChangeResidentialArea() {
        return reasonToChangeResidentialArea;
    }

    public void setReasonToChangeResidentialArea(String reasonToChangeResidentialArea) {
        this.reasonToChangeResidentialArea = reasonToChangeResidentialArea;
    }


    public void setHighestEducationLevel(String highestEducationLevel) {
        this.highestEducationLevel = highestEducationLevel;
    }

    public String getLanguageProficiency() {
        return languageProficiency;
    }

    public void setLanguageProficiency(String languageProficiency) {
        this.languageProficiency = languageProficiency;
    }


    /*public String getCDomainName() {
        return cDomainName;
    }

    public void setCDomainName(String cDomainName) {
        this.cDomainName = cDomainName;
    }*/




}




