package com.gn.app.constant;

import java.util.ArrayList;
import java.util.List;

public enum StateOfTasks {

    TASK_FINISHED(1,"Task Finished"),
    TASK_PENDING(2,"Task Pending");

    private Integer stateId;
    private String stateName;

    StateOfTasks(Integer stateId, String stateName){
        setStateId(stateId);
        setStateName(stateName);
    }

    public static List<StateOfTasks> getAllStateOfTasks(){
        List<StateOfTasks> stateOfTasksList=new ArrayList<>();
        stateOfTasksList.add(TASK_FINISHED);
        stateOfTasksList.add(TASK_PENDING);
        return stateOfTasksList;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
}
