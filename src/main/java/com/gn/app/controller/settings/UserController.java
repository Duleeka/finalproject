package com.gn.app.controller.settings;

import com.gn.app.constant.Roles;
import com.gn.app.controller.admnistrativeTask.gnProfile.GnProfileController;
import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.dto.settings.UserDTO;
import com.gn.app.service.AdministrativeTask.GnProfile.GnProfileService;
import com.gn.app.service.AdministrativeTask.GnProfile.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hp on 2/28/2019.
 */
@Controller
@RequestMapping(UserController.REQUEST_MAPPING_URL)
public class UserController {

    public static final String REQUEST_MAPPING_URL = "/user";

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {

        return "settings/user/home-view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newUser(Model model) {
        setCommonData(model,new UserDTO());
        return "settings/user/register";
    }
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(Model model, Integer id) {
        setCommonData(model,userService.findById(id));
        return "settings/user/register";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(Model model, @ModelAttribute UserDTO dto ) {
        userService.create(dto);
        setCommonData(model,dto);

        return "settings/user/register";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(Model model,Integer id ) {
        userService.delete(id);
        return "redirect:/user/";
    }

    private void setCommonData(Model model, UserDTO dto) {
        model.addAttribute("user",dto);
        model.addAttribute("roles", Roles.getAllUserRoles());
    }


}
