package com.gn.app.controller.primaryTask.citizenAssets;


import com.gn.app.constant.HouseOwnership;
import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
import com.gn.app.service.settings.FloorDetailRegister.FloorDetailRegisterService;
import com.gn.app.service.settings.LandDetailRegister.LandDetailRegisterService;
import com.gn.app.service.settings.RoofDetailRegister.RoofDetailRegisterService;
import com.gn.app.service.settings.WallDetailRegister.WallDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CitizenAssetController.REQUEST_MAPPING_URL)
public class CitizenAssetController {

    public static final String REQUEST_MAPPING_URL = "/assetsofcitizen";

    @Autowired
    CitizenAssetService citizenAssetService;

    @Autowired
    LandDetailRegisterService landDetailRegisterService;

    @Autowired
    CitizenDetailService citizenDetailService;

    @Autowired
    WallDetailRegisterService wallDetailRegisterService;

    @Autowired
    FloorDetailRegisterService floorDetailRegisterService;

    @Autowired
    RoofDetailRegisterService roofDetailRegisterService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "primaryTask/citizenAssets/home-view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenAssets(Model model) {
        setCommonData(model, new CitizenAssetDTO());
        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenAssets(Model model, Integer id) {
        setCommonData(model, citizenAssetService.findById(id));
        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenAssets(Model model, @ModelAttribute CitizenAssetDTO dto) {
        citizenAssetService.create(dto);
        setCommonData(model, dto);

        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenAssets(Model model, Integer id) {
        citizenAssetService.delete(id);
        return "redirect:/assetsofcitizen/";
    }

    private void setCommonData(Model model, CitizenAssetDTO dto) {
        model.addAttribute("citizenAsset", dto);
        model.addAttribute("houseOwnerships", HouseOwnership.getALLHouseOwnership());
        model.addAttribute("lands", landDetailRegisterService.findAll());
        model.addAttribute("citizens", citizenDetailService.findAll());
        model.addAttribute("roofs", roofDetailRegisterService.findAll());
        model.addAttribute("walls", wallDetailRegisterService.findAll());
        model.addAttribute("floors", floorDetailRegisterService.findAll());

    }
}
