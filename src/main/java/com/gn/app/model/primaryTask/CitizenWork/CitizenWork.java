package com.gn.app.model.primaryTask.CitizenWork;

import com.gn.app.model.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


@Entity
@Table(name="tbl_citizen_service")
public class CitizenWork extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "s_id")
    private Integer sId;

    @Column(name = "nic")
    private String nic;

    @Column(name = "s_type")
    private String sType;

    @Column(name = "s_registered_date")
    private String sRegisteredDate;

    @Column(name = "s_receiver_name")
    private String sReceiverName;

    @Column(name = "s_description")
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
