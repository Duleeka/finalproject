package com.gn.app.dto.primaryTask.CitizenAsset;

import com.gn.app.constant.HouseOwnership;
import com.gn.app.dto.BaseDTO;

public class CitizenAssetDTO extends BaseDTO {

    private Integer id;
    private String householderId;
    private Integer landId;
    private Integer citizenId;
    private String assetId;
    private String landName;
    private Integer landSize;
    private String landAssetType;
    private HouseOwnership houseOwnership;
    private String houseType;
    private String roofType;
    private String wallType;
    private String assetDescription;
    private String mainCultivation;
    private Boolean waterFacility=Boolean.FALSE;
    private Boolean electricity=Boolean.FALSE;
    private Boolean toiletFacility=Boolean.FALSE;
    private String assetStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLandId() {
        return landId;
    }

    public void setLandId(Integer landId) {
        this.landId = landId;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getHouseholderId() {
        return householderId;
    }

    public void setHouseholderId(String householderId) {
        this.householderId = householderId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public Integer getLandSize() {
        return landSize;
    }

    public void setLandSize(Integer landSize) {
        this.landSize = landSize;
    }

    public String getLandAssetType() {
        return landAssetType;
    }

    public void setLandAssetType(String landAssetType) {
        this.landAssetType = landAssetType;
    }

    public HouseOwnership getHouseOwnership() {
        return houseOwnership;
    }

    public void setHouseOwnership(HouseOwnership houseOwnership) {
        this.houseOwnership = houseOwnership;
    }

    public String getHouseType() {
        return houseType;
    }

    public void setHouseType(String houseType) {
        this.houseType = houseType;
    }

    public String getRoofType() {
        return roofType;
    }

    public void setRoofType(String roofType) {
        this.roofType = roofType;
    }

    public String getWallType() {
        return wallType;
    }

    public void setWallType(String wallType) {
        this.wallType = wallType;
    }

    public String getAssetDescription() {
        return assetDescription;
    }

    public void setAssetDescription(String assetDescription) {
        this.assetDescription = assetDescription;
    }

    public String getMainCultivation() {
        return mainCultivation;
    }

    public void setMainCultivation(String mainCultivation) {
        this.mainCultivation = mainCultivation;
    }

    public Boolean getWaterFacility() {
        return waterFacility;
    }

    public void setWaterFacility(Boolean waterFacility) {
        this.waterFacility = waterFacility;
    }

    public Boolean getElectricity() {
        return electricity;
    }

    public void setElectricity(Boolean electricity) {
        this.electricity = electricity;
    }

    public Boolean getToiletFacility() {
        return toiletFacility;
    }

    public void setToiletFacility(Boolean toiletFacility) {
        this.toiletFacility = toiletFacility;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }
}
