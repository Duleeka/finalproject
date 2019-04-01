package com.gn.app.dto.settings.ServiceRegister;

import com.gn.app.dto.BaseDTO;

public class ServiceRegisterDTO extends BaseDTO {

    private Integer id;
    private String serviceNo;
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
