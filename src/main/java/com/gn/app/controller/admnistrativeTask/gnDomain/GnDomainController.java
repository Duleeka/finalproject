package com.gn.app.controller.admnistrativeTask.gnDomain;


import com.gn.app.dto.administrativeTask.GnDomain.GnDomainDTO;
import com.gn.app.service.AdministrativeTask.GnDomain.GnDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(com.gn.app.controller.admnistrativeTask.gnDomain.GnDomainController.REQUEST_MAPPING_URL)
public class GnDomainController {
    public static final String REQUEST_MAPPING_URL ="/gndivision";

    @Autowired
    GnDomainService gnDomainService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(Model model) {
        return "administrativeTask/gnDivision/home-view";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String newGnDomain(Model model){
        setCommonData(model, new GnDomainDTO() );
        return "administrativeTask/gnDivision/administrative-task-gn-division";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editGnDomain(Model model, Integer id){
        setCommonData(model,gnDomainService.findById(id));
        return "administrativeTask/gnDivision/administrative-task-gn-division";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveGnDomain(Model model, @ModelAttribute GnDomainDTO dto) {
        gnDomainService.create(dto);
        setCommonData(model,dto);

        return "administrativeTask/gnDivision/administrative-task-gn-division";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteGnDomain(Model model, Integer id){
        gnDomainService.delete(id);
        return "redirect:/gndivision/";
    }
    private void setCommonData(Model model, GnDomainDTO dto)
    {
        model.addAttribute("gnDomain",dto);
    }
}
