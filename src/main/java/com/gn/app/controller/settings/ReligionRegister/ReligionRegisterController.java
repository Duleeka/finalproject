package com.gn.app.controller.settings.ReligionRegister;

import com.gn.app.dto.settings.ReligionRegister.ReligionRegisterDTO;
import com.gn.app.service.settings.ReligionRegister.ReligionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ReligionRegisterController.REQUEST_MAPPING_URL)
public class ReligionRegisterController{

    public static final String REQUEST_MAPPING_URL ="/religionregister";

    @Autowired
    ReligionRegisterService religionRegisterService ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/religionRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newReligionRegister (Model model){
        setCommonData(model, new ReligionRegisterDTO());

        return "settings/religionRegister/religion-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editReligionRegister (Model model, Integer id){
        setCommonData(model, religionRegisterService.findById(id));
        return "settings/religionRegister/religion-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveReligionRegister (Model model, @ModelAttribute ReligionRegisterDTO dto){
        religionRegisterService.create(dto);
        setCommonData(model,dto);
        return "settings/religionRegister/religion-register";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteReligionRegister(Model model, Integer id){
        religionRegisterService.delete(id);
        return "redirect/religionregister/";
    }


    private void setCommonData(Model model, ReligionRegisterDTO dto) {
        model.addAttribute("religionRegister",dto);    }


}
