package com.migros.ServiceHealth.Controller;


import com.migros.ServiceHealth.Model.CheckServices;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.Service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "checkservices")
public class CheckServicesController {

    @Autowired
    CheckStatusService checkStatusService;

    @GetMapping("")
    public ResponseEntity<List> readCheckServices(){
        return new ResponseEntity<>(checkStatusService.allCheckServices(), HttpStatus.OK);

    }

    @PostMapping("")
    public String createCheckServices(@RequestBody CheckServices checkServices ){
        checkStatusService.scheduling(checkServices);
        checkStatusService.saveCheckService(checkServices);
        return "Send";
    }





}
