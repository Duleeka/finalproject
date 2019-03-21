package com.gn.app.model.Settings.NationalityRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_nationality")
public class NationalityRegister extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "nationality_type")
    private String nationalityType;

    @Column(name = "nationality_description")
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
