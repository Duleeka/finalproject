package com.gn.app.controller.certificateIssuingTask;

import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(certificateIssuingTaskController.REQUEST_MAPPING_URL)
public class certificateIssuingTaskController {
    public static final String REQUEST_MAPPING_URL="/certificateIssuingTask";

    @Autowired
    CitizenAssetService assetService;

    @RequestMapping(value = "/basicdetail",method = RequestMethod.GET)
    public String homepage7(Model model){
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "certificateIssuingTask/basicDetail/certificate-issuing-task-basic-detail";
    }
    @RequestMapping(value = "/deathregistration",method = RequestMethod.GET)
    public String homepage8(Model model){
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");
*/
        //  assetService.create(asset);
        return "certificateIssuingTask/deathRegistration/certificate-issuing-task-death-registration";
    }

}
