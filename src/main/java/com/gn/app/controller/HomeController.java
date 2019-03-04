package com.gn.app.controller.dashboard;

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
@RequestMapping(HomeController.REQUEST_MAPPING_URL)
public class HomeController {

    public static final String REQUEST_MAPPING_URL = "/dashboard";

    @Autowired
    AssetService assetService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model){
        //model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");
        return "dashboard/index";
    }

}
