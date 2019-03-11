package com.gn.app.controller.primaryTask.citizenDetail;


import com.gn.app.Province;
import com.gn.app.dto.primaryTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.service.AdministrativeTask.GnDomain.GnDomainService;
import com.gn.app.service.primaryTask.CitizenDetail.CitizenDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Controller
@RequestMapping(CitizenDetailController.REQUEST_MAPPING_URL)
public class CitizenDetailController {

    public static final String REQUEST_MAPPING_URL = "/basiccitizendetail";

    @Autowired
    CitizenDetailService citizenDetailService;

    @Autowired
    GnDomainService gnDomainService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "primaryTask/basicCitizenDetail/home-view";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenDetail(Model model){
        setCommonData(model, new CitizenDetailDTO());
        return "primaryTask/basicCitizenDetail/primary-task-basic-citizen-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenDetail(Model model, Integer id ) {
        setCommonData(model,citizenDetailService.findById(id));
        return "primaryTask/basicCitizenDetail/primary-task-basic-citizen-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenDetail(Model model, @ModelAttribute CitizenDetailDTO dto) {
        citizenDetailService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/basicCitizenDetail/primary-task-basic-citizen-detail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenDetail(Model model, Integer id){
        citizenDetailService.delete(id);
        return "redirect:/basiccitizendetail/";
    }
private void setCommonData(Model model, CitizenDetailDTO dto) {
        model.addAttribute("citizenDetail",dto);
        model.addAttribute("provinces", Province.getAllProvince());
        model.addAttribute("domains", citizenDetailService.findAll());
    }
}
