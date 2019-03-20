package com.gn.app.controller.settings.GnDivisionRegister;

import com.gn.app.dto.settings.GnDivisionRegister.GnDivisionRegisterDTO;
import com.gn.app.service.settings.GnDivisionRegister.GnDivisionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(GnDivisionRegisterController.REQUEST_MAPPING_URL)
public class GnDivisionRegisterController {
    public static final String REQUEST_MAPPING_URL = "/gndivisionregister";

    @Autowired
    GnDivisionRegisterService gnDivisionRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "settings/gnDivisionRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newGnDivisionRegister(Model model) {
        setCommonData(model, new GnDivisionRegisterDTO());
        return "settings/gnDivisionRegister/gn-division-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editDivisionRegister(Model model, Integer id) {
        setCommonData(model, gnDivisionRegisterService.findById(id));
        return "settings/gnDivisionRegister/gn-division-register";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDivisionRegister(Model model, @ModelAttribute GnDivisionRegisterDTO dto) {
        gnDivisionRegisterService.create(dto);
        setCommonData(model, dto);

        return "settings/gnDivisionRegister/gn-division-register";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGnDivisionRegister(Model model, Integer id) {
        gnDivisionRegisterService.delete(id);
        return "redirect:/gndivisionregister/";
    }

    private void setCommonData(Model model, GnDivisionRegisterDTO dto) {
        model.addAttribute("gnDivisionRegister", dto);
    }

}


