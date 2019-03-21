package com.gn.app.controller.settings.CertificateDetailRegister;


import com.gn.app.dto.settings.CertificateDetailRegister.CertificateDetailRegisterDTO;
import com.gn.app.service.settings.CertificateDetailRegister.CertificateDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CertificateDetailRegisterRestController.REQUEST_MAPPING_URL)
public class CertificateDetailRegisterRestController {
    public static final String REQUEST_MAPPING_URL = "/restapi/certificatedetailregister";

    @Autowired
    CertificateDetailRegisterService certificateDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CertificateDetailRegisterDTO> homepage (DataTablesInput input){
        return certificateDetailRegisterService.findAllDataTable(input);
    }
}
