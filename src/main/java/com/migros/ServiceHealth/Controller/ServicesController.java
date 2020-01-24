package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Model.Services;

import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<List> findAllPaginated(@RequestParam("pageNumber") int pageNumber){

        Page<Services> resultPage = checkStatusService.getServicesPage(pageNumber);
        return new ResponseEntity<>(resultPage.getContent(),HttpStatus.OK);
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
