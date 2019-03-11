package com.gn.app.controller;

import com.gn.app.model.Settings.User;
import com.gn.app.service.AdministrativeTask.GnProfile.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hp on 1/6/2019.
 */
@Controller
@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class HomeController {


    @Autowired
    private UserService userService;



    private User loginUser;

    public User getLoginUser() {
        if (loginUser == null) {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            loginUser = userService.findByUserName(auth.getName());
        }
        return loginUser;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
      //model.addAttribute("user", loginUser.getUsername());
        return "dashboard/index";


    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login";
    }


}
