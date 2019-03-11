package com.gn.app.controller.primaryTask.dependentDetail;


import com.gn.app.dto.primaryTask.DependentDetail.DependentDetailDTO;
import com.gn.app.service.primaryTask.DependentDetail.DependentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DependentDetailRestController.REQUEST_MAPPING_URL)
public class DependentDetailRestController {
    public static final String REQUEST_MAPPING_URL ="/restapi/hhdependentdetail";

    @Autowired
    DependentDetailService dependentDetailService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<DependentDetailDTO> homepage(DataTablesInput input) {
        return dependentDetailService.findAllDataTable(input);
    }


}
