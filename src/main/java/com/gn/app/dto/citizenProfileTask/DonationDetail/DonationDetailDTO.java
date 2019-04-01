package com.gn.app.dto.citizenProfileTask.DonationDetail;

import com.gn.app.dto.BaseDTO;

import java.util.ArrayList;
import java.util.List;

public class DonationDetailDTO extends BaseDTO {

    private Integer id;
    private Integer citizenId;
    private String donationType;
    private String receivedDate;
    private String description;
    private List<DonationDetailDonationTypeDTO> donationRegisterDTOS = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }


    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<DonationDetailDonationTypeDTO> getDonationRegisterDTOS() {
        return donationRegisterDTOS;
    }

    public void setDonationRegisterDTOS(List<DonationDetailDonationTypeDTO> donationRegisterDTOS) {
        this.donationRegisterDTOS = donationRegisterDTOS;
    }
}
