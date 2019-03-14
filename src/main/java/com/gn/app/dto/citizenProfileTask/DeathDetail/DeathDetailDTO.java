package com.gn.app.dto.citizenProfileTask.DeathDetail;

import com.gn.app.dto.BaseDTO;

public class DeathDetailDTO extends BaseDTO {

    private Integer id;
    private String dateOfDeath;
    private String deathPlace;
    private String reasonForDeath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public String getReasonForDeath() {
        return reasonForDeath;
    }

    public void setReasonForDeath(String reasonForDeath) {
        this.reasonForDeath = reasonForDeath;
    }
}
