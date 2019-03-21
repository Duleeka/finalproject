package com.gn.app.dto.settings.GnDivisionRegister;

import com.gn.app.dto.BaseDTO;

public class GnDivisionRegisterDTO extends BaseDTO {
    private Integer id;
    private String divisionNo;
    private String divisionName;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDivisionNo() {
        return divisionNo;
    }

    public void setDivisionNo(String divisionNo) {
        this.divisionNo = divisionNo;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
