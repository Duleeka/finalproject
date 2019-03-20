package com.gn.app.model.citizenProfileTask.CitizenWork;

import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "tbl_citizen_service")
public class CitizenWork extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "received_date")
    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Column(name = "service_description")
    private String serviceDescription;


    @JoinColumn(name ="citizen_id" )
    @ManyToOne(targetEntity = CitizenDetail.class ,fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @JoinColumn(name ="service_id" )
    @ManyToOne(targetEntity = ServiceRegister.class ,fetch = FetchType.LAZY)
    private ServiceRegister serviceRegister;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public CitizenDetail getCitizenDetail() {
        return citizenDetail;
    }

    public void setCitizenDetail(CitizenDetail citizenDetail) {
        this.citizenDetail = citizenDetail;
    }

    public ServiceRegister getServiceRegister() {
        return serviceRegister;
    }

    public void setServiceRegister(ServiceRegister serviceRegister) {
        this.serviceRegister = serviceRegister;
    }
}
