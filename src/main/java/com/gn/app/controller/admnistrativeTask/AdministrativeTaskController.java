package com.gn.app.controller.admnistrativeTask;

import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(AdministrativeTaskController.REQUEST_MAPPING_URL)
public class AdministrativeTaskController {

    public static final String REQUEST_MAPPING_URL = "/administrativeTask";

    @Autowired
    CitizenAssetService assetService;
//
//    @RequestMapping(value = "/basicgnprofile", method = RequestMethod.GET)
//    public String homePage(Model model) {
//      //  model.addAttribute("person", new Person());
//        CitizenAsset asset=new CitizenAsset();
//        asset.setName("dulika");
//        asset.setAssetNo("no");
//
//      //  assetService.create(asset);
//        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
//    }





    @RequestMapping(value = "/diarylog", method = RequestMethod.GET)
    public String homePage1(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
/*asset.setName("dulika");
        asset.setAssetNo("no");*/


        //  assetService.create(asset);
        return "administrativeTask/diaryLog/administrative-task-diary-log";
    }





    @RequestMapping(value = "/gndivision", method = RequestMethod.GET)
    public String homePage2(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
/*asset.setName("dulika");
        asset.setAssetNo("no");*/


        //  assetService.create(asset);
        return "administrativeTask/gnDivision/administrative-task-gn-division";
    }






    @RequestMapping(value = "/province", method = RequestMethod.GET)
    public String homePage3(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
/*
asset.setName("dulika");
        asset.setAssetNo("no");
*/


        //  assetService.create(asset);
        return "administrativeTask/Province/administrative-task-province";
    }




    @RequestMapping(value = "/district", method = RequestMethod.GET)
    public String homePage4(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
/*asset.setName("dulika");
        asset.setAssetNo("no");*/


        //  assetService.create(asset);
        return "administrativeTask/District/administrative-task-district";
    }



    @RequestMapping(value = "/dsoffice", method = RequestMethod.GET)
    public String homePage5(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "administrativeTask/DSOffice/administrative-task-ds-office";
    }



    @RequestMapping(value = "/changepassword", method = RequestMethod.GET)
    public String homePage6(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset=new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "administrativeTask/changePassword/administrative-task-change-password";
    }

}
