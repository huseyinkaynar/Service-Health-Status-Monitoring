package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServicesController {

    @Autowired
    CheckStatusService checkStatusService;

    @GetMapping("")
    public List<Services> readServices(@RequestBody Services services){
        return checkStatusService.allServices();

    }

    @PostMapping("")
    public String createServices(@RequestBody Services services){

        checkStatusService.saveService(services);
       return "Saved";
    }


     @DeleteMapping("/{id}")
     public String deleteServices(@PathVariable long id ){

        checkStatusService.deleteService(id);
        return "Deleted";
     }

    @GetMapping("/health")
    public Health getHealth(){
        return checkStatusService.health();

    }








}
