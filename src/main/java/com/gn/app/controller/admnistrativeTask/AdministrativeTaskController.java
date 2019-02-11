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
//
//    @RequestMapping(value = "/basicgnprofile", method = RequestMethod.GET)
//    public String homePage(Model model) {
//      //  model.addAttribute("person", new Person());
//        Asset asset=new Asset();
//        asset.setName("dulika");
//        asset.setAssetNo("no");
//
//      //  assetService.create(asset);
//        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
//    }

/*Diary log controller*/


    @RequestMapping(value = "/diarylog", method = RequestMethod.GET)
    public String homePage1(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "administrativeTask/diaryLog/administrative-task-diary-log";
    }
    /*end of Diary log controller*/

    /*Division Detail controller*/
    @RequestMapping(value = "/divisiondetail", method = RequestMethod.GET)
    public String homePage2(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "administrativeTask/gnDivision/administrative-task-gn-division-detail";
    }
    /*End of Division Detail controller*/

    /*password change controller*/
    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String homePage3(Model model) {
        //  model.addAttribute("person", new Person());
        Asset asset=new Asset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "administrativeTask/changePassword/administrative-task-change-password";
    }
    /*End of password change controller*/
}
