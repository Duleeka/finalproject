package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum Gender {
    MALE(1,"male"),
    FEMALE(2,"female");

    private Integer genId;
    private String genName;

    Gender(Integer genId, String genName){
        setGenId(genId);
        setGenName(genName);
    }

    public static List<Gender> getAllGender(){
        List<Gender> genderList=new ArrayList<>();
        genderList.add(MALE);
        genderList.add(FEMALE);
        return genderList;
    }

    public Integer getGenId() {
        return genId;
    }

    public void setGenId(Integer genId) {
        this.genId = genId;
    }

    public String getGenName() {
        return genName;
    }

    public void setGenName(String genName) {
        this.genName = genName;
    }
}
