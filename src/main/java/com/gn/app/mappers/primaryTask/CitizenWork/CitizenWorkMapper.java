package com.gn.app.mappers.primaryTask.CitizenWork;

import com.gn.app.dto.BaseDTO;
import com.gn.app.dto.primaryTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.BaseModel;
import com.gn.app.model.primaryTask.CitizenWork.CitizenWork;

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
        dto.setsId(citizenWork.getsId());
        dto.setNic(citizenWork.getNic());
        dto.setsType(citizenWork.getsType());
        dto.setsRegisteredDate(citizenWork.getsRegisteredDate());
        dto.setsReceiverName(citizenWork.getsReceiverName());
        dto.setsDescription(citizenWork.getsDescription());
        return dto;
    }

    @Override
    public CitizenWorkDTO domainToDtoForDataTable(CitizenWork citizenWork) throws Exception {
        CitizenWorkDTO dto = new CitizenWorkDTO();
        dto.setsId(citizenWork.getsId());
        dto.setNic(citizenWork.getNic());
        dto.setsType(citizenWork.getsType());
        dto.setsRegisteredDate(citizenWork.getsRegisteredDate());
        dto.setsReceiverName(citizenWork.getsReceiverName());
        return dto;
    }

    @Override
    public void dtoToDomain(CitizenWorkDTO dto, CitizenWork citizenWork) throws Exception {
        citizenWork.setsId(dto.getsId());
        citizenWork.setNic(dto.getNic());
        citizenWork.setsType(dto.getsType());
        citizenWork.setsRegisteredDate(dto.getsRegisteredDate());
        citizenWork.setsReceiverName(dto.getsReceiverName());
        citizenWork.setsDescription(dto.getsDescription());

    }
}
