package com.gn.app.dto.primaryTask.CitizenWork;

import com.gn.app.dto.BaseDTO;


public class CitizenWorkDTO extends BaseDTO {

    private Integer sId;
    private String nic;
    private String sType;
    private String sRegisteredDate;
    private String sReceiverName;
    private String sDescription;

    public Integer getsId() {
        return sId;
    }

    public void setsId(Integer sId) {
        this.sId = sId;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getsType() {
        return sType;
    }

    public void setsType(String sType) {
        this.sType = sType;
    }

    public String getsRegisteredDate() {
        return sRegisteredDate;
    }

    public void setsRegisteredDate(String sRegisteredDate) {
        this.sRegisteredDate = sRegisteredDate;
    }

    public String getsReceiverName() {
        return sReceiverName;
    }

    public void setsReceiverName(String sReceiverName) {
        this.sReceiverName = sReceiverName;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }
}
