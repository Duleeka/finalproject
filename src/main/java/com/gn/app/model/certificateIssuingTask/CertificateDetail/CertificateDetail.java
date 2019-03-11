package com.gn.app.model.certificateIssuingTask.CertificateDetail;


import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_certificate")
public class CertificateDetail extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "certificate_id")
    private String certificateId;

    @Column(name = "c_family_no")
    private String cFamilyNo;

    @Column(name = "c_nic")
    private String cNic;

    @Column(name = "receiver_full_name")
    private String receiverFullName;

    @Column(name = "certificate_type")
    private String certificateType;

    @Column(name = "issue_date")
    private String issueDate;

    @Column(name = "status")
    private String status;

    @Column(name = "valid_period")
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

    public String getCNic() { return cNic;}

    public void setCNic(String cNic) { this.cNic = cNic;}

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
