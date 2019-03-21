package com.gn.app.model.administrativeTask.DiaryLog;

import com.gn.app.model.BaseModel;

import javax.persistence.*;
import java.util.Date;


@Entity
   @Table(name = "tbl_gn_diary")
    public class DiaryLog extends BaseModel{
       private static final long serialVersionUID = 3466843752790052309L;

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)


       @Column(name = "task_id")
       private Integer taskId;

       @Column(name = "task_name")
       private String taskName;

       @Column(name = "description")
       private String description;

       @Column(name = "status")
       private String status;

       @Column(name = "start_date")
       @Temporal(TemporalType.DATE)
       private Date startDate;

       @Column(name = "finish_date")
       @Temporal(TemporalType.DATE)
       private Date finishDate;


       public Integer getTaskId() { return taskId;}

       public void setTaskId(Integer taskId) { this.taskId=taskId;}

       public String getTaskName() { return taskName;}

       public void setTaskName(String taskName) {this.taskName= taskName;}

       public String getDescription() { return description;}

       public void setDescription(String description) {this.description= description;}

       public String getStatus() { return status;}

       public void setStatus(String status) { this.status= status;}

       public Date getStartDate() { return startDate;}

       public void setStartDate(Date startDate) {this.startDate= startDate;}

       public Date getFinishDate() { return finishDate;}

       public void setFinishDate(Date finishDate) {this.finishDate= finishDate;}
   }


