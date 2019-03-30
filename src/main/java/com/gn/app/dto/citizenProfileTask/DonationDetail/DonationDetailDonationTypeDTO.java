package com.gn.app.dto.citizenProfileTask.DonationDetail;

import com.gn.app.dto.BaseDTO;

public class DonationDetailDonationTypeDTO extends BaseDTO {
    private Integer id;
    private String donationType;
    private String description;
    private Integer donationRegisterId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getDonationRegisterId() {
        return donationRegisterId;
    }

    public void setDonationRegisterId(Integer donationRegisterId) {
        this.donationRegisterId = donationRegisterId;
    }
}
