package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Repositories.ServicesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class servicesController {
    private ServicesRepository servicesRepository;

    public servicesController (ServicesRepository servicesRepository){this.servicesRepository=servicesRepository;}
    @RequestMapping("/Services")
    public String getServices(Model model){

        model.addAttribute("Services", servicesRepository.findAll());

        return "Services";
    }
}
