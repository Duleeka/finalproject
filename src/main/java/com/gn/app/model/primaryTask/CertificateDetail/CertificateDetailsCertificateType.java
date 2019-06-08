package com.gn.app.model.primaryTask.CertificateDetail;

import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.CertificateDetailRegister.CertificateDetailRegister;


import javax.persistence.*;

@Entity
@Table(name = "tbl_certificateDetail_certificateType")
public class CertificateDetailsCertificateType extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "certificate_detail_id")
    @ManyToOne(targetEntity = CertificateDetail.class, fetch = FetchType.LAZY)
    private CertificateDetail certificateDetail;

    @JoinColumn(name = "certificate_register_id")
    @ManyToOne(targetEntity = CertificateDetailRegister.class,fetch = FetchType.LAZY)
    private CertificateDetailRegister certificateDetailRegister;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CertificateDetail getCertificateDetail() {
        return certificateDetail;
    }

    public void setCertificateDetail(CertificateDetail certificateDetail) {
        this.certificateDetail = certificateDetail;
    }

    public CertificateDetailRegister getCertificateDetailRegister() {
        return certificateDetailRegister;
    }

    public void setCertificateDetailRegister(CertificateDetailRegister certificateDetailRegister) {
        this.certificateDetailRegister = certificateDetailRegister;
    }


}
