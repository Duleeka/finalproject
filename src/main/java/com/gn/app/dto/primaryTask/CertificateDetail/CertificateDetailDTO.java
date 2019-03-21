package com.gn.app.dto.primaryTask.CertificateDetail;

import com.gn.app.dto.BaseDTO;

import java.util.Date;

public class CertificateDetailDTO extends BaseDTO {

    private Integer id;
    private Integer citizenId;
    private Integer certificateId;
    private String certificateNo;
    private String certificateType;
    private String receiverFullName;
    private String nic;
    private  Date certificateIssuedDate;
    private String cdDescription;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public Integer getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(Integer certificateId) {
        this.certificateId = certificateId;
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

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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
}
