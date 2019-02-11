package com.gn.app.mappers.administrativeTask.GnProfile;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.administrativeTask.GnProfile.GnProfile;

import java.util.Date;

/**
 * Created by hp on 1/31/2019.
 */
public class GnProfileMapper extends GenericMapper<GnProfile,GnProfileDTO> {

    private static GnProfileMapper instance = null;

    private GnProfileMapper(){
    }

    public static GnProfileMapper getInstance() {
        if (instance == null) {
            instance = new GnProfileMapper();
        }
        return instance;
    }
    @Override
    public GnProfileDTO domainToDto(GnProfile gnProfile) throws Exception {
        GnProfileDTO dto=new GnProfileDTO();
        dto.setId(gnProfile.getId());
        dto.setVersion(gnProfile.getVersion());
        dto.setGnId(gnProfile.getGnId());
        dto.setAppointmentDate(gnProfile.getAppointmentDate());
        dto.setFirstName(gnProfile.getFirstName());
        dto.setMiddleName(gnProfile.getMiddleName());
        dto.setLastName(gnProfile.getLastName());
        dto.setOfficeAddress(gnProfile.getOfficeAddress());
        dto.setPhoneNumber(gnProfile.getPhoneNumber());
        dto.setDateOfDutyAssumed("bb");
        return dto;
    }

    @Override
    public GnProfileDTO domainToDtoForDataTable(GnProfile gnProfile) throws Exception {
        GnProfileDTO dto=new GnProfileDTO();
        dto.setId(gnProfile.getId());
        dto.setGnId(gnProfile.getGnId());
        dto.setFirstName(gnProfile.getFirstName());
        dto.setLastName(gnProfile.getLastName());
        dto.setOfficeAddress(gnProfile.getOfficeAddress());
        return dto;
    }

    @Override
    public void dtoToDomain(GnProfileDTO dto, GnProfile gnProfile) throws Exception {
        gnProfile.setId(dto.getId());
        gnProfile.setVersion(dto.getVersion());
        gnProfile.setGnId(dto.getGnId());
        gnProfile.setAppointmentDate(dto.getAppointmentDate());
        gnProfile.setFirstName(dto.getFirstName());
        gnProfile.setMiddleName(dto.getMiddleName());
        gnProfile.setLastName(dto.getLastName());
        gnProfile.setOfficeAddress(dto.getOfficeAddress());
        gnProfile.setPhoneNumber(dto.getPhoneNumber());
        gnProfile.setDateOfDutyAssumed("bb");
    }
}
