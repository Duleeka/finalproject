package com.gn.app.controller.settings.NationalityRegister;

import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import com.gn.app.service.settings.NationalityRegister.NationalityRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(NationalityRegisterRestController.REQUEST_MAPPING_URL)
public class NationalityRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/nationalityregister";

    @Autowired
    NationalityRegisterService nationalityRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<NationalityRegisterDTO> homepage (DataTablesInput input){
        return nationalityRegisterService.findAllDataTable(input);

    }


}
