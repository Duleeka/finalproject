package com.gn.app.mappers.administrativeTask.GnDomain;

import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.dto.administrativeTask.GnDomain.GnDomainDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.administrativeTask.GnDomain.GnDomain;

public class GnDomainMapper extends GenericMapper<GnDomain, GnDomainDTO> {
    private static GnDomainMapper instance = null;

    private GnDomainMapper(){

    }
    public static GnDomainMapper getInstance(){
        if (instance==null) {
            instance = new GnDomainMapper();
        }
        return instance;
    }

    @Override
    public GnDomainDTO domainToDto(GnDomain gnDomain) throws Exception {
        GnDomainDTO dto=new GnDomainDTO();
        dto.setId(gnDomain.getId());
        dto.setVersion(gnDomain.getVersion());
        dto.setName(gnDomain.getName());
        dto.setStatus(gnDomain.getStatus());
        return dto;
    }
    @Override
    public GnDomainDTO domainToDtoForDataTable(GnDomain gnDomain) throws Exception {
        GnDomainDTO dto=new GnDomainDTO();
        dto.setId(gnDomain.getId());
        dto.setStatus(gnDomain.getStatus());
        dto.setName(gnDomain.getName());
        return dto;
    }

    @Override
    public void dtoToDomain(GnDomainDTO dto, GnDomain gnDomain) throws Exception {
        dto.setId(gnDomain.getId());
        dto.setVersion(gnDomain.getVersion());
        dto.setName(gnDomain.getName());
        dto.setStatus(gnDomain.getStatus());
    }
}
