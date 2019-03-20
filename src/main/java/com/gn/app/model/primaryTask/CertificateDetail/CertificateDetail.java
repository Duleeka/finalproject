package com.gn.app.model.primaryTask.CertificateDetail;


import com.gn.app.model.BaseModel;
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


    @Column(name = "issued_date")
    @Temporal(TemporalType.DATE)
    private Date issuedDate;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "citizen_id")
    @ManyToOne(targetEntity = CitizenDetail.class , fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @JoinColumn(name = "certificate_id")
    @ManyToOne(targetEntity = CertificateDetail.class , fetch = FetchType.LAZY)
    private CertificateDetail certificateDetail;


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


    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public CitizenDetail getCitizenDetail() {
        return citizenDetail;
    }

    public void setCitizenDetail(CitizenDetail citizenDetail) {
        this.citizenDetail = citizenDetail;
    }

    public CertificateDetail getCertificateDetail() {
        return certificateDetail;
    }

    public void setCertificateDetail(CertificateDetail certificateDetail) {
        this.certificateDetail = certificateDetail;
    }
}
