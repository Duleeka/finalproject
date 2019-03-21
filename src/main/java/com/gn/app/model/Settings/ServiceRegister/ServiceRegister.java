package com.gn.app.model.Settings.ServiceRegister;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_citizen_service_register")
public class ServiceRegister extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "service_no")
    private String serviceNo;

    @Column(name = "service_type")
    private String serviceType;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }
}
