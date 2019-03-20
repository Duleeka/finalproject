package com.gn.app.controller.settings.ServiceRegister;

import com.gn.app.dto.settings.ServiceRegister.ServiceRegisterDTO;
import com.gn.app.service.settings.ServiceRegister.ServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ServiceRegisterRestController.REQUEST_MAPPING_URL)
public class ServiceRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/serviceregister";

    @Autowired
    ServiceRegisterService serviceRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<ServiceRegisterDTO> homepage (DataTablesInput input){
        return serviceRegisterService .findAllDataTable(input);

    }


}
