package com.gn.app.model.Settings.WallDetailRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_wall_register")
public class WallDetailRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "wall_type")
    private String wallType;

    @Column(name = "wall_description")
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
