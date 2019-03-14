package com.gn.app.mappers.citizenProfileTask.DeathDetail;

import com.gn.app.dto.citizenProfileTask.DeathDetail.DeathDetailDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.mappers.citizenProfileTask.CitizenDetail.CitizenDetailMapper;
import com.gn.app.model.citizenProfileTask.DeathDetail.DeathDetail;

public class DeathDetailMapper extends GenericMapper<DeathDetail, DeathDetailDTO> {

    private static DeathDetailMapper instance = null;

    private DeathDetailMapper(){

    }
    public static DeathDetailMapper getInstance(){
        if (instance==null) {
            instance = new DeathDetailMapper();
        }
        return instance;
    }



    @Override
    public DeathDetailDTO domainToDto(DeathDetail deathDetail) throws Exception {
        DeathDetailDTO dto = new DeathDetailDTO();
        dto.setId(deathDetail.getId());
        dto.setDateOfDeath(deathDetail.getDateOfDeath());
        dto.setDeathPlace(deathDetail.getDeathPlace());
        dto.setReasonForDeath(deathDetail.getReasonForDeath());
        return dto;
    }

    @Override
    public DeathDetailDTO domainToDtoForDataTable(DeathDetail deathDetail) throws Exception {
        return null;
    }

    @Override
    public void dtoToDomain(DeathDetailDTO dto, DeathDetail deathDetail) throws Exception {
        deathDetail.setId(dto.getId());
        deathDetail.setDateOfDeath(dto.getDateOfDeath());
        deathDetail.setDeathPlace(dto.getDeathPlace());
        deathDetail.setReasonForDeath(dto.getReasonForDeath());
    }
}
