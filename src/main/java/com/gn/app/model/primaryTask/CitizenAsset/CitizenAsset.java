package com.gn.app.model.primaryTask.CitizenAsset;

import com.gn.app.constant.HouseOwnership;
import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;

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

    @Column(name = "asset_id")
    private String assetId;

    @Column(name = "land_size")
    private Integer landSize;


    @Column(name = "house_ownership")
    private HouseOwnership houseOwnership;

    @Column(name = "house_type")
    private String houseType;

    @Column(name = "roof_type")
    private String roofType;

    @Column(name = "wall_type")
    private String wallType;

    @Column(name = "asset_description")
    private String assetDescription;

    @Column(name = "main_cultivation")
    private String mainCultivation;

    @Column(name = "water_facility")
    private Boolean waterFacility;

    @Column(name = "electricity")
    private Boolean electricity;

    @Column(name = "toilet_facility")
    private Boolean toiletFacility;

    @Column(name = "asset_status")
    private String assetStatus;


    @JoinColumn(name = "citizen_id")
    @ManyToOne(targetEntity = CitizenDetail.class,fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @JoinColumn(name = "land_id")
    @ManyToOne(targetEntity = LandDetailRegister.class,fetch = FetchType.LAZY)
    private LandDetailRegister landDetailRegister;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public CitizenDetail getCitizenDetail() {
        return citizenDetail;
    }

    public void setCitizenDetail(CitizenDetail citizenDetail) {
        this.citizenDetail = citizenDetail;
    }

    public LandDetailRegister getLandDetailRegister() {
        return landDetailRegister;
    }

    public void setLandDetailRegister(LandDetailRegister landDetailRegister) {
        this.landDetailRegister = landDetailRegister;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Integer getLandSize() {
        return landSize;
    }

    public void setLandSize(Integer landSize) {
        this.landSize = landSize;
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
