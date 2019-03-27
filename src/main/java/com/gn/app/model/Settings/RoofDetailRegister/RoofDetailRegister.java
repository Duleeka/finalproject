package com.gn.app.model.Settings.RoofDetailRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_roof_register")
public class RoofDetailRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "roof_type")
    private String roofType;

    @Column(name = "roof_description")
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
