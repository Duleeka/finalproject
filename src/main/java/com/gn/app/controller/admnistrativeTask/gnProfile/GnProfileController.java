package com.gn.app.controller.admnistrativeTask.gnProfile;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.service.AdministrativeTask.GnProfile.GnProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 1/6/2019.
 */
@Controller
@RequestMapping(GnProfileController.REQUEST_MAPPING_URL)
public class GnProfileController {

    public static final String REQUEST_MAPPING_URL = "/basicgnprofile";

    @Autowired
    GnProfileService gnProfileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "administrativeTask/gnProfile/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newGnProfile(Model model) {
        setCommonData(model,new GnProfileDTO());
        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGnProfile(Model model, Integer id) {
        setCommonData(model,gnProfileService.findById(id));
        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGnProfile(Model model, @ModelAttribute GnProfileDTO dto ) {
        gnProfileService.create(dto);
        setCommonData(model,dto);

        return "administrativeTask/gnProfile/administrative-task-basic-gn-profile";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGnProfile(Model model,Integer id ) {
        gnProfileService.delete(id);
        return "redirect:/basicgnprofile/";
    }


    @RequestMapping(value = "/print", method = RequestMethod.GET)
    public void print(HttpServletRequest request, HttpServletResponse response, String type) throws Exception {
        gnProfileService.print(response, request, type);
    }


    private void setCommonData(Model model, GnProfileDTO dto)
    {
        model.addAttribute("gnProfile",dto);
    }
}
