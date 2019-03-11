package com.gn.app.service.AdministrativeTask.DiaryLog;

import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import java.util.List;

/**
 * Created by hp on 1/7/2019.
 */
public interface DiaryLogService {


    DataTablesOutput<DiaryLogDTO> findAllDataTable(DataTablesInput input);

    List<DiaryLogDTO> findAll();

    DiaryLogDTO create(DiaryLogDTO diaryLog);

    DiaryLogDTO findById(Integer taskid);

    void delete(Integer taskid);




}
