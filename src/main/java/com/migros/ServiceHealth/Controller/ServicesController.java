package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Repositories.ServicesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServicesController {
    private ServicesRepository servicesRepository;

    public ServicesController(ServicesRepository servicesRepository){this.servicesRepository=servicesRepository;}
    @RequestMapping("/services")
    public String getServices(Model model){

        model.addAttribute("services", servicesRepository.findAll());

        return "services";
    }

}
