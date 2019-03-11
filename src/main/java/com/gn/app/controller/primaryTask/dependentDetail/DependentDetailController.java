package com.gn.app.controller.primaryTask.dependentDetail;


import com.gn.app.dto.primaryTask.DependentDetail.DependentDetailDTO;
import com.gn.app.service.primaryTask.DependentDetail.DependentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(DependentDetailController.REQUEST_MAPPING_URL)

public class DependentDetailController {

    public static final String REQUEST_MAPPING_URL = "/hhdependentdetail";

    @Autowired
    DependentDetailService dependentDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "primaryTask/dependentDetail/home-view"; }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newDependentDetail(Model model) {
        setCommonData(model,new DependentDetailDTO());
        return "primaryTask/dependentDetail/primary-task-hh-dependent-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editDependentDetail(Model model, Integer deid){
        setCommonData(model, dependentDetailService.findById(deid));
        return "primaryTask/dependentDetail/primary-task-hh-dependent-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDependentDetail(Model model, @ModelAttribute DependentDetailDTO dto) {
        dependentDetailService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/dependentDetail/primary-task-hh-dependent-detail";    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDependentDetail(Model model, Integer deid){
        dependentDetailService.delete(deid);
        return "redirect:/hhdependentdetail/";
    }

    private void setCommonData(Model model, DependentDetailDTO dto) {
        model.addAttribute("dependentDetail",dto);
    }

}
