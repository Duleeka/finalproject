package com.gn.app.dto.settings.EducationLevelRegister;


import com.gn.app.dto.BaseDTO;

public class EducationLevelRegisterDTO extends BaseDTO {
    private Integer id;
    private String educationLevel;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
