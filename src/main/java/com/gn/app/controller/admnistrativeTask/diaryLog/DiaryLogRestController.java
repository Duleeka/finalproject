package com.gn.app.controller.admnistrativeTask.diaryLog;


import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.service.AdministrativeTask.DiaryLog.DiaryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(DiaryLogRestController.REQUEST_MAPPING_URL)
public class DiaryLogRestController {
    public static final String REQUEST_MAPPING_URL="/restapi/diarylog";

    @Autowired
    DiaryLogService diaryLogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public DataTablesOutput<DiaryLogDTO> homepage (DataTablesInput input){
        return diaryLogService.findAllDataTable(input);
    }
}
