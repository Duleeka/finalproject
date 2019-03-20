package com.gn.app.controller.settings.LandDetailRegister;

import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.service.settings.LandDetailRegister.LandDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(LandDetailRegisterRestController.REQUEST_MAPPING_URL)
public class LandDetailRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/landdetailregister";

    @Autowired
    LandDetailRegisterService landDetailRegisterService;
    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<LandDetailRegisterDTO> homepage (DataTablesInput input){
        return landDetailRegisterService.findAllDataTable(input);

    }


}
