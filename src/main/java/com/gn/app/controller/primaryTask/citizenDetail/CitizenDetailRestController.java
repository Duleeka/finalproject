package com.gn.app.controller.primaryTask.citizenDetail;


import com.gn.app.dto.primaryTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.service.primaryTask.CitizenDetail.CitizenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CitizenDetailRestController.REQUEST_MAPPING_URL)
public class CitizenDetailRestController {

    public static final String REQUEST_MAPPING_URL ="/restapi/basicitizendetail";

    @Autowired
    CitizenDetailService citizenDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CitizenDetailDTO> homePage(DataTablesInput input){
        return citizenDetailService.findAllDataTable(input);
    }
}
