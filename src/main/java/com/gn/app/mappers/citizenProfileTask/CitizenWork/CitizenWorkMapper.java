package com.gn.app.mappers.citizenProfileTask.CitizenWork;

import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWork;

import java.text.SimpleDateFormat;

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

        if (citizenWork.getServiceRegister()!=null && citizenWork.getServiceRegister().getServiceNo()!=null) {
            dto.setCwServiceNo(citizenWork.getServiceRegister().getServiceNo());
        }

        if (citizenWork.getServiceRegister()!=null && citizenWork.getServiceRegister().getServiceType()!=null) {
            dto.setCwServiceType(citizenWork.getServiceRegister().getServiceType());
        }

        if (citizenWork.getReceivedDate()!=null){
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(citizenWork.getReceivedDate()));
        }

        if (citizenWork.getCitizenDetail()!=null && citizenWork.getCitizenDetail().getNic()!=null) {
            dto.setNic(citizenWork.getCitizenDetail().getNic());
        }

        dto.setServiceDescription(citizenWork.getServiceDescription());
        return dto;
    }

    @Override
    public CitizenWorkDTO domainToDtoForDataTable(CitizenWork citizenWork) throws Exception {
        CitizenWorkDTO dto = new CitizenWorkDTO();
        dto.setId(citizenWork.getId());
        if (citizenWork.getServiceRegister()!=null && citizenWork.getServiceRegister().getServiceNo()!=null) {
            dto.setCwServiceNo(citizenWork.getServiceRegister().getServiceNo());
        }

        if (citizenWork.getServiceRegister()!=null && citizenWork.getServiceRegister().getServiceType()!=null) {
            dto.setCwServiceType(citizenWork.getServiceRegister().getServiceType());
        }

        if (citizenWork.getCitizenDetail()!=null && citizenWork.getCitizenDetail().getNic()!=null) {
            dto.setNic(citizenWork.getCitizenDetail().getNic());
        }

        if (citizenWork.getReceivedDate()!=null) {
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(citizenWork.getReceivedDate()));
        }

        return dto;
    }

    @Override
    public void dtoToDomain(CitizenWorkDTO dto, CitizenWork citizenWork) throws Exception {
        citizenWork.setId(dto.getId());
        citizenWork.setVersion(dto.getVersion());
        citizenWork.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getReceivedDate()));
        citizenWork.setServiceDescription(dto.getServiceDescription());

    }
}
