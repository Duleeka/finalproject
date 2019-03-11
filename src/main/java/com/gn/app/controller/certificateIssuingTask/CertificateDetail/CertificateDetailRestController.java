package com.gn.app.controller.certificateIssuingTask.CertificateDetail;

import com.gn.app.dto.certificateIssuingTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.service.certificateIssuingTask.CertificateDetail.CertificateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CertificateDetailRestController.REQUEST_MAPPING_URL)
public class CertificateDetailRestController {
    public static final String REQUEST_MAPPING_URL = "/restapi/basicdetail";

    @Autowired
    CertificateDetailService certificateDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CertificateDetailDTO> homepage (DataTablesInput input){
        return certificateDetailService.findAllDataTable(input);
    }
}
