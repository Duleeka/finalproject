package com.gn.app.controller.settings.DonationRegister;


import com.gn.app.dto.settings.DonationRegister.DonationRegisterDTO;
import com.gn.app.service.settings.DonationRegister.DonationRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(DonationRegisterController.REQUEST_MAPPING_URL)
public class DonationRegisterController {

    public static final String REQUEST_MAPPING_URL = "/donationregister";

    @Autowired
    DonationRegisterService donationRegisterService;

   /* @Autowired
    GnDomainService gnDomainService;
*/

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) { return "settings/donationRegister/home-view";}

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newDonationRegister(Model model){
        setCommonData(model, new DonationRegisterDTO());
        return "settings/donationRegister/settings-donation-register";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editDonationRegister(Model model, Integer id ) {
        setCommonData(model,donationRegisterService.findById(id));
        return "settings/donationRegister/settings-donation-register";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveDonationRegister(Model model, @ModelAttribute DonationRegisterDTO dto) {
        donationRegisterService.create(dto);
        setCommonData(model,dto);

        return "settings/donationRegister/settings-donation-register";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteDonationRegister(Model model, Integer id){
        donationRegisterService.delete(id);
        return "redirect:/donationregister/";
    }
    private void setCommonData(Model model, DonationRegisterDTO dto) {
        model.addAttribute("donationRegister", dto);
    }
}
