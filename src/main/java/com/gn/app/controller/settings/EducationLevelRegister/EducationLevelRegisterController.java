package com.gn.app.controller.settings.EducationLevelRegister;


import com.gn.app.dto.settings.EducationLevelRegister.EducationLevelRegisterDTO;
import com.gn.app.service.settings.EducationLevelRegister.EducationLevelRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(EducationLevelRegisterController.REQUEST_MAPPING_URL)
public class EducationLevelRegisterController {

    public static final String REQUEST_MAPPING_URL = "/educationlevelregister";

    @Autowired
    EducationLevelRegisterService educationLevelRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/educationLevelRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newEducationLevelRegister(Model model) {
        setCommonData(model, new EducationLevelRegisterDTO());

        return "settings/educationLevelRegister/settings-education-level-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editEducationLevelRegister(Model model, Integer id) {
        setCommonData(model, educationLevelRegisterService.findById(id));

        return "settings/educationLevelRegister/settings-education-level-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEducationLevelRegister(Model model, @ModelAttribute EducationLevelRegisterDTO dto) {
        educationLevelRegisterService.create(dto);
        setCommonData(model, dto);
        return "settings/educationLevelRegister/settings-education-level-register";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEducationLevelRegister(Model model, Integer id) {
        educationLevelRegisterService.delete(id);
        return "redirect/educationlevelregister/";
    }


    private void setCommonData(Model model, EducationLevelRegisterDTO dto) {
        model.addAttribute("educationLevel", dto);
    }
}
