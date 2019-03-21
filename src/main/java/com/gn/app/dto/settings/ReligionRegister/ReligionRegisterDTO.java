package com.gn.app.dto.settings.ReligionRegister;

import com.gn.app.dto.BaseDTO;

public class ReligionRegisterDTO extends BaseDTO {
    private Integer id;
    private String religionType;
    private String religionDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReligionType() {
        return religionType;
    }

    public void setReligionType(String religionType) {
        this.religionType = religionType;
    }

    public String getReligionDescription() {
        return religionDescription;
    }

    public void setReligionDescription(String religionDescription) {
        this.religionDescription = religionDescription;
    }
}
