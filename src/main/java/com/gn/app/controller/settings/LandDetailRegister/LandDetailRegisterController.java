package com.gn.app.controller.settings.LandDetailRegister;


import com.gn.app.dto.settings.LandDetailRegister.LandDetailRegisterDTO;
import com.gn.app.service.settings.LandDetailRegister.LandDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(LandDetailRegisterController.REQUEST_MAPPING_URL)
public class LandDetailRegisterController {

    public static final String REQUEST_MAPPING_URL = "/landdetailregister";

    @Autowired
    LandDetailRegisterService landDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/landDetailRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newLandDetailRegister (Model model){
        setCommonData(model, new LandDetailRegisterDTO());

        return "settings/landDetailRegister/land-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editLandDetailRegister (Model model, Integer id){
        setCommonData(model,landDetailRegisterService.findById(id));

        return "settings/landDetailRegister/land-detail-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveLandDetailRegister (Model model, @ModelAttribute LandDetailRegisterDTO dto){
        landDetailRegisterService.create(dto);
        setCommonData(model,dto);
        return "settings/landDetailRegister/land-detail-register";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteLandDetailRegister(Model model, Integer id){
        landDetailRegisterService.delete(id);
        return "redirect/landdetailregister/";
    }


    private void setCommonData(Model model, LandDetailRegisterDTO dto) {
        model.addAttribute("landDetailRegister",dto);    }
}
