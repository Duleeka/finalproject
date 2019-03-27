package com.gn.app.controller.settings.RoofDetailRegister;

import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import com.gn.app.dto.settings.RoofDetailRegister.RoofDetailRegisterDTO;
import com.gn.app.service.settings.FloorDetailRegister.FloorDetailRegisterService;
import com.gn.app.service.settings.RoofDetailRegister.RoofDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RoofDetailRegisterRestController.REQUEST_MAPPING_URL)
public class RoofDetailRegisterRestController {

    public static final String REQUEST_MAPPING_URL ="/restapi/roofdetailregister";

    @Autowired
    RoofDetailRegisterService roofDetailRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<RoofDetailRegisterDTO> homepage (DataTablesInput input){
        return roofDetailRegisterService.findAllDataTable(input);
    }
}
