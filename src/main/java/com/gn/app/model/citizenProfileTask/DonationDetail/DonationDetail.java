package com.gn.app.model.citizenProfileTask.DonationDetail;

import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.DonationRegister.DonationRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "tbl_donation")
public class DonationDetail extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "citizen_id")
    @ManyToOne(targetEntity = CitizenDetail.class,fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @Column(name = "received_date")
    private Date receivedDate;

    @Column(name = "donation_description")
    private String description;


    @OneToMany(mappedBy = "donationDetail",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<DonationDetailsDonationType> donationDetailsDonationTypes;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CitizenDetail getCitizenDetail() {
        return citizenDetail;
    }

    public void setCitizenDetail(CitizenDetail citizenDetail) {
        this.citizenDetail = citizenDetail;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<DonationDetailsDonationType> getDonationDetailsDonationTypes() {
        return donationDetailsDonationTypes;
    }

    public void setDonationDetailsDonationTypes(Set<DonationDetailsDonationType> donationDetailsDonationTypes) {
        this.donationDetailsDonationTypes = donationDetailsDonationTypes;
    }
}
