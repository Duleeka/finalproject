package com.gn.app.controller.settings.NationalityRegister;

import com.gn.app.service.settings.NationalityRegister.NationalityRegisterService;
import com.gn.app.dto.settings.NationalityRegister.NationalityRegisterDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(NationalityRegisterController.REQUEST_MAPPING_URL)
public class NationalityRegisterController {

    public static final String REQUEST_MAPPING_URL ="/nationalityregister";

    @Autowired
NationalityRegisterService nationalityRegisterService ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/nationalityRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newNationalityRegister (Model model){
        setCommonData(model, new NationalityRegisterDTO());

        return "settings/nationalityRegister/nationality-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editNationalityRegister (Model model, Integer id){
        setCommonData(model,nationalityRegisterService. findById(id));
        return "settings/nationalityRegister/nationality-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveNationalityRegister (Model model, @ModelAttribute NationalityRegisterDTO dto){
        nationalityRegisterService.create(dto);
        setCommonData(model,dto);
        return "settings/nationalityRegister/nationality-register";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteNationalityRegister(Model model, Integer id){
        nationalityRegisterService.delete(id);
        return "redirect/nationalityregister/";
    }


    private void setCommonData(Model model, NationalityRegisterDTO dto) {
        model.addAttribute("nationalityRegister",dto);    }


}
