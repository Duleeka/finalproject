package com.gn.app.controller.settings;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.dto.settings.UserDTO;
import com.gn.app.service.AdministrativeTask.GnProfile.GnProfileService;
import com.gn.app.service.AdministrativeTask.GnProfile.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hp on 1/6/2019.
 */
@RestController
@RequestMapping(UserRestController.REQUEST_MAPPING_URL)
public class UserRestController {

    public static final String REQUEST_MAPPING_URL = "/restapi/user";

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<UserDTO> homePage(DataTablesInput input) {
        return userService.findAllDataTable(input);
    }

}
