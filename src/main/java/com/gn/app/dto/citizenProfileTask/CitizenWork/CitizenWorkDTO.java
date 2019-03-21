package com.gn.app.dto.citizenProfileTask.CitizenWork;

import com.gn.app.dto.BaseDTO;

import java.util.Date;


public class CitizenWorkDTO extends BaseDTO {

    private Integer id;
    private Integer citizenId;
    private String cwServiceNo;
    private Integer cwServiceType;
    private String nic;
    private Date receivedDate;
    private String serviceDescription;

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

    public String getCwServiceNo() {
        return cwServiceNo;
    }

    public void setCwServiceNo(String cwServiceNo) {
        this.cwServiceNo = cwServiceNo;
    }

    public Integer getCwServiceType() {
        return cwServiceType;
    }

    public void setCwServiceType(Integer cwServiceType) {
        this.cwServiceType = cwServiceType;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }
}
