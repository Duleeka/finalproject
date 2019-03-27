package com.gn.app.controller.settings.FloorDetailRegister;

import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import com.gn.app.service.settings.FloorDetailRegister.FloorDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(FloorDetailRegisterRestController.REQUEST_MAPPING_URL)
public class FloorDetailRegisterRestController {

    public static final String REQUEST_MAPPING_URL ="/restapi/floordetailregister";

    @Autowired
    FloorDetailRegisterService floorDetailRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<FloorDetailRegisterDTO> homepage (DataTablesInput input){
        return floorDetailRegisterService.findAllDataTable(input);
    }
}
