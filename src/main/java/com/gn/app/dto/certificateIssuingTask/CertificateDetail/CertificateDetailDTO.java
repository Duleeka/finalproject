package com.gn.app.dto.certificateIssuingTask.CertificateDetail;

import com.gn.app.dto.BaseDTO;

public class CertificateDetailDTO extends BaseDTO {

    private Integer id;
    private String certificateId;
    private String cFamilyNo;
    private String cNic;
    private String receiverFullName;
    private String certificateType;
    private String issueDate;
    private String status;
    private String validPeriod;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCertificateId() {
        return certificateId;
    }

    public void setCertificateId(String certificateId) {
        this.certificateId = certificateId;
    }

    public String getCFamilyNo() { return cFamilyNo;}
    public void setCFamilyNo(String cFamilyNo) { this.cFamilyNo= cFamilyNo;}

    public String getCNic() {
        return cNic;
    }

    public void setCNic(String cNic) {
        this.cNic = cNic;
    }

    public String getReceiverFullName() {
        return receiverFullName;
    }

    public void setReceiverFullName(String receiverFullName) {
        this.receiverFullName = receiverFullName;
    }

    public String getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(String certificateType) {
        this.certificateType = certificateType;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValidPeriod() {
        return validPeriod;
    }

    public void setValidPeriod(String validPeriod) {
        this.validPeriod = validPeriod;
    }
}
