package com.gn.app.controller.Search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by hp on 1/6/2019.
 */
@Controller
@RequestMapping(SearchController.REQUEST_MAPPING_URL)
public class SearchController {

    public static final String REQUEST_MAPPING_URL = "/search";

    @RequestMapping(value = "/citizendetailage", method = RequestMethod.GET)
    public String homePage13(Model model) {
        return "search-citizen-detail-age";
    }

}
