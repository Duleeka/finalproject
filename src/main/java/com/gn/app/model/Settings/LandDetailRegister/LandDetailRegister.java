package com.gn.app.model.Settings.LandDetailRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_land_register")
public class LandDetailRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "land_type")
    private String landType;

    @Column(name = "land_name")
    private String landName;

    @Column(name = "land_description")
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
