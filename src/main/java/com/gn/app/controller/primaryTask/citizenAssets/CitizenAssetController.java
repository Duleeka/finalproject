package com.gn.app.controller.primaryTask.citizenAssets;


import com.gn.app.dto.primaryTask.CitizenAsset.CitizenAssetDTO;
import com.gn.app.service.primaryTask.CitizenAsset.CitizenAssetService;
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



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "primaryTask/citizenAssets/home-view";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenAsset(Model model){
        setCommonData(model,new CitizenAssetDTO());
        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenAsset(Model model, Integer id ) {
        setCommonData(model,citizenAssetService.findById(id));
        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenAsset(Model model, @ModelAttribute CitizenAssetDTO dto) {
        citizenAssetService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/citizenAssets/primary-task-assets-of-citizen";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenAsset(Model model, Integer id){
        citizenAssetService.delete(id);
        return "redirect:/assetsofcitizen/";
    }
    private void setCommonData(Model model, CitizenAssetDTO dto) {
        model.addAttribute("citizenAsset",dto);
    }
}
