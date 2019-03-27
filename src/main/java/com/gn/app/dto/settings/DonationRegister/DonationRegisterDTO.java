package com.gn.app.dto.settings.DonationRegister;

import com.gn.app.dto.BaseDTO;

import java.util.Date;

public class DonationRegisterDTO extends BaseDTO {


    private Integer id;
    private String donationType;
    private String description;

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
}
