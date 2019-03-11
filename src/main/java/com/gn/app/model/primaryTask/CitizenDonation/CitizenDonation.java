package com.gn.app.model.primaryTask.CitizenDonation;

import com.gn.app.model.BaseModel;

import javax.persistence.*;


@Entity
@Table(name = "tbl_donation")
public class CitizenDonation extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "householder_id")
    private String householderId;

    @Column(name = "d_donation_type")
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
    private String dDescription;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHouseholderId() {
        return householderId;
    }

    public void setHouseholderId(String householderId) {
        this.householderId = householderId;
    }

    public String getdDonationType() {
        return dDonationType;
    }

    public void setdDonationType(String dDonationType) {
        this.dDonationType = dDonationType;
    }

    public Double getdReceivingAmount() {
        return dReceivingAmount;
    }

    public void setdReceivingAmount(Double dReceivingAmount) {
        this.dReceivingAmount = dReceivingAmount;
    }

    public Integer getdAccountNumber() {
        return dAccountNumber;
    }

    public void setdAccountNumber(Integer dAccountNumber) {
        this.dAccountNumber = dAccountNumber;
    }

    public String getdReceivedDate() {
        return dReceivedDate;
    }

    public void setdReceivedDate(String dReceivedDate) {
        this.dReceivedDate = dReceivedDate;
    }

    public String getdStatus() {
        return dStatus;
    }

    public void setdStatus(String dStatus) {
        this.dStatus = dStatus;
    }

    public String getdDescription() {
        return dDescription;
    }

    public void setdDescription(String dDescription) {
        this.dDescription = dDescription;
    }
}
