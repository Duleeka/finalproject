package com.gn.app.controller.primaryTask.citizenAssets;


import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CitizenAssetRestController.REQUEST_MAPPING_URL)
public class CitizenAssetRestController {
    public static final String REQUEST_MAPPING_URL="/restapi/assetsofcitizen";


            @Autowired
    CitizenAssetService citizenAssetService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<CitizenAssetDTO> homepage (DataTablesInput input){
        return citizenAssetService.findAllDataTable(input);
    }
}
