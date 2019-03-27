package com.gn.app.mappers.administrativeTask.DiaryLog;

import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.mappers.GenericMapper;
import com.gn.app.model.administrativeTask.DiaryLog.DiaryLog;

import java.text.SimpleDateFormat;


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
        dto.setId(diaryLog.getId());
        dto.setVersion(diaryLog.getVersion());
        dto.setTaskName(diaryLog.getTaskName());
        dto.setDescription(diaryLog.getDescription());
        dto.setStatus(diaryLog.getStatus());
        if (diaryLog.getStartDate()!=null) {
            dto.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(diaryLog.getStartDate()));
        }
        if (diaryLog.getFinishDate()!=null) {
            dto.setFinishDate(new SimpleDateFormat("yyyy-MM-dd").format(diaryLog.getFinishDate()));
        }
        return dto;
    }

    @Override
    public DiaryLogDTO domainToDtoForDataTable(DiaryLog diaryLog) throws Exception {
        DiaryLogDTO dto=new DiaryLogDTO();
        dto.setId(diaryLog.getId());
        dto.setTaskName(diaryLog.getTaskName());
        dto.setStatus(diaryLog.getStatus());
        if (diaryLog.getStartDate()!=null) {
            dto.setStartDate(new SimpleDateFormat("yyyy-MM-dd").format(diaryLog.getStartDate()));
        }
        if (diaryLog.getFinishDate()!=null) {
            dto.setFinishDate(new SimpleDateFormat("yyyy-MM-dd").format(diaryLog.getFinishDate()));
        }
        return dto;
    }

    @Override
    public void dtoToDomain(DiaryLogDTO dto, DiaryLog diaryLog) throws Exception {
        diaryLog.setId(dto.getId());
        diaryLog.setVersion(dto.getVersion());
        diaryLog.setTaskName(dto.getTaskName());
        diaryLog.setDescription(dto.getDescription());
        diaryLog.setStatus(dto.getStatus());
        diaryLog.setStartDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getStartDate()));

        diaryLog.setFinishDate(new SimpleDateFormat("yyyy-MM-dd").parse(dto.getFinishDate()));

    }
}

