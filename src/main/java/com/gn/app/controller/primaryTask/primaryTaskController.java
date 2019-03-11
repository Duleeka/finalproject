package com.gn.app.controller.primaryTask;

import com.gn.app.model.primaryTask.CitizenAsset.CitizenAsset;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(com.gn.app.controller.primaryTask.primaryTaskController.REQUEST_MAPPING_URL)
public class primaryTaskController {

    public static final String REQUEST_MAPPING_URL = "/primaryTask";

    @Autowired
    CitizenAssetService assetService;

    @RequestMapping(value = "/basichhdetail", method = RequestMethod.GET)
    public String homePage6(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
       /* asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "primaryTask/basicHHDetail/primary-task-basic-hh-detail";
    }

        @RequestMapping(value = "/hhdependentdetail", method = RequestMethod.GET)
        public String homePage7(Model model) {
            //  model.addAttribute("person", new Person());
            CitizenAsset asset = new CitizenAsset();
           /* asset.setName("dulika");
            asset.setAssetNo("no");
*/
            //  assetService.create(asset);
            return "primaryTask/dependentDetail/primary-task-hh-dependent-detail";
        }

    @RequestMapping(value = "/assetsofcitizen", method = RequestMethod.GET)
    public String homePage8(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }

    /*@RequestMapping(value = "/hhdonationRecord", method = RequestMethod.GET)
    public String homePage9(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
        asset.setName("dulika");
        asset.setAssetNo("no");

        //  assetService.create(asset);
        return "primaryTask/donationRecord/primary-task-hh-donation-record";
    }*/

    @RequestMapping(value = "/basiccitizendetail", method = RequestMethod.GET)
    public String homePage10(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "primaryTask/basicCitizenDetail/primary-task-basic-citizen-detail";
    }

    @RequestMapping(value = "/citizenpublicdonations", method = RequestMethod.GET)
    public String homePage11(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
       /* asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "primaryTask/publicDonations/primary-task-citizen-public-donations";
    }

    @RequestMapping(value = "/citizenwork", method = RequestMethod.GET)
    public String homePage12(Model model) {
        //  model.addAttribute("person", new Person());
        CitizenAsset asset = new CitizenAsset();
        /*asset.setName("dulika");
        asset.setAssetNo("no");*/

        //  assetService.create(asset);
        return "primaryTask/citizenWork/primary-task-citizen-services";
    }
}
