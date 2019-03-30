package com.gn.app.mappers.primaryTask.CitizenAsset;

import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;

import java.text.SimpleDateFormat;

public class CitizenAssetMapper extends GenericMapper<CitizenAsset, CitizenAssetDTO> {

    private static CitizenAssetMapper instance = null;

    private CitizenAssetMapper(){

    }
    public static CitizenAssetMapper getInstance(){
        if (instance==null) {
            instance = new CitizenAssetMapper();
        }
        return instance;
    }

    @Override
    public CitizenAssetDTO domainToDto(CitizenAsset citizenAsset) throws Exception {
        CitizenAssetDTO dto = new CitizenAssetDTO();
        dto.setId(citizenAsset.getId());
        if (citizenAsset.getCitizenDetail()!=null && citizenAsset.getCitizenDetail().getCitizenFamilyNo()!=null) {
            dto.setHouseholderId(citizenAsset.getCitizenDetail().getCitizenFamilyNo());
        }
        if (citizenAsset.getLandDetailRegister()!=null && citizenAsset.getLandDetailRegister().getLandType()!=null){
            dto.setAssetId(citizenAsset.getLandDetailRegister().getLandType());}

        if (citizenAsset.getLandDetailRegister()!=null && citizenAsset.getLandDetailRegister().getLandName()!=null){
            dto.setLandName(citizenAsset.getLandDetailRegister().getLandName());
        }
        dto.setLandSize(citizenAsset.getLandSize());
        dto.setMainCultivation(citizenAsset.getMainCultivation());

        dto.setHouseOwnership(citizenAsset.getHouseOwnership());
        dto.setHouseType(citizenAsset.getHouseType());
        dto.setWaterFacility(citizenAsset.getWaterFacility());
        dto.setElectricity(citizenAsset.getElectricity());
        dto.setToiletFacility(citizenAsset.getToiletFacility());

        if (citizenAsset.getWallDetailRegister()!=null && citizenAsset.getWallDetailRegister().getWallType()!=null){
            dto.setHouseWallType(citizenAsset.getWallDetailRegister().getWallType());
        }
        if (citizenAsset.getRoofDetailRegister()!=null && citizenAsset.getRoofDetailRegister().getRoofType()!=null) {
            dto.setHouseRoofType(citizenAsset.getRoofDetailRegister().getRoofType());
        }
        if (citizenAsset.getFloorDetailRegister()!=null && citizenAsset.getFloorDetailRegister().getFloorType()!=null){
            dto.setHouseFloorType(citizenAsset.getFloorDetailRegister().getFloorType());
        }

        if (citizenAsset.getVehicleRegisteredDate()!=null) {
            dto.setVehicleRegisteredDate(new SimpleDateFormat("yyyy-MM-dd").format(citizenAsset.getVehicleRegisteredDate()));
        }

        dto.setAssetDescription(citizenAsset.getAssetDescription());
        dto.setAssetStatus(citizenAsset.getAssetStatus());
        return dto;
    }

    @Override
    public CitizenAssetDTO domainToDtoForDataTable(CitizenAsset citizenAsset) throws Exception {
        CitizenAssetDTO dto = new CitizenAssetDTO();
        dto.setId(citizenAsset.getId());
        if (citizenAsset.getLandDetailRegister()!=null && citizenAsset.getLandDetailRegister().getLandType()!=null){
        dto.setAssetId(citizenAsset.getLandDetailRegister().getLandType());
        }
        if (citizenAsset.getLandDetailRegister()!=null && citizenAsset.getLandDetailRegister().getLandName()!=null){
            dto.setLandName(citizenAsset.getLandDetailRegister().getLandName());
        }
        if (citizenAsset.getCitizenDetail()!=null && citizenAsset.getCitizenDetail().getCitizenFamilyNo()!=null){

        dto.setHouseholderId(citizenAsset.getCitizenDetail().getCitizenFamilyNo());}
        dto.setHouseOwnership(citizenAsset.getHouseOwnership());
        dto.setAssetStatus(citizenAsset.getAssetStatus());
        return dto;
    }

    @Override
    public void dtoToDomain(CitizenAssetDTO dto, CitizenAsset citizenAsset) throws Exception {
        citizenAsset.setId(dto.getId());
        citizenAsset.setAssetId(dto.getAssetId());
        citizenAsset.setLandSize(dto.getLandSize());
        citizenAsset.setMainCultivation(dto.getMainCultivation());

        citizenAsset.setHouseOwnership(dto.getHouseOwnership());
        citizenAsset.setHouseType(dto.getHouseType());
        citizenAsset.setHouseRoofType(dto.getHouseRoofType());
        citizenAsset.setHouseWallType(dto.getHouseWallType());
        citizenAsset.setHouseFloorType(dto.getHouseFloorType());
        citizenAsset.setWaterFacility(dto.getWaterFacility());
        citizenAsset.setElectricity(dto.getElectricity());
        citizenAsset.setToiletFacility(dto.getToiletFacility());

        //citizenAsset.setVehicleRegisteredDate(dto.getVehicleRegisteredDate());

        citizenAsset.setAssetDescription(dto.getAssetDescription());
        citizenAsset.setAssetStatus(dto.getAssetStatus());
    }
}
