package com.gn.app.dto.settings.WallDetailRegister;

import com.gn.app.dto.BaseDTO;

public class WallDetailRegisterDTO extends BaseDTO {
    private Integer id;
    private String wallType;
    private String wallDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public String getWallDescription() {
        return wallDescription;
    }

    public void setWallDescription(String wallDescription) {
        this.wallDescription = wallDescription;
    }
}
