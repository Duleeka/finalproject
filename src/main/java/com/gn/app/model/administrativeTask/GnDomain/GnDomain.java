package com.gn.app.model.administrativeTask.GnDomain;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "tbl_gn_domain")
public class GnDomain  extends BaseModel {
    private static final long serialVersionUID= 3466843752790052309L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Integer id;

    @Column(name = "gn_domain_name")
    private String name;

    @Column(name = "domain_status")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
