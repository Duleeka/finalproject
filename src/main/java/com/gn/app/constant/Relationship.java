package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum Relationship {
    HOUSEHOLDER(0,"householder"),
    HUSBAND(1,"husband"),
    WIFE(2,"wife"),
    FATHER(3,"father"),
    MOTHER(4,"mother"),
    GRANDMOTHER(5,"grandmother"),
    GRANDFATHER(6,"grandfather"),
    DAUGHTER(7,"daughter"),
    SON(8,"son"),
    GRANDSON(9,"grandson"),
    GRANDDAUGHTER(10,"granddaughter"),
    AUNTY(11,"aunty"),
    UNCLE(12,"uncle"),
    SON_IN_LAW(13,"sonInLaw"),
    SISTER_IN_LAW(14, "sisterInLaw"),
    FATHER_IN_LAW(15, "fatherInLaw"),
    MOTHER_IN_LAW(16, "motherInLaw"),
    STEPMOTHER(17, "stepmother"),
    BROTHER(18, "brother"),
    SISTER(19,"sister");

    private Integer relId;
    private String relType;

    Relationship(Integer relId, String relType){
        setRelId(relId);
        setRelType(relType);
    }

    public static List<Relationship> getALLRelationship() {
        List<Relationship> relationshipList = new ArrayList<>();
        relationshipList.add(HOUSEHOLDER);
        relationshipList.add(HUSBAND);
        relationshipList.add(WIFE);
        relationshipList.add(FATHER);
        relationshipList.add(MOTHER);
        relationshipList.add(GRANDMOTHER);
        relationshipList.add(GRANDFATHER);
        relationshipList.add(DAUGHTER);
        relationshipList.add(SON);
        relationshipList.add(DAUGHTER);
        relationshipList.add(GRANDSON);
        relationshipList.add(GRANDSON);
        relationshipList.add(AUNTY);
        relationshipList.add(UNCLE);
        relationshipList.add(SISTER_IN_LAW);
        relationshipList.add(SON_IN_LAW);
        relationshipList.add(FATHER_IN_LAW);
        relationshipList.add(MOTHER_IN_LAW);
        relationshipList.add(STEPMOTHER);
        relationshipList.add(BROTHER);
        relationshipList.add(SISTER);
        return relationshipList;
    }

    public Integer getRelId() {
        return relId;
    }

    public void setRelId(Integer relId) {this.relId = relId;}

    public String getRelType() { return relType; }

    public void setRelType(String relType) { this.relType = relType; }


    }

