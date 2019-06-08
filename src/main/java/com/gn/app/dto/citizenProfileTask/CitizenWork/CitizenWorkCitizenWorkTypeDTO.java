package com.gn.app.dto.citizenProfileTask.CitizenWork;

import com.gn.app.dto.BaseDTO;

public class CitizenWorkCitizenWorkTypeDTO extends BaseDTO {
    private Integer id;
    private String serviceType;
    private String serviceNo;
    private Integer serviceRegisterID;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public Integer getServiceRegisterID() {
        return serviceRegisterID;
    }

    public void setServiceRegisterID(Integer serviceRegisterID) {
        this.serviceRegisterID = serviceRegisterID;
    }
}
