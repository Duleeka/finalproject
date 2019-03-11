package com.gn.app.controller.admnistrativeTask.gnDomain;

import com.gn.app.dto.administrativeTask.GnDomain.GnDomainDTO;
import com.gn.app.service.AdministrativeTask.GnDomain.GnDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(com.gn.app.controller.admnistrativeTask.gnDomain.GnDomainRestController.REQUEST_MAPPING_URL)
public class GnDomainRestController {
    public static final String REQUEST_MAPPING_URL="/restapi/gndivision";

    @Autowired
    GnDomainService gnDomainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<GnDomainDTO> homepage (DataTablesInput input){
        return gnDomainService.findAllDataTable(input);
    }
}
