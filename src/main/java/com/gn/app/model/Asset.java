package com.gn.app.model;

import javax.persistence.*;

/**
 * Created by hp on 1/7/2019.
 */
@Entity
@Table(name = "tbl_assets")
public class Asset extends BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "asset_name")
    private String name;

    @Column(name = "asset_no")
    private String assetNo;

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

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }
}
