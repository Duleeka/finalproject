package com.gn.app.model.primaryTask.CitizenAsset;

import com.gn.app.constant.HouseOwnership;
import com.gn.app.model.BaseModel;
import com.gn.app.model.Settings.FloorDetailRegister.FloorDetailRegister;
import com.gn.app.model.Settings.LandDetailRegister.LandDetailRegister;
import com.gn.app.model.Settings.RoofDetailRegister.RoofDetailRegister;
import com.gn.app.model.Settings.WallDetailRegister.WallDetailRegister;
import com.gn.app.model.citizenProfileTask.CitizenDetail.CitizenDetail;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

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

    @Column(name = "house_roof_type")
    private String houseRoofType;

    @Column(name = "house_wall_type")
    private String houseWallType;

    @Column(name = "house_floor_type")
    private String houseFloorType;

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

    @Column(name = "vehicle_registered_date")
    private Date vehicleRegisteredDate;


    @JoinColumn(name = "citizen_id")
    @ManyToOne(targetEntity = CitizenDetail.class,fetch = FetchType.LAZY)
    private CitizenDetail citizenDetail;

    @JoinColumn(name = "land_id")
    @ManyToOne(targetEntity = LandDetailRegister.class,fetch = FetchType.LAZY)
    private LandDetailRegister landDetailRegister;

    @JoinColumn(name = "wall_id")
    @ManyToOne(targetEntity = WallDetailRegister.class,fetch = FetchType.LAZY)
    private WallDetailRegister wallDetailRegister;

    @JoinColumn(name = "roof_id")
    @ManyToOne(targetEntity = RoofDetailRegister.class,fetch = FetchType.LAZY)
    private RoofDetailRegister roofDetailRegister;

    @JoinColumn(name = "floor_id")
    @ManyToOne(targetEntity = FloorDetailRegister.class,fetch = FetchType.LAZY)
    private FloorDetailRegister floorDetailRegister;

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

    public WallDetailRegister getWallDetailRegister() {
        return wallDetailRegister;
    }

    public void setWallDetailRegister(WallDetailRegister wallDetailRegister) {
        this.wallDetailRegister = wallDetailRegister;
    }

    public RoofDetailRegister getRoofDetailRegister() {
        return roofDetailRegister;
    }

    public void setRoofDetailRegister(RoofDetailRegister roofDetailRegister) {
        this.roofDetailRegister = roofDetailRegister;
    }

    public FloorDetailRegister getFloorDetailRegister() {
        return floorDetailRegister;
    }

    public void setFloorDetailRegister(FloorDetailRegister floorDetailRegister) {
        this.floorDetailRegister = floorDetailRegister;
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

    public String getHouseRoofType() {
        return houseRoofType;
    }

    public void setHouseRoofType(String houseRoofType) {
        this.houseRoofType = houseRoofType;
    }

    public String getHouseWallType() {
        return houseWallType;
    }

    public void setHouseWallType(String houseWallType) {
        this.houseWallType = houseWallType;
    }

    public String getHouseFloorType() {
        return houseFloorType;
    }

    public void setHouseFloorType(String houseFloorType) {
        this.houseFloorType = houseFloorType;
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


    public Date getVehicleRegisteredDate() {
        return vehicleRegisteredDate;
    }

    public void setVehicleRegisteredDate(Date vehicleRegisteredDate) {
        this.vehicleRegisteredDate = vehicleRegisteredDate;
    }
}
