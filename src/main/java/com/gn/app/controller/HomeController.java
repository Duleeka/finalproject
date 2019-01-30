package com.gn.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hp on 1/6/2019.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String homePage(Model model) {
      //model.addAttribute("person", new Person());
        return "dashboard/index";
    }


}
