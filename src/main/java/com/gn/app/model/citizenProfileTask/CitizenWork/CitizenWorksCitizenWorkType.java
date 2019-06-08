package com.gn.app.model.citizenProfileTask.CitizenWork;

import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.ServiceRegister.ServiceRegister;

import javax.persistence.*;

@Entity
@Table(name = "tbl_citizenwork_citizenworktype")
public class CitizenWorksCitizenWorkType extends BaseModel {
    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "citizen_service_id")
    @ManyToOne(targetEntity = CitizenWork.class, fetch = FetchType.LAZY)
    private CitizenWork citizenWork;

    @JoinColumn(name = "service_register_id")
    @ManyToOne(targetEntity = ServiceRegister.class, fetch = FetchType.LAZY)
    private ServiceRegister serviceRegister;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CitizenWork getCitizenWork() {
        return citizenWork;
    }

    public void setCitizenWork(CitizenWork citizenWork) {
        this.citizenWork = citizenWork;
    }

    public ServiceRegister getServiceRegister() {
        return serviceRegister;
    }

    public void setServiceRegister(ServiceRegister serviceRegister) {
        this.serviceRegister = serviceRegister;
    }

    public void add(CitizenWorksCitizenWorkType citizenWorksCitizenWorkType) {
    }
}
