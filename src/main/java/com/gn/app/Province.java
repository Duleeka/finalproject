package com.gn.app;

import java.util.ArrayList;
import java.util.List;

public enum Province {

    CENTRAL(1,"central"),
    WESTERN(2,"western");

    private Integer id;
    private String name;

    Province(Integer id , String name){
        setId(id);
        setName(name);
    }

    public static List<Province> getAllProvince(){
        List<Province> provinceList=new ArrayList<>();
        provinceList.add(CENTRAL);
        provinceList.add(WESTERN);
        return  provinceList;
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
}
