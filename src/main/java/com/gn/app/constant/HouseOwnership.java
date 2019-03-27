package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum HouseOwnership {
    GOVERNMENT_OWNED_RENTED(1,"government owned rented"),
    PRIVATE_OWNED_RENTED(2,"private owned rented"),
    PRIVATE_LEASED(3,"private leased"),
    UNAUTHORIZED(4,"unauthorized"),
    FREE_FROM_RENT(5,"free from rent"),
    FREE_HOLD(6,"free hold"),
    OTHER(7,"other");

    private Integer houseOwnershipId;
    private String houseOwnershipName;

    HouseOwnership(Integer houseOwnershipId, String houseOwnershipName){
        setHouseOwnershipId(houseOwnershipId);
        setHouseOwnershipName(houseOwnershipName);
    }

    public static List<HouseOwnership> getALLHouseOwnership(){
        List<HouseOwnership> houseOwnershipList =new ArrayList<>();
        houseOwnershipList.add(GOVERNMENT_OWNED_RENTED);
        houseOwnershipList.add(PRIVATE_OWNED_RENTED);
        houseOwnershipList.add(PRIVATE_LEASED);
        houseOwnershipList.add(UNAUTHORIZED);
        houseOwnershipList.add(FREE_FROM_RENT);
        houseOwnershipList.add(FREE_HOLD);
        houseOwnershipList.add(OTHER);



        return houseOwnershipList;
    }

    public Integer getHouseOwnershipId() {
        return houseOwnershipId;
    }

    public void setHouseOwnershipId(Integer houseOwnershipId) {
        this.houseOwnershipId = houseOwnershipId;
    }

    public String getHouseOwnershipName() {
        return houseOwnershipName;
    }

    public void setHouseOwnershipName(String houseOwnershipName) {
        this.houseOwnershipName = houseOwnershipName;
    }
}
