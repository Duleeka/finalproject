package com.gn.app.model.primaryTask.CitizenAsset;

import com.gn.app.model.BaseModel;

import javax.persistence.*;

/**
 * Created by hp on 1/7/2019.
 */
@Entity
@Table(name = "tbl_assets")
public class CitizenAsset extends BaseModel {

    private static final long serialVersionUID = 3466843752790052309L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ca_id")
    private Integer caId;

    @Column(name = "asset_type")
    private String assetType;

    @Column(name = "asset_no")
    private String assetNo;


    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

}
