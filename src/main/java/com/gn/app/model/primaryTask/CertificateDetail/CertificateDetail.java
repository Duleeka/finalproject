package com.gn.app.model.primaryTask.CertificateDetail;


import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.CertificateDetailRegister.CertificateDetailRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

import javax.persistence.*;
import java.util.Date;



@Entity
@Table(name = "tbl_certificate")
public class CertificateDetail extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "certificate_no")
    private String certificateNo;

    @Column(name = "certificate_type")
    private String certificateType;


    @Column(name = "certificate_issued_date")
    @Temporal(TemporalType.DATE)
    private Date certificateIssuedDate;

    @Column(name = "cd_description")
    private String cdDescription;

    @JoinColumn(name = "citizen_id")
    @ManyToOne(targetEntity = CitizenDetail.class , fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @JoinColumn(name = "certificate_id")
    @ManyToOne(targetEntity = CertificateDetailRegister.class , fetch = FetchType.LAZY)
    private CertificateDetailRegister certificateDetailRegister;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }


    public Date getCertificateIssuedDate() {
        return certificateIssuedDate;
    }

    public void setCertificateIssuedDate(Date certificateIssuedDate) {
        this.certificateIssuedDate = certificateIssuedDate;
    }

    public String getCdDescription() {
        return cdDescription;
    }

    public void setCdDescription(String cdDescription) {
        this.cdDescription = cdDescription;
    }

    public CitizenDetail getCitizenDetail() {
        return citizenDetail;
    }

    public void setCitizenDetail(CitizenDetail citizenDetail) {
        this.citizenDetail = citizenDetail;
    }

    public CertificateDetailRegister getCertificateDetailRegister() {
        return certificateDetailRegister;
    }

    public void setCertificateDetailRegister(CertificateDetailRegister certificateDetailRegister) {
        this.certificateDetailRegister = certificateDetailRegister;
    }
}
