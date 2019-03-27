package com.gn.app.dto.settings.FloorDetailRegister;

import com.gn.app.dto.BaseDTO;

public class FloorDetailRegisterDTO extends BaseDTO {
    private Integer id;
    private String floorType;
    private String floorDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFloorType() {
        return floorType;
    }

    public void setFloorType(String floorType) {
        this.floorType = floorType;
    }

    public String getFloorDescription() {
        return floorDescription;
    }

    public void setFloorDescription(String floorDescription) {
        this.floorDescription = floorDescription;
    }
}
