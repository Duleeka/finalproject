package com.gn.app.model.citizenProfileTask.DeathDetail;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_death_citizen")
public class DeathDetail extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "date_of_death")
    private String dateOfDeath;

    @Column(name = "death_place")
    private String deathPlace;

    @Column(name = "reason_for_death")
    private String reasonForDeath;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(String dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public String getDeathPlace() {
        return deathPlace;
    }

    public void setDeathPlace(String deathPlace) {
        this.deathPlace = deathPlace;
    }

    public String getReasonForDeath() {
        return reasonForDeath;
    }

    public void setReasonForDeath(String reasonForDeath) {
        this.reasonForDeath = reasonForDeath;
    }
}
