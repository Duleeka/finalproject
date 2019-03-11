package com.gn.app.controller.admnistrativeTask.gnProfile;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.service.AdministrativeTask.GnProfile.GnProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
/*import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;*/
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by hp on 1/6/2019.
 */
@RestController
@RequestMapping(GnProfileRestController.REQUEST_MAPPING_URL)
public class GnProfileRestController {

    public static final String REQUEST_MAPPING_URL = "/restapi/basicgnprofile";

    @Autowired
    GnProfileService gnProfileService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<GnProfileDTO> homePage(DataTablesInput input) {
        return gnProfileService.findAllDataTable(input);
    }

}
