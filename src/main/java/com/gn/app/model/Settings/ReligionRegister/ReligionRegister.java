package com.gn.app.model.Settings.ReligionRegister;

import com.gn.app.model.BaseModel;
import javax.persistence.*;

@Entity
@Table(name = "tbl_religion")
public class ReligionRegister extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "religion_type")
    private String religionType;

    @Column(name = "religion_description")
    private String  religionDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReligionType() {
        return religionType;
    }

    public void setReligionType(String religionType) {
        this.religionType = religionType;
    }

    public String getReligionDescription() {
        return religionDescription;
    }

    public void setReligionDescription(String religionDescription) {
        this.religionDescription = religionDescription;
    }
}
