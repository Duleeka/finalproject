package com.gn.app.dto.settings.RoofDetailRegister;

import com.gn.app.dto.BaseDTO;

public class RoofDetailRegisterDTO extends BaseDTO {
    private Integer id;
    private String roofType;
    private String roofDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public String getRoofDescription() {
        return roofDescription;
    }

    public void setRoofDescription(String roofDescription) {
        this.roofDescription = roofDescription;
    }
}
