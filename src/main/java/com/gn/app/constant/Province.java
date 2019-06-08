package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum Province {

    CENTRAL(1,"central"),
    EASTERN(2,"eastern"),
    NORTHERN(3,"northern"),
    NORTHCENTRAL(4,"northcentral"),
    NORTHWESTERN(5,"northwestern"),
    SABARAGAMUWA(6,"sabaragamuwa"),
    SOUTHERN(7,"southern"),
    UVA(8,"uva"),
    WESTERN(9,"western");

    private Integer id;
    private String name;

    Province(Integer id , String name){
        setId(id);
        setName(name);
    }

    public static List<Province> getAllProvince(){
        List<Province> provinceList=new ArrayList<>();
        provinceList.add(CENTRAL);
        provinceList.add(EASTERN);
        provinceList.add(NORTHERN);
        provinceList.add(NORTHCENTRAL);
        provinceList.add(NORTHWESTERN);
        provinceList.add(SABARAGAMUWA);
        provinceList.add(SOUTHERN);
        provinceList.add(UVA);
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
