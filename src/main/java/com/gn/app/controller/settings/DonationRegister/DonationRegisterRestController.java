package com.gn.app.controller.settings.DonationRegister;


import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.service.citizenProfileTask.DonationDetail.DonationDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DonationRegisterRestController.REQUEST_MAPPING_URL)
public class DonationRegisterRestController {

    public static final String REQUEST_MAPPING_URL ="/restapi/donationregister";

    @Autowired
    DonationDetailService donationDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<DonationDetailDTO> homePage(DataTablesInput input){
        return donationDetailService.findAllDataTable(input);
    }
}
