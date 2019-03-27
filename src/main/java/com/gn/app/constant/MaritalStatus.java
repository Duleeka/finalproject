package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum MaritalStatus {

    NEVER_MARRIED(1,"never Married"),
    REGISTERED_MARRIED(2,"registered Married"),
    MARRIED_NOT_REGISTERED (3,"married Not Registered"),
    WIDOW(4,"widow"),
    DIVORCE(5,"divorce"),
    OTHER(6,"other");

    private Integer id;
    private String name;

    MaritalStatus(Integer id, String name){
        setId(id);
        setName(name);
    }


    public static List<MaritalStatus> getAllMaritalStatus(){
        List<MaritalStatus> maritalStatusList = new ArrayList<>();
        maritalStatusList.add(NEVER_MARRIED);
        maritalStatusList.add(REGISTERED_MARRIED);
        maritalStatusList.add(MARRIED_NOT_REGISTERED);
        maritalStatusList.add(WIDOW);
        maritalStatusList.add(DIVORCE);
        maritalStatusList.add(OTHER);
        return maritalStatusList;

    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
