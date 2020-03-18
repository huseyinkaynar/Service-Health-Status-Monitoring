package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Model.ServicesModel;

import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/services")
public class ServicesController {

    @Autowired
    CheckStatusService checkStatusService;

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<Page> findAllPaginated(Pageable pageable){

        Page<ServicesModel> resultPage = checkStatusService.getServicesPage(pageable);
        return new ResponseEntity<>(resultPage,HttpStatus.OK);
    }

    @PostMapping("")
    public String createServices(@RequestBody ServicesModel servicesModel){

        checkStatusService.saveService(servicesModel);
       return "Saved";
    }


     @DeleteMapping("/{id}")
     public String deleteServices(@PathVariable long id ){

        checkStatusService.deleteService(id);
        return "Deleted";
     }


    @GetMapping("/search")
    @ResponseBody
    public ResponseEntity<Page> searchServiceNameQuery(@RequestParam(value = "name") String name, Pageable pageable) {

        Page<ServicesModel> searchPage = checkStatusService.getSearchServices(name, pageable);
        return new ResponseEntity<>(searchPage,HttpStatus.OK);


    }












}
