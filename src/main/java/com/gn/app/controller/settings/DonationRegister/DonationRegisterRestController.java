package com.gn.app.controller.settings.DonationRegister;


import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import com.gn.app.service.citizenProfileTask.DonationDetail.DonationDetailService;
import com.gn.app.service.settings.DonationRegister.DonationRegisterService;
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
    DonationRegisterService donationRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<DonationRegisterDTO> homePage(DataTablesInput input){
        return donationRegisterService.findAllDataTable(input);
    }
}
