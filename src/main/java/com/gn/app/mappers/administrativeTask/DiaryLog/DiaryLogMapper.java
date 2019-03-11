package com.gn.app.mappers.administrativeTask.DiaryLog;

import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;


/**
 * Created by hp on 1/31/2019.
 */
public class DiaryLogMapper extends GenericMapper<DiaryLog,DiaryLogDTO> {

    private static DiaryLogMapper instance = null;


    public static DiaryLogMapper getInstance() {
        if (instance == null) {
            instance = new DiaryLogMapper();
        }
        return instance;
    }

    @Override
    public DiaryLogDTO domainToDto (DiaryLog diaryLog) throws Exception{
        DiaryLogDTO dto=new DiaryLogDTO();
        dto.setTaskId(diaryLog.getTaskId());
        dto.setVersion(diaryLog.getVersion());
        dto.setTaskName(diaryLog.getTaskName());
        dto.setDescription(diaryLog.getDescription());
        dto.setStatus(diaryLog.getStatus());
        dto.setStartDate(diaryLog.getStartDate());
        dto.setFinishDate(diaryLog.getFinishDate());
        return dto;
    }

    @Override
    public DiaryLogDTO domainToDtoForDataTable(DiaryLog diaryLog) throws Exception {
        DiaryLogDTO dto=new DiaryLogDTO();
        dto.setTaskName(diaryLog.getTaskName());
        dto.setStatus(diaryLog.getStatus());
        dto.setStartDate(diaryLog.getStartDate());
        dto.setFinishDate(diaryLog.getFinishDate());
        return dto;
    }

    @Override
    public void dtoToDomain(DiaryLogDTO dto, DiaryLog diaryLog) throws Exception {
        diaryLog.setTaskId(dto.getTaskId());
        diaryLog.setVersion(dto.getVersion());
        diaryLog.setTaskName(dto.getTaskName());
        diaryLog.setDescription(dto.getDescription());
        diaryLog.setStatus(dto.getStatus());
        diaryLog.setStartDate(dto.getStartDate());
        diaryLog.setFinishDate(dto.getFinishDate());
    }
}

