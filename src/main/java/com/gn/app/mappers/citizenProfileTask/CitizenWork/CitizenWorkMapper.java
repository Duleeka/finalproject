package com.gn.app.mappers.citizenProfileTask.CitizenWork;

import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkCitizenWorkTypeDTO;
import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDonationTypeDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWork;
import com.gn.app.model.citizenProfileTask.CitizenWork.CitizenWorksCitizenWorkType;
import com.gn.app.model.citizenProfileTask.DonationDetail.DonationDetailsDonationType;

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


        if (citizenWork.getReceivedDate()!=null){
            dto.setReceivedDate(new SimpleDateFormat("yyyy-MM-dd").format(citizenWork.getReceivedDate()));
        }

        if (citizenWork.getCitizenDetail()!=null && citizenWork.getCitizenDetail().getNic()!=null) {
            dto.setNic(citizenWork.getCitizenDetail().getNic());
        }

        dto.setServiceDescription(citizenWork.getServiceDescription());
        setServiceRegisters(citizenWork,dto);
        return dto;
    }


    private void setServiceRegisters(CitizenWork citizenWork, CitizenWorkDTO citizenWorkDTO){
        for (CitizenWorksCitizenWorkType citizenWorkCitizenWorkType : citizenWork.getCitizenWorksCitizenWorkTypes()) {
            CitizenWorkCitizenWorkTypeDTO citizenWorkCitizenWorkTypeDTO = new CitizenWorkCitizenWorkTypeDTO();
            citizenWorkCitizenWorkTypeDTO.setId(citizenWorkCitizenWorkType.getId());
            citizenWorkCitizenWorkTypeDTO.setVersion(citizenWorkCitizenWorkType.getVersion());


            if (citizenWorkCitizenWorkTypeDTO != null && citizenWorkCitizenWorkType.getServiceRegister() != null && citizenWorkCitizenWorkType.getServiceRegister().getServiceType() != null) {
                citizenWorkCitizenWorkTypeDTO.setServiceType(citizenWorkCitizenWorkType.getServiceRegister().getServiceType());
            }

            if (citizenWorkCitizenWorkTypeDTO != null && citizenWorkCitizenWorkType.getServiceRegister() != null && citizenWorkCitizenWorkType.getServiceRegister().getServiceNo() != null) {
                citizenWorkCitizenWorkTypeDTO.setServiceNo(citizenWorkCitizenWorkType.getServiceRegister().getServiceNo());
            }

            if (citizenWorkCitizenWorkTypeDTO != null && citizenWorkCitizenWorkType.getServiceRegister() != null && citizenWorkCitizenWorkType.getServiceRegister().getId() != null) {
                citizenWorkCitizenWorkTypeDTO.setServiceRegisterID(citizenWorkCitizenWorkType.getId());
            }

            citizenWorkDTO.getServiceRegisterDTOS().add(citizenWorkCitizenWorkTypeDTO);
        }
    }

    @Override
    public CitizenWorkDTO domainToDtoForDataTable(CitizenWork citizenWork) throws Exception {
        CitizenWorkDTO dto = new CitizenWorkDTO();
        CitizenWorkCitizenWorkTypeDTO citizenWorkCitizenWorkTypeDTO = new CitizenWorkCitizenWorkTypeDTO();

        dto.setId(citizenWork.getId());

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
