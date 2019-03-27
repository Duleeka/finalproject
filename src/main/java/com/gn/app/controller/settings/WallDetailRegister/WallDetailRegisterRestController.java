package com.gn.app.controller.settings.WallDetailRegister;

import com.gn.app.dto.settings.WallDetailRegister.WallDetailRegisterDTO;
import com.gn.app.service.settings.WallDetailRegister.WallDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WallDetailRegisterRestController.REQUEST_MAPPING_URL)
public class WallDetailRegisterRestController {
    public static final String REQUEST_MAPPING_URL="/restapi/walldetailregister";

    @Autowired
    WallDetailRegisterService wallDetailRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<WallDetailRegisterDTO> homepage (DataTablesInput input){
        return wallDetailRegisterService.findAllDataTable(input);

    }


}