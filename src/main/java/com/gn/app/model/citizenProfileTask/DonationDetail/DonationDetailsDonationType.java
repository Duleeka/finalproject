package com.gn.app.model.citizenProfileTask.DonationDetail;

import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.DonationRegister.DonationRegister;

import javax.persistence.*;

@Entity
@Table(name = "tbl_donationDetail_donationType")
public class DonationDetailsDonationType  extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "donation_detail_id")
    @ManyToOne(targetEntity = DonationDetail.class, fetch = FetchType.LAZY)
    private DonationDetail donationDetail;

    @JoinColumn(name = "donation_register_id")
    @ManyToOne(targetEntity = DonationRegister.class,fetch = FetchType.LAZY)
    private DonationRegister donationRegister;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public DonationDetail getDonationDetail() {
        return donationDetail;
    }

    public void setDonationDetail(DonationDetail donationDetail) {
        this.donationDetail = donationDetail;
    }

    public DonationRegister getDonationRegister() {
        return donationRegister;
    }

    public void setDonationRegister(DonationRegister donationRegister) {
        this.donationRegister = donationRegister;
    }
}
