package com.gn.app.dao.administrativeTask.DiaryLog;

import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;

import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;


/**
 * Created by hp on 1/7/2019.
 */
@Repository
public interface DiaryLogDao extends DataTablesRepository<DiaryLog, Integer> {

}
