package com.gn.app.controller.settings.GnDivisionRegister;

import com.gn.app.dto.settings.GnDivisionRegister.GnDivisionRegisterDTO;
import com.gn.app.service.settings.GnDivisionRegister.GnDivisionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(GnDivisionRegisterRestController.REQUEST_MAPPING_URL)
public class GnDivisionRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/gndivisionregister";

    @Autowired
    GnDivisionRegisterService gnDivisionRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<GnDivisionRegisterDTO> homepage (DataTablesInput input){
        return gnDivisionRegisterService.findAllDataTable(input);

    }


}
