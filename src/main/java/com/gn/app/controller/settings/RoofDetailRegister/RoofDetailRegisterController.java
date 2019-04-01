package com.gn.app.controller.settings.RoofDetailRegister;

import com.gn.app.dto.settings.RoofDetailRegister.RoofDetailRegisterDTO;
import com.gn.app.service.settings.RoofDetailRegister.RoofDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(RoofDetailRegisterController.REQUEST_MAPPING_URL)
public class RoofDetailRegisterController {

    public static final String REQUEST_MAPPING_URL = "/roofdetailregister";

    @Autowired
    RoofDetailRegisterService roofDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/roofDetailRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newRoofDetailRegister(Model model) {
        setCommonData(model, new RoofDetailRegisterDTO());

        return "settings/roofDetailRegister/settings-roof-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editRoofDetailRegister(Model model, Integer id) {
        setCommonData(model, roofDetailRegisterService.findById(id));

        return "settings/roofDetailRegister/settings-roof-detail-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveRoofDetailRegister(Model model, @ModelAttribute RoofDetailRegisterDTO dto) {
        roofDetailRegisterService.create(dto);
        setCommonData(model, dto);
        return "settings/roofDetailRegister/settings-roof-detail-register";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteRoofDetailRegister(Model model, Integer id) {
        roofDetailRegisterService.delete(id);
        return "redirect/roofdetailregister/";
    }


    private void setCommonData(Model model, RoofDetailRegisterDTO dto) {
        model.addAttribute("roofDetailRegister", dto);
    }
}
