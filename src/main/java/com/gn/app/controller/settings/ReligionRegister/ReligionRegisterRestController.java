package com.gn.app.controller.settings.NationalityRegister;

import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import com.gn.app.dto.settings.ReligionRegister.ReligionRegisterDTO;
import com.gn.app.service.settings.NationalityRegister.NationalityRegisterService;
import com.gn.app.service.settings.ReligionRegister.ReligionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ReligionRegisterRestController.REQUEST_MAPPING_URL)
public class ReligionRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/religionregister";

    @Autowired
    ReligionRegisterService religionRegisterService;
    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<ReligionRegisterDTO> homepage (DataTablesInput input){
        return religionRegisterService .findAllDataTable(input);

    }


}
