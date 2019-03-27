package com.gn.app.controller.settings.FloorDetailRegister;

import com.gn.app.dto.settings.FloorDetailRegister.FloorDetailRegisterDTO;
import com.gn.app.service.settings.FloorDetailRegister.FloorDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(FloorDetailRegisterController.REQUEST_MAPPING_URL)
public class FloorDetailRegisterController {

    public static final String REQUEST_MAPPING_URL = "/floordetailregister";

    @Autowired
    FloorDetailRegisterService floorDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/floorDetailRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newFloorDetailRegister (Model model){
        setCommonData(model, new FloorDetailRegisterDTO());

        return "settings/floorDetailRegister/settings-floor-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editLandDetailRegister (Model model, Integer id){
        setCommonData(model,floorDetailRegisterService.findById(id));

        return "settings/floorDetailRegister/settings-floor-detail-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveFloorDetailRegister (Model model, @ModelAttribute FloorDetailRegisterDTO dto){
        floorDetailRegisterService.create(dto);
        setCommonData(model,dto);
        return "settings/floorDetailRegister/settings-floor-detail-register";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteFloorDetailRegister(Model model, Integer id){
        floorDetailRegisterService.delete(id);
        return "redirect/floordetailregister/";
    }


    private void setCommonData(Model model, FloorDetailRegisterDTO dto) {
        model.addAttribute("floorDetailRegister",dto);

    }
}
