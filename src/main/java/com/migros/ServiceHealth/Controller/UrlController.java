/*package com.migros.ServiceHealth.Controller;

import com.migros.ServiceHealth.Model.ServiceUrl;
import com.migros.ServiceHealth.Model.Services;
import com.migros.ServiceHealth.service.CheckStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(value = "/url")
public class UrlController {

    @Autowired
    CheckStatusService checkStatusService;

    @GetMapping("")
    public List<ServiceUrl> readUrl(@RequestBody ServiceUrl serviceUrl){
        return checkStatusService.allUrl();

    }

}
*/