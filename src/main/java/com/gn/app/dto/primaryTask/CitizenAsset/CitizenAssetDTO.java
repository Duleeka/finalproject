package com.gn.app.dto.primaryTask.CitizenAsset;

import com.gn.app.dto.BaseDTO;

public class CitizenAssetDTO extends BaseDTO {

    private Integer id;
    private String householderId;
    private String assetId;
    private String landName;
    private Integer landSize;
    private String landType;
    private String houseOwnership;
    private String houseType;
    private String roofType;
    private String wallType;
    private String assetDescription;
    private String mainCultivation;
    private String waterFacility;
    private String electricity;
    private String toiletFacility;
    private String assetStatus;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLandType() {
        return landType;
    }

    public void setLandType(String landType) {
        this.landType = landType;
    }

    public String getHouseOwnership() {
        return houseOwnership;
    }

    public void setHouseOwnership(String houseOwnership) {
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

    public String getWaterFacility() {
        return waterFacility;
    }

    public void setWaterFacility(String waterFacility) {
        this.waterFacility = waterFacility;
    }

    public String getElectricity() {
        return electricity;
    }

    public void setElectricity(String electricity) {
        this.electricity = electricity;
    }

    public String getToiletFacility() {
        return toiletFacility;
    }

    public void setToiletFacility(String toiletFacility) {
        this.toiletFacility = toiletFacility;
    }

    public String getAssetStatus() {
        return assetStatus;
    }

    public void setAssetStatus(String assetStatus) {
        this.assetStatus = assetStatus;
    }
}
