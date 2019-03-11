package com.gn.app.service.AdministrativeTask.GnProfile;

import com.gn.app.dto.administrativeTask.GnProfile.GnProfileDTO;
import com.gn.app.dto.settings.UserDTO;
import com.gn.app.model.Settings.User;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.Collection;
import java.util.List;

/**
 * Created by hp on 1/7/2019.
 */
public interface UserService {

    User save(User user);

    Boolean delete(int id);

    User update(User user);

    User findById(int id);

    User findByUserName(String username);

    User findByEmail(String email);


    DataTablesOutput<UserDTO> findAllDataTable(DataTablesInput input);

    List<UserDTO> findAll();

    UserDTO create(UserDTO gnProfile);

    UserDTO findById(Integer id);

    void delete(Integer id);



}
