package com.gn.app.controller.settings.VehicleDetailRegister;

import com.gn.app.dto.settings.VehicleDetailRegister.VehicleDetailRegisterDTO;
import com.gn.app.service.settings.VehicleDetailRegister.VehicleDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(VehicleDetailRegisterRestController.REQUEST_MAPPING_URL)
public class VehicleDetailRegisterRestController {
    public static final String REQUEST_MAPPING_URL = "/restapi/vehicledetailregister";

    @Autowired
    VehicleDetailRegisterService vehicleDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)

    public DataTablesOutput<VehicleDetailRegisterDTO> homepage(DataTablesInput input) {
        return vehicleDetailRegisterService.findAllDataTable(input);

    }


}
