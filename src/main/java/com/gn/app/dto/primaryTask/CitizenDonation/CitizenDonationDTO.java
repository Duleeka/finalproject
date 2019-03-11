package com.gn.app.dto.primaryTask.CitizenDonation;

import com.gn.app.dto.BaseDTO;

public class CitizenDonationDTO extends BaseDTO {
    private Integer id;
    private String householderId;
    private String dDonationType;
    private Double dReceivingAmount;
    private Integer dAccountNumber;
    private String dReceivedDate;
    private String dStatus;
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
