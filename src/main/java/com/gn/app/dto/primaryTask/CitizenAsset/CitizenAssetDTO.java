package com.gn.app.dto.primaryTask.CitizenAsset;

import com.gn.app.dto.BaseDTO;

public class CitizenAssetDTO extends BaseDTO {

    private Integer caId;
    private String assetNo;
    private String assetType;


    public Integer getCaId() {
        return caId;
    }

    public void setCaId(Integer caId) {
        this.caId = caId;
    }

    public String getAssetNo() {
        return assetNo;
    }

    public void setAssetNo(String assetNo) {
        this.assetNo = assetNo;
    }

    public String getAssetType() {
        return assetType;
    }

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }
}
