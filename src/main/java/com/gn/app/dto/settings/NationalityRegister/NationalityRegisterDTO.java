package com.gn.app.dto.settings.NationalityRegister;

import com.gn.app.dto.BaseDTO;

public class NationalityRegisterDTO extends BaseDTO {

    private Integer id;
    private String nationalityType;
    private String nationalityDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationalityType() {
        return nationalityType;
    }

    public void setNationalityType(String nationalityType) {
        this.nationalityType = nationalityType;
    }

    public String getNationalityDescription() {
        return nationalityDescription;
    }

    public void setNationalityDescription(String nationalityDescription) {
        this.nationalityDescription = nationalityDescription;
    }
}
