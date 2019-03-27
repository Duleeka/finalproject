package com.gn.app.controller.settings.EducationLevelRegister;

import com.gn.app.dto.settings.EducationLevelRegister.EducationLevelRegisterDTO;
import com.gn.app.service.settings.EducationLevelRegister.EducationLevelRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EducationLevelRegisterRestController.REQUEST_MAPPING_URL)
public class EducationLevelRegisterRestController {

    public static final String REQUEST_MAPPING_URL="/restapi/educationlevelregister";

    @Autowired
    EducationLevelRegisterService educationLevelRegisterService;

    @RequestMapping(value = "/",method = RequestMethod.GET)

    public DataTablesOutput<EducationLevelRegisterDTO> homepage (DataTablesInput input){
        return educationLevelRegisterService.findAllDataTable(input);

    }


}