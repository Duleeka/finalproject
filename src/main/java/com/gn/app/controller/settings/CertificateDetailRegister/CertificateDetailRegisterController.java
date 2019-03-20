package com.gn.app.controller.settings.CertificateDetailRegister;

import com.gn.app.dto.primaryTask.CertificateDetail.CertificateDetailDTO;
import com.gn.app.dto.settings.CertificateDetailRegister.CertificateDetailRegisterDTO;
import com.gn.app.service.settings.CertificateDetailRegister.CertificateDetailRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(CertificateDetailRegisterController.REQUEST_MAPPING_URL)
public class CertificateDetailRegisterController {
    public static final String REQUEST_MAPPING_URL ="/certificatedetailregister";

    @Autowired
    CertificateDetailRegisterService certificateDetailRegisterService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "settings/certificateDetailRegister/home-view";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newCertificateDetailRegister(Model model){
        setCommonData(model, new CertificateDetailRegisterDTO() );
        return "settings/certificateDetailRegister/settings-certificate-detail-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editCertificateDetailRegister(Model model, Integer id){
        setCommonData(model,certificateDetailRegisterService.findById(id));
        return "settings/certificateDetailRegister/settings-certificate-detail-register";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveCertificateDetailRegister(Model model, @ModelAttribute CertificateDetailRegisterDTO dto) {
        certificateDetailRegisterService.create(dto);
        setCommonData(model,dto);

        return "settings/certificateDetailRegister/settings-certificate-detail-register";

    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCertificateDetailRegister(Model model, Integer id){
        certificateDetailRegisterService.delete(id);
        return "redirect:/certificatedetailregister/";
    }
    private void setCommonData(Model model, CertificateDetailRegisterDTO dto)
    {
        model.addAttribute("certificateDetailRegister",dto);
    }

}
