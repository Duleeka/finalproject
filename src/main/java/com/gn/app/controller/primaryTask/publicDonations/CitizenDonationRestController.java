package com.gn.app.controller.primaryTask.publicDonations;


import com.gn.app.dto.primaryTask.CitizenDonation.CitizenDonationDTO;
import com.gn.app.model.primaryTask.CitizenDonation.CitizenDonation;
import com.gn.app.service.primaryTask.CitizenDonation.CitizenDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;

@RestController
@RequestMapping(CitizenDonationRestController.REQUEST_MAPPING_URL)
public class CitizenDonationRestController {
    public static final String REQUEST_MAPPING_URL = "/restapi/publicdonationdetail";

    @Autowired
    CitizenDonationService citizenDonationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CitizenDonationDTO> homePage (DataTablesInput input){
        return citizenDonationService.findAllDataTable(input);
    }
}
