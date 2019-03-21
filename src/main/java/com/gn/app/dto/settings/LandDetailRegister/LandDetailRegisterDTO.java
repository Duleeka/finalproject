package com.gn.app.dto.settings.LandDetailRegister;

import com.gn.app.dto.BaseDTO;

public class LandDetailRegisterDTO extends BaseDTO {

    private Integer id;
    private String landType;
    private String landName;
    private String landDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public String getLandDescription() {
        return landDescription;
    }

    public void setLandDescription(String landDescription) {
        this.landDescription = landDescription;
    }
}
