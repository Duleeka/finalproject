package com.gn.app.model.Settings.CertificateDetailRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_certificate_register")
public class CertificateDetailRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "certificate_no")
    private String certificateNo;

    @Column(name = "certificate_type")
    private String certificateType;

    @Column(name = "certificate_valid_from")
    @Temporal(TemporalType.DATE)
    private Date certificateValidFrom;

    @Column(name = "certificate_valid_Till")
    @Temporal(TemporalType.DATE)
    private Date certificateValidTill;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public String getCertificateNo() {
        return certificateNo;
    }

    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public Date getCertificateValidFrom() {
        return certificateValidFrom;
    }

    public void setCertificateValidFrom(Date certificateValidFrom) {
        this.certificateValidFrom = certificateValidFrom;
    }

    public Date getCertificateValidTill() {
        return certificateValidTill;
    }

    public void setCertificateValidTill(Date certificateValidTill) {
        this.certificateValidTill = certificateValidTill;
    }
}
