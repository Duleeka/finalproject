package com.gn.app.controller.primaryTask.citizenWork;


import com.gn.app.dto.primaryTask.CitizenWork.CitizenWorkDTO;
import com.gn.app.service.primaryTask.CitizenWork.CitizenWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CitizenWorkController.REQUEST_MAPPING_URL)
public class CitizenWorkController {

    public static final String REQUEST_MAPPING_URL = "/citizenwork";

    @Autowired
    CitizenWorkService citizenWorkService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model) {
        return "primaryTask/citizenWork/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenWork (Model model){
        setCommonData(model, new CitizenWorkDTO());

        return "primaryTask/citizenWork/primary-task-citizen-services";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenWork(Model model, Integer sid){
        setCommonData(model, citizenWorkService.findById(sid));
        return "primaryTask/citizenWork/primary-task-citizen-services";

    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenWork(Model model, @ModelAttribute CitizenWorkDTO dto){
        citizenWorkService.create(dto);
        setCommonData(model,dto);
        return "primaryTask/citizenWork/primary-task-citizen-services";

    }


    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteCitizenWork(Model model, Integer sid){
        citizenWorkService.delete(sid);
        return "redirect/citizenwork/";
    }


    private void setCommonData(Model model, CitizenWorkDTO dto) {
        model.addAttribute("citizenWork",dto);    }



}
