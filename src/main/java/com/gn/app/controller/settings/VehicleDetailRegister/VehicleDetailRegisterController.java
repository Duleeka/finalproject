
package com.gn.app.controller.settings.VehicleDetailRegister;

import com.gn.app.dto.settings.VehicleDetailRegister.VehicleDetailRegisterDTO;
import com.gn.app.service.settings.VehicleDetailRegister.VehicleDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(VehicleDetailRegisterController.REQUEST_MAPPING_URL)
public class VehicleDetailRegisterController {

    public static final String REQUEST_MAPPING_URL = "/vehicledetailregister";

    @Autowired
    VehicleDetailRegisterService vehicleDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "settings/vehicleDetailRegister/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newVehicleDetailRegister(Model model) {
        setCommonData(model, new VehicleDetailRegisterDTO());

        return "settings/vehicleDetailRegister/settings-vehicle-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editVehicleDetailRegister(Model model, Integer id) {
        setCommonData(model, vehicleDetailRegisterService.findById(id));

        return "settings/vehicleDetailRegister/settings-vehicle-detail-register";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveVehicleDetailRegister(Model model, @ModelAttribute VehicleDetailRegisterDTO dto) {
        vehicleDetailRegisterService.create(dto);
        setCommonData(model, dto);
        return "settings/vehicleDetailRegister/settings-vehicle-detail-register";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteVehicleDetailRegister(Model model, Integer id) {
        vehicleDetailRegisterService.delete(id);
        return "redirect/vehicledetailregister/";
    }


    private void setCommonData(Model model, VehicleDetailRegisterDTO dto) {
        model.addAttribute("vehicleDetailRegister", dto);
    }
}


