package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;

import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/services")
public class ServicesController {

    @Autowired
    CheckStatusService checkStatusService;




    @GetMapping("")
    public ResponseEntity<List> readServices(){
        return new ResponseEntity<>(checkStatusService.allServices(), HttpStatus.OK);

    }
    @GetMapping("/page")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginated(Pageable pageable){

        Page<Services> resultPage = checkStatusService.getServicesPage(pageable);
        return new ResponseEntity<>(resultPage,HttpStatus.OK);
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











}
