package com.gn.app.model.Settings.GnDivisionRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_gn_division")
public class GnDivisionRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "division_no")
    private String divisionNo;

    @Column(name = "division_name")
    private String divisionName;

    @Column(name = "description")
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

    public String getDivisionName() {return divisionName;
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
