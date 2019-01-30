package com.gn.app.controller.Search;

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
@RequestMapping(SearchController.REQUEST_MAPPING_URL)
public class SearchController {

    public static final String REQUEST_MAPPING_URL = "/search";

    @Autowired
    AssetService assetService;

    @RequestMapping(value = "/citizendetailage", method = RequestMethod.GET)
    public String homePage13(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "search-citizen-detail-age";
    }

}
