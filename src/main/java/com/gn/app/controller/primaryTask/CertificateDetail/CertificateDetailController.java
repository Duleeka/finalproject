package com.gn.app.controller.primaryTask.CertificateDetail;


import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.primaryTask.CertificateDetail.CertificateDetailService;
import com.gn.app.service.settings.CertificateDetailRegister.CertificateDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(CertificateDetailController.REQUEST_MAPPING_URL)
public class CertificateDetailController {
    public static final String REQUEST_MAPPING_URL = "/certificatedetail";

    @Autowired
    CitizenDetailService citizenDetailService;

    @Autowired
    CertificateDetailService certificateDetailService;

    @Autowired
    CertificateDetailRegisterService certificateDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "primaryTask/certificateDetail/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newBasicDetail(Model model){
        setCommonData(model, new CertificateDetailDTO() );
        return "primaryTask/certificateDetail/certificate-issuing-task-basic-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editBasicDetail(Model model, Integer id){
        setCommonData(model,certificateDetailService.findById(id));
        return "primaryTask/certificateDetail/certificate-issuing-task-basic-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveBasicDetail(Model model, @ModelAttribute CertificateDetailDTO dto) {
        certificateDetailService.create(dto);
        setCommonData(model,dto);

        return "primaryTask/certificateDetail/certificate-issuing-task-basic-detail";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteBasicDetail(Model model, Integer id){
        certificateDetailService.delete(id);
        return "redirect:/certificatedetail/";
    }
    private void setCommonData(Model model, CertificateDetailDTO dto)
    {
        model.addAttribute("certificateDetail",dto);
        model.addAttribute("certificates", certificateDetailRegisterService.findAll());
        model.addAttribute("citizens",citizenDetailService.findAll());

    }

}


