package com.gn.app.dao.settings;

import com.gn.app.model.Settings.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;

/**
 * Created by hp on 2/12/2019.
 */

public interface UserDao extends DataTablesRepository<User,Integer>{

    User findByUsername(String username);

    User findByEmail(String email);
}

