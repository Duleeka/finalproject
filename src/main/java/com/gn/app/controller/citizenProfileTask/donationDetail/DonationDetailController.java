package com.gn.app.controller.citizenProfileTask.donationDetail;


import com.gn.app.dto.citizenProfileTask.DonationDetail.DonationDetailDTO;
import com.gn.app.service.citizenProfileTask.CitizenDetail.CitizenDetailService;
import com.gn.app.service.citizenProfileTask.DonationDetail.DonationDetailService;
import com.gn.app.service.settings.DonationRegister.DonationRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(DonationDetailController.REQUEST_MAPPING_URL)
public class DonationDetailController {

    public static final String REQUEST_MAPPING_URL = "/donationdetail";

    @Autowired
    DonationDetailService donationDetailService;

    @Autowired
    DonationRegisterService donationRegisterService;

    @Autowired
    CitizenDetailService citizenDetailService;
   /* @Autowired
    GnDomainService gnDomainService;
*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "citizenProfileTask/donationDetail/home-view";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newDonationDetail(Model model){
        setCommonData(model, new DonationDetailDTO());
        return "citizenProfileTask/donationDetail/citizen-profile-task-donation-detail";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editDonationDetail(Model model, Integer id ) {
        setCommonData(model,donationDetailService.findById(id));
        return "citizenProfileTask/donationDetail/citizen-profile-task-donation-detail";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDonationDetail(Model model, @ModelAttribute DonationDetailDTO dto) {
        donationDetailService.create(dto);
        setCommonData(model,dto);

        return "citizenProfileTask/donationDetail/citizen-profile-task-donation-detail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDonationDetail(Model model, Integer id){
        donationDetailService.delete(id);
        return "redirect:/donationdetail/";
    }
    private void setCommonData(Model model, DonationDetailDTO dto) {

        model.addAttribute("donationDetail", dto);
        model.addAttribute("householders", citizenDetailService.findAll());
        model.addAttribute("donations", donationRegisterService.findAll());
    }
}
