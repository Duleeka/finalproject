package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum DsOffice {
    COLOMBO_DIVISIONAL_SECRETARIAT(1,"colomboDivisionalSecretariat"),
    POOJAPITIYA_DIVISIONAL_SECRETARIAT(2,"poojapitiyaDivisionalSecretariat");

    private Integer dsOfficeId;
    private String dsOfficeName;

    DsOffice(Integer dsOfficeId, String dsOfficeName){
        setDsOfficeId(dsOfficeId);
        setDsOfficeName(dsOfficeName);
    }

    public static List<DsOffice> getALLDsOffice(){
        List<DsOffice> dsOfficeList =new ArrayList<>();
        dsOfficeList.add(COLOMBO_DIVISIONAL_SECRETARIAT);
        dsOfficeList.add(POOJAPITIYA_DIVISIONAL_SECRETARIAT);
        return dsOfficeList;
    }

    public Integer getDsOfficeId() {
        return dsOfficeId;
    }

    public void setDsOfficeId(Integer dsOfficeId) {
        this.dsOfficeId = dsOfficeId;
    }

    public String getDsOfficeName() {
        return dsOfficeName;
    }

    public void setDsOfficeName(String dsOfficeName) {
        this.dsOfficeName = dsOfficeName;
    }
}
