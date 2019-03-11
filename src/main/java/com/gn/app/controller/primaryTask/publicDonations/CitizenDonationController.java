package com.gn.app.controller.primaryTask.publicDonations;

import com.gn.app.dto.primaryTask.CitizenDonation.CitizenDonationDTO;
import com.gn.app.service.primaryTask.CitizenDonation.CitizenDonationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CitizenDonationController.REQUEST_MAPPING_URL)
public class CitizenDonationController {
    public static final String REQUEST_MAPPING_URL = "/citizenpublicdonations";

    @Autowired
    CitizenDonationService citizenDonationService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homepage(Model model)
    {
        return "primaryTask/publicDonations/home-view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenDonation(Model model){
        setCommonData(model, new CitizenDonationDTO() );
        return "primaryTask/publicDonations/primary-task-citizen-public-donations";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenDonation(Model model, Integer id){
        setCommonData(model,citizenDonationService.findById(id));
        return "primaryTask/publicDonations/primary-task-citizen-public-donations";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenDonation(Model model, @ModelAttribute CitizenDonationDTO dto) {
        citizenDonationService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/publicDonations/primary-task-citizen-public-donations";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenDonation(Model model, Integer id){
        citizenDonationService.delete(id);
        return "redirect:/citizenpublicdonations/";
    }
    private void setCommonData(Model model, CitizenDonationDTO dto)
    {
        model.addAttribute("publicDonations",dto);
    }


}
