package com.gn.app.mappers.primaryTask.CitizenAsset;

import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;

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
        dto.setHouseholderId(citizenAsset.getHouseholderId());
        dto.setAssetId(citizenAsset.getAssetId());
        dto.setLandName(citizenAsset.getLandName());
        dto.setLandSize(citizenAsset.getLandSize());
        dto.setLandType(citizenAsset.getLandType());
        dto.setHouseOwnership(citizenAsset.getHouseOwnership());
        dto.setHouseType(citizenAsset.getHouseType());
        dto.setRoofType(citizenAsset.getRoofType());
        dto.setWallType(citizenAsset.getWallType());
        dto.setDescription(citizenAsset.getDescription());
        dto.setMainCultivation(citizenAsset.getMainCultivation());
        dto.setWaterFacility(citizenAsset.getWaterFacility());
        dto.setElectricity(citizenAsset.getElectricity());
        dto.setToiletFacility(citizenAsset.getToiletFacility());
        dto.setAssetStatus(citizenAsset.getAssetStatus());
        return dto;
    }

    @Override
    public CitizenAssetDTO domainToDtoForDataTable(CitizenAsset citizenAsset) throws Exception {
        CitizenAssetDTO dto = new CitizenAssetDTO();
        dto.setId(citizenAsset.getId());
        dto.setHouseholderId(citizenAsset.getHouseholderId());
        dto.setAssetId(citizenAsset.getAssetId());
        dto.setLandName(citizenAsset.getLandName());
        dto.setHouseOwnership(citizenAsset.getHouseOwnership());
        dto.setAssetStatus(citizenAsset.getAssetStatus());
        return dto;
    }

    @Override
    public void dtoToDomain(CitizenAssetDTO dto, CitizenAsset citizenAsset) throws Exception {
        citizenAsset.setId(dto.getId());
        citizenAsset.setHouseholderId(dto.getHouseholderId());
        citizenAsset.setAssetId(dto.getAssetId());
        citizenAsset.setLandName(dto.getLandName());
        citizenAsset.setLandSize(dto.getLandSize());
        citizenAsset.setLandType(dto.getLandType());
        citizenAsset.setHouseOwnership(dto.getHouseOwnership());
        citizenAsset.setHouseType(dto.getHouseType());
        citizenAsset.setRoofType(dto.getRoofType());
        citizenAsset.setWallType(dto.getWallType());
        citizenAsset.setDescription(dto.getDescription());
        citizenAsset.setMainCultivation(dto.getMainCultivation());
        citizenAsset.setWaterFacility(dto.getWaterFacility());
        citizenAsset.setElectricity(dto.getElectricity());
        citizenAsset.setToiletFacility(dto.getToiletFacility());
        citizenAsset.setAssetStatus(dto.getAssetStatus());
    }
}
