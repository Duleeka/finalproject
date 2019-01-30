package com.gn.app.controller.certificateIssuingTask;

import com.gn.app.model.Asset;
import com.gn.app.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by hp on 1/6/2019.
 */
@Controller
@RequestMapping(com.gn.app.controller.certificateIssuingTask.CertificateIssuingTaskController.REQUEST_MAPPING_URL)
public class CertificateIssuingTaskController {

    public static final String REQUEST_MAPPING_URL = "/certificateIssuingTask";

    @Autowired
    AssetService assetService;

    @RequestMapping(value = "/basicdetail", method = RequestMethod.GET)
    public String homePage4(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset = new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "certificateIssuingTask/basicDetail/certificate-issuing-task-basic-detail";
    }

    @RequestMapping(value = "/deathregistration", method = RequestMethod.GET)
    public String homePage5(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset = new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "certificateIssuingTask/deathRegistration/certificate-issuing-task-death-registration";
    }
}