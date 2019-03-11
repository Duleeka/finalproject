package com.gn.app.controller.certificateIssuingTask.CertificateDetail;


import com.gn.app.dto.certificateIssuingTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.service.certificateIssuingTask.CertificateDetail.CertificateDetailService;
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

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "certificateIssuingTask/basicDetail/home-view";
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCertificateDetail(Model model){
        setCommonData(model, new CertificateDetailDTO() );
        return "certificateIssuingTask/basicDetail/certificate-issuing-task-basic-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCertificateDetail(Model model, Integer id){
        setCommonData(model,certificateDetailService.findById(id));
        return "certificateIssuingTask/basicDetail/certificate-issuing-task-basic-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCertificateDetail(Model model, @ModelAttribute CertificateDetailDTO dto) {
        certificateDetailService.create(dto);
        setCommonData(model,dto);

        return "certificateIssuingTask/basicDetail/certificate-issuing-task-basic-detail";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCertificateDetail(Model model, Integer id){
        certificateDetailService.delete(id);
        return "redirect:/basicdetail/";
    }
    private void setCommonData(Model model, CertificateDetailDTO dto)
    {
        model.addAttribute("basicDetail",dto);
    }
}


