package com.gn.app.dto.settings.CertificateDetailRegister;

import com.gn.app.dto.BaseDTO;

import java.util.Date;

public class CertificateDetailRegisterDTO extends BaseDTO {
    private Integer id;
    private String certificateNo;
    private String certificateType;
    private Date certificateValidFrom;
    private Date certificateValidTill;


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
