package com.gn.app.controller.primaryTask.CertificateDetail;


import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.primaryTask.CertificateDetail.CertificateDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CertificateDetailController.REQUEST_MAPPING_URL)
public class CertificateDetailController {
    public static final String REQUEST_MAPPING_URL = "/basicdetail";

    @Autowired
    CertificateDetailService certificateDetailService;

    @Autowired
    CitizenDetailService citizenDetailService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "primaryTask/basicDetail/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newBasicDetail(Model model){
        setCommonData(model, new CertificateDetailDTO() );
        return "primaryTask/basicDetail/certificate-issuing-task-basic-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBasicDetail(Model model, Integer id){
        setCommonData(model,certificateDetailService.findById(id));
        return "primaryTask/basicDetail/certificate-issuing-task-basic-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBasicDetail(Model model, @ModelAttribute CertificateDetailDTO dto) {
        certificateDetailService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/basicDetail/certificate-issuing-task-basic-detail";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBasicDetail(Model model, Integer id){
        certificateDetailService.delete(id);
        return "redirect:/basicdetail/";
    }
    private void setCommonData(Model model, CertificateDetailDTO dto)
    {
        model.addAttribute("basicDetail",dto);
        model.addAttribute("certificates", certificateDetailService.findAll());
        model.addAttribute("citizens",citizenDetailService.findAll());

    }

}


