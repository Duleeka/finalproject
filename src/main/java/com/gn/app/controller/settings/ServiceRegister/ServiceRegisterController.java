package com.gn.app.controller.settings.ServiceRegister;


import com.gn.app.dto.settings.ServiceRegister.ServiceRegisterDTO;
import com.gn.app.service.settings.ServiceRegister.ServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ServiceRegisterController.REQUEST_MAPPING_URL)
public class ServiceRegisterController {

    public static final String REQUEST_MAPPING_URL = "/serviceregister";

    @Autowired
    ServiceRegisterService serviceRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/serviceRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newServiceRegister (Model model){
        setCommonData(model, new ServiceRegisterDTO());

        return "settings/serviceRegister/service-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editServiceRegister(Model model, Integer id){
        setCommonData(model, serviceRegisterService.findById(id));
        return "settings/serviceRegister/service-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveServiceRegister(Model model, @ModelAttribute ServiceRegisterDTO dto){
        serviceRegisterService.create(dto);
        setCommonData(model,dto);
        return "settings/serviceRegister/service-register";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteServiceRegister(Model model, Integer id){
        serviceRegisterService.delete(id);
        return "redirect/serviceregister/";
    }


    private void setCommonData(Model model, ServiceRegisterDTO dto) {
        model.addAttribute("serviceRegister",dto);    }


}
