package com.gn.app.controller.citizenProfileTask.donationDetail;


import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.citizenProfileTask.DonationDetail.DonationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DonationDetailRestController.REQUEST_MAPPING_URL)
public class DonationDetailRestController {

    public static final String REQUEST_MAPPING_URL ="/restapi/donationdetail";

    @Autowired
    DonationDetailService donationDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<DonationDetailDTO> homePage(DataTablesInput input){
        return donationDetailService.findAllDataTable(input);
    }
}
