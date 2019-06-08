package com.gn.app.controller.admnistrativeTask.diaryLog;

import com.gn.app.constant.StateOfTasks;
import com.gn.app.dto.administrativeTask.DiaryLog.DiaryLogDTO;
import com.gn.app.service.AdministrativeTask.DiaryLog.DiaryLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(DiaryLogController.REQUEST_MAPPING_URL)
public class DiaryLogController {
    public static final String REQUEST_MAPPING_URL = "/diarylog";

    @Autowired
    DiaryLogService diaryLogService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "administrativeTask/diaryLog/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newDiaryLog(Model model) {
        setCommonData(model, new DiaryLogDTO());
        return "administrativeTask/diaryLog/administrative-task-diary-log";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editDiaryLog(Model model, Integer id) {
        setCommonData(model, diaryLogService.findById(id));
        return "administrativeTask/diaryLog/administrative-task-diary-log";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDiaryLog(Model model, @ModelAttribute DiaryLogDTO dto) {
        diaryLogService.create(dto);
        setCommonData(model, dto);

        return "administrativeTask/diaryLog/administrative-task-diary-log";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDiaryLog(Model model, Integer id) {
        diaryLogService.delete(id);
        return "redirect:/diarylog/";
    }

    private void setCommonData(Model model, DiaryLogDTO dto)
    {
        model.addAttribute("diaryLog", dto);
        model.addAttribute("states" , StateOfTasks.getAllStateOfTasks());
    }
}
