package com.gn.app.controller.settings.WallDetailRegister;

import com.gn.app.dto.settings.WallDetailRegister.WallDetailRegisterDTO;
import com.gn.app.service.settings.WallDetailRegister.WallDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(WallDetailRegisterController.REQUEST_MAPPING_URL)
public class WallDetailRegisterController {

    public static final String REQUEST_MAPPING_URL = "/walldetailregister";

    @Autowired
    WallDetailRegisterService wallDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/wallDetailRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newWallDetailRegister(Model model) {
        setCommonData(model, new WallDetailRegisterDTO());

        return "settings/wallDetailRegister/settings-wall-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editWallDetailRegister(Model model, Integer id) {
        setCommonData(model, wallDetailRegisterService.findById(id));

        return "settings/wallDetailRegister/settings-wall-detail-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveWallDetailRegister(Model model, @ModelAttribute WallDetailRegisterDTO dto) {
        wallDetailRegisterService.create(dto);
        setCommonData(model, dto);
        return "settings/wallDetailRegister/settings-wall-detail-register";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteWallDetailRegister(Model model, Integer id) {
        wallDetailRegisterService.delete(id);
        return "redirect/walldetailregister/";
    }


    private void setCommonData(Model model, WallDetailRegisterDTO dto) {
        model.addAttribute("wallDetailRegister", dto);
    }
}
