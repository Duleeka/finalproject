package com.gn.app.controller.primaryTask.citizenWork;


import com.gn.app.dto.primaryTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.service.primaryTask.CitizenWork.CitizenWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CitizenWorkRestController.REQUEST_MAPPING_URL)
public class CitizenWorkRestController {
    public static final String REQUEST_MAPPING_URL = "/restapi/citizenservices";

    @Autowired
    CitizenWorkService citizenWorkService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CitizenWorkDTO> homePage(DataTablesInput input){
        return citizenWorkService.findAllDataTable(input);
    }
}
