package com.gn.app.controller.admnistrativeTask;

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
@RequestMapping(AdministrativeTaskController.REQUEST_MAPPING_URL)
public class AdministrativeTaskController {

    public static final String REQUEST_MAPPING_URL = "/administrativeTask";

    @Autowired
    AssetService assetService;

    @RequestMapping(value = "/basicgnprofile", method = RequestMethod.GET)
    public String homePage(Model model) {
      //  model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("wasantha");
        asset.setAssetNo("no");

      //  assetService.create(asset);
        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
    }

}
