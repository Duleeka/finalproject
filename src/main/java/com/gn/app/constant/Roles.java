package com.gn.app.constant;

import com.gn.app.model.Settings.User;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by hp on 2/12/2019.
 */

public enum Roles {


    ROLE_ADMIN(1,"Admin"),
    ROLE_USER(2,"User");

    private Integer id;
    private String name;

    Roles(Integer id,String name) {
        this.id=id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Roles> getAllUserRoles(){
        List<Roles> roles=new ArrayList<>();
        roles.add(ROLE_ADMIN);
        roles.add(ROLE_USER);
        return roles;
    }
}
