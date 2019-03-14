package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum Relationship {
    HOUSEHOLDER(1,"householder"),
    HUSBAND(2,"husband"),
    WIFE(3,"wife"),
    FATHER(4,"father"),
    MOTHER(5,"mother"),
    GRANDMOTHER(6,"grandmother"),
    GRANDFATHER(7,"grandfather"),
    DAUGHTER(8,"daughter"),
    SON(9,"son"),
    GRANDSON(10,"grandson"),
    GRANDDAUGHTER(11,"granddaughter"),
    AUNT(12,"aunt"),
    UNCLE(13,"uncle"),
    SON_IN_LAW(14,"sonInLaw"),
    SISTER_IN_LAW(15, "sisterInLaw"),
    FATHER_IN_LAW(16, "fatherInLaw"),
    MOTHER_IN_LAW(17, "motherInLaw"),
    STEPMOTHER(18, "stepmother"),
    BROTHER(19, "brother"),
    SISTER(20,"sister");

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
        relationshipList.add(AUNT);
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

