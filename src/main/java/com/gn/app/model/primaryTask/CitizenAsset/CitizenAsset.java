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

    @Column(name = "id")
    private Integer id;

    @Column(name = "householder_id")
    private String householderId;

    @Column(name = "asset_id")
    private String assetId;

    @Column(name = "land_name")
    private String landName;

    @Column(name = "land_size")
    private Integer landSize;

    @Column(name = "land_type")
    private String landType;

    @Column(name = "house_ownership")
    private String houseOwnership;

    @Column(name = "house_type")
    private String houseType;

    @Column(name = "roof_type")
    private String roofType;

    @Column(name = "wall_type")
    private String wallType;

    @Column(name = "description")
    private String description;

    @Column(name = "main_cultivation")
    private String mainCultivation;

    @Column(name = "water_facility")
    private String waterFacility;

    @Column(name = "electricity")
    private String electricity;

    @Column(name = "toilet_facility")
    private String toiletFacility;

    @Column(name = "asset_status")
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
