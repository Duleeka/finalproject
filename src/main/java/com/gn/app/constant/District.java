package com.gn.app.constant;

import java.util.*;

public enum District {
    AMPARA(1,"ampara"),
    ANURADHAPURA(2,"anuradhapura"),
    BADULLA(3,"badulla"),
    BATTICALOA(4,"batticaloa"),
    COLOMBO(5,"colombo"),
    GALLE(6,"galle"),
    GAMPAHA(7,"gampaha"),
    HAMBANTOTA(8,"hambantota"),
    JAFFNA(9,"jaffna"),
    KALUTARA(10,"kalutara"),
    KANDY(11,"kandy"),
    KEGALLE(12,"kegalle"),
    KILINOCHCHI(13,"kilinochchi"),
    KURUNEGALA(14,"kurunegala"),
    MANNAR(15,"mannar"),
    MATALE(16,"matale"),
    MATARA(17,"matara"),
    MONARAGALA(18,"monaragala"),
    MULLAITIVU(19,"mullaitivu"),
    NUWARAELIYA(20,"nuwaraeliya"),
    POLONNARUWA(21,"polnnaruwa"),
    PUTTALAM(22,"puttalam"),
    RATNAPURA(23,"ratnapura"),
    TRINCOMALEE(24,"trincomalee"),
    VAVUNIYA(25,"vavuniya");

    private Integer distId;
    private String distName;

    District(Integer distId, String distName){
        setDistId(distId);
        setDistName(distName);
    }

    public static List<District> getALLDistrict(){
        List<District> districtList = new ArrayList<>();
        districtList.add(AMPARA);
        districtList.add(ANURADHAPURA);
        districtList.add(BADULLA);
        districtList.add(BATTICALOA);
        districtList.add(COLOMBO);
        districtList.add(GALLE);
        districtList.add(GAMPAHA);
        districtList.add(HAMBANTOTA);
        districtList.add(JAFFNA);
        districtList.add(KALUTARA);
        districtList.add(KANDY);
        districtList.add(KEGALLE);
        districtList.add(KILINOCHCHI);
        districtList.add(KURUNEGALA);
        districtList.add(MANNAR);
        districtList.add(MATALE);
        districtList.add(MATARA);
        districtList.add(MONARAGALA);
        districtList.add(MULLAITIVU);
        districtList.add(NUWARAELIYA);
        districtList.add(POLONNARUWA);
        districtList.add(PUTTALAM);
        districtList.add(RATNAPURA);
        districtList.add(TRINCOMALEE);
        districtList.add(VAVUNIYA);




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
