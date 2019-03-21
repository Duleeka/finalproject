package com.gn.app.mappers.citizenProfileTask.CitizenWork;

import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWork;

public class CitizenWorkMapper extends GenericMapper<CitizenWork,CitizenWorkDTO> {
    public static CitizenWorkMapper instance = null;

    private CitizenWorkMapper(){

    }

    public static CitizenWorkMapper getInstance(){
        if(instance==null){
            instance = new CitizenWorkMapper();
        }
        return instance;
    }


    @Override
    public CitizenWorkDTO domainToDto(CitizenWork citizenWork) throws Exception {
        CitizenWorkDTO dto = new CitizenWorkDTO();
        dto.setId(citizenWork.getId());
        dto.setVersion(citizenWork.getVersion());
       dto.setReceivedDate(citizenWork.getReceivedDate());
        dto.setServiceDescription(citizenWork.getServiceDescription());
        return dto;
    }

    @Override
    public CitizenWorkDTO domainToDtoForDataTable(CitizenWork citizenWork) throws Exception {
        CitizenWorkDTO dto = new CitizenWorkDTO();
        dto.setId(citizenWork.getId());
//dto.setCwServiceType(citizenWork.getCitizenDetail().getCitizenFirstName());
        dto.setReceivedDate(citizenWork.getReceivedDate());

        return dto;
    }

    @Override
    public void dtoToDomain(CitizenWorkDTO dto, CitizenWork citizenWork) throws Exception {
        citizenWork.setId(dto.getId());
        citizenWork.setVersion(dto.getVersion());
        citizenWork.setReceivedDate(dto.getReceivedDate());
        citizenWork.setServiceDescription(dto.getServiceDescription());

    }
}
