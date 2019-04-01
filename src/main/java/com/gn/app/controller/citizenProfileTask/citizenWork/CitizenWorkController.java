package com.gn.app.controller.citizenProfileTask.citizenWork;


import com.gn.app.dto.citizenProfileTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.citizenProfileTask.CitizenWork.CitizenWorkService;
import com.gn.app.service.settings.ServiceRegister.ServiceRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CitizenWorkController.REQUEST_MAPPING_URL)
public class CitizenWorkController {

    public static final String REQUEST_MAPPING_URL = "/citizenservices";

    @Autowired
    CitizenWorkService citizenWorkService;

    @Autowired
    ServiceRegisterService serviceRegisterService;

    @Autowired
    CitizenDetailService citizenDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "citizenProfileTask/citizenWork/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenWork(Model model) {
        setCommonData(model, new CitizenWorkDTO());

        return "citizenProfileTask/citizenWork/primary-task-citizen-services";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenWork(Model model, Integer id) {
        setCommonData(model, citizenWorkService.findById(id));
        return "citizenProfileTask/citizenWork/primary-task-citizen-services";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenWork(Model model, @ModelAttribute CitizenWorkDTO dto) {
        citizenWorkService.create(dto);
        setCommonData(model, dto);
        return "citizenProfileTask/citizenWork/primary-task-citizen-services";

    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenWork(Model model, Integer id) {
        citizenWorkService.delete(id);
        return "redirect/citizenservices/";
    }


    private void setCommonData(Model model, CitizenWorkDTO dto) {
        model.addAttribute("citizenWork", dto);
        model.addAttribute("services", serviceRegisterService.findAll());
        model.addAttribute("serviceNo", "1234");
        model.addAttribute("citizens", citizenDetailService.findAll());

    }


}
