package com.gn.app.dto.administrativeTask.DiaryLog;

import com.gn.app.dto.BaseDTO;

import java.util.Date;

/**
 * Created by hp on 1/31/2019.
 */

public class DiaryLogDTO extends BaseDTO {

    private Integer taskId;
    private String taskName;
    private String description;
    private String status;
    private Date startDate;
    private Date finishDate;

    public Integer getTaskId() { return taskId;}

    public void  setTaskId(Integer taskId) { this.taskId= taskId;}

    public String getTaskName() { return taskName;}

    public void setTaskName(String taskName) { this.taskName= taskName;}

    public String getDescription() { return description;}

    public void setDescription( String description)  { this.description= description;}

    public String getStatus() { return status;}

    public void setStatus(String status) { this.status= status;}

    public Date getStartDate() { return startDate;}

    public void setStartDate(Date startDate) { this.startDate= startDate;}

    public Date getFinishDate() { return finishDate;}

    public void  setFinishDate(Date finishDate) { this.finishDate= finishDate;}

}
