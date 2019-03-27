package com.gn.app.model.citizenProfileTask.CitizenDetail;


import com.gn.app.constant.District;
import com.gn.app.constant.Gender;
import com.gn.app.constant.MaritalStatus;
import com.gn.app.constant.Relationship;
import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.EducationLevelRegister.EducationLevelRegister;
import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import com.gn.app.model.Settings.ReligionRegister.ReligionRegister;


import javax.persistence.*;
import java.util.Date;

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
    private Relationship relationship;

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
    private Date citizenDateOfBirth;

    @Column(name = "citizen_gender")
    private Gender citizenGender;

    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

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
    private District citizenBirthDistrict;

    @Column(name = "previous_residential_area")
    private District previousResidentialArea;

    @Column(name = "reason_to_change_residential_area")
    private String reasonToChangeResidentialArea;


    @Column(name = "highest_education_Level")
    private String highestEducationLevel;

    @Column(name = "death_place")
    private String deathPlace;

    @Column(name = "death_reason")
    private String deathReason;

    @Column(name = "date_of_death")
    private Date dateOfDeath;

    @JoinColumn(name = "nationality_id")
    @ManyToOne(targetEntity = NationalityRegister.class,fetch = FetchType.LAZY)
    private NationalityRegister nationalityRegister;

    @JoinColumn(name = "religion_id")
    @ManyToOne(targetEntity = ReligionRegister.class,fetch = FetchType.LAZY)
    private ReligionRegister religionRegister;


    @JoinColumn(name = "gn_division_id")
    @ManyToOne(targetEntity = GnDivisionRegister.class,fetch = FetchType.LAZY)
    private GnDivisionRegister gnDivisionRegister;

    @JoinColumn(name = "education_id")
    @ManyToOne(targetEntity = EducationLevelRegister.class,fetch = FetchType.LAZY)
    private EducationLevelRegister educationLevelRegister;






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


    public NationalityRegister getNationalityRegister() {
        return nationalityRegister;
    }

    public void setNationalityRegister(NationalityRegister nationalityRegister) {
        this.nationalityRegister = nationalityRegister;


    }


    public ReligionRegister getReligionRegister() {
        return religionRegister;
    }

    public void setReligionRegister(ReligionRegister religionRegister) {
        this.religionRegister = religionRegister;
    }

    public GnDivisionRegister getGnDivisionRegister() {
        return gnDivisionRegister;
    }

    public void setGnDivisionRegister(GnDivisionRegister gnDivisionRegister) {
        this.gnDivisionRegister = gnDivisionRegister;
    }

    public EducationLevelRegister getEducationLevelRegister() {
        return educationLevelRegister;
    }

    public void setEducationLevelRegister(EducationLevelRegister educationLevelRegister) {
        this.educationLevelRegister = educationLevelRegister;
    }

    public Date getCitizenDateOfBirth() {
        return citizenDateOfBirth;
    }

    public void setCitizenDateOfBirth(Date citizenDateOfBirth) {
        this.citizenDateOfBirth = citizenDateOfBirth;
    }

    public Date getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(Date dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }


}




