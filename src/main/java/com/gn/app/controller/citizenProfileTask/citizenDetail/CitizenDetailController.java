package com.gn.app.controller.citizenProfileTask.citizenDetail;


import com.gn.app.constant.*;
import com.gn.app.dto.citizenProfileTask.CitizenDetail.CitizenDetailDTO;
import com.gn.app.model.Settings.GnDivisionRegister.GnDivisionRegister;
import com.gn.app.model.Settings.NationalityRegister.NationalityRegister;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.settings.EducationLevelRegister.EducationLevelRegisterService;
import com.gn.app.service.settings.GnDivisionRegister.GnDivisionRegisterService;
import com.gn.app.service.settings.NationalityRegister.NationalityRegisterService;
import com.gn.app.service.settings.ReligionRegister.ReligionRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CitizenDetailController.REQUEST_MAPPING_URL)
public class CitizenDetailController {

    public static final String REQUEST_MAPPING_URL = "/citizendetail";

    @Autowired
    CitizenDetailService citizenDetailService;

    @Autowired
    NationalityRegisterService nationalityRegisterService;

    @Autowired
    ReligionRegisterService religionRegisterService;

    @Autowired
    GnDivisionRegisterService gnDivisionRegisterService;

    @Autowired
    EducationLevelRegisterService educationLevelRegisterService;

   /* @Autowired
    GnDomainService gnDomainService;
*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "citizenProfileTask/CitizenDetail/home-view";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCitizenDetail(Model model){
        setCommonData(model, new CitizenDetailDTO());
        return "citizenProfileTask/CitizenDetail/citizen-profile-task-citizen-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCitizenDetail(Model model, Integer id ) {
        setCommonData(model,citizenDetailService.findById(id));
        return "citizenProfileTask/CitizenDetail/citizen-profile-task-citizen-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCitizenDetail(Model model, @ModelAttribute CitizenDetailDTO dto) {
        citizenDetailService.create(dto);
        setCommonData(model,dto);

        return "citizenProfileTask/CitizenDetail/citizen-profile-task-citizen-detail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCitizenDetail(Model model, Integer id){
        citizenDetailService.delete(id);
        return "redirect:/citizendetail/";
    }
private void setCommonData(Model model, CitizenDetailDTO dto) {
        model.addAttribute("citizenDetail",dto);
        model.addAttribute("provinces", Province.getAllProvince());
        model.addAttribute("maritalStatuses", MaritalStatus.getAllMaritalStatus());
        model.addAttribute("genders", Gender.getAllGender());
        model.addAttribute("districts", District.getALLDistrict());
        model.addAttribute("dsOffices", DsOffice.getALLDsOffice());
        model.addAttribute("relationships",Relationship.getALLRelationship());
        model.addAttribute("divisions", gnDivisionRegisterService.findAll());
        model.addAttribute("certificates",citizenDetailService.findAll());
        model.addAttribute("persons", nationalityRegisterService.findAll());
        model.addAttribute("religions",religionRegisterService.findAll());
        model.addAttribute("educationLevels",educationLevelRegisterService.findAll());

    }
}
