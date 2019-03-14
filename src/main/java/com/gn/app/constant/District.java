package com.gn.app.constant;

import java.util.*;

public enum District {
    KANDY(1,"kandy"),
    COLOMBO(2,"colombo");

    private Integer distId;
    private String distName;

    District(Integer distId, String distName){
        setDistId(distId);
        setDistName(distName);
    }

    public static List<District> getALLDistrict(){
        List<District> districtList = new ArrayList<>();
        districtList.add(KANDY);
        districtList.add(COLOMBO);
        return districtList;
    }

    public Integer getDistId() {
        return distId;
    }

    public void setDistId(Integer distId) {
        this.distId = distId;
    }

    public String getDistName() {
        return distName;
    }

    public void setDistName(String distName) {
        this.distName = distName;
    }
}
