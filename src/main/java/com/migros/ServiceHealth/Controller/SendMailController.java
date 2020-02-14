package com.migros.ServiceHealth.Controller;


import com.migros.ServiceHealth.Model.MailModel;
import com.migros.ServiceHealth.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "mail")
public class SendMailController {

    @Autowired
    SendMailService sendMailService;

    @GetMapping("list")
    public ResponseEntity <List> readMail(){
        return new ResponseEntity<>(sendMailService.allMail(), HttpStatus.OK);

    }
    @PostMapping("save")
    public String saveMail(@RequestBody MailModel mailModel){
        sendMailService.sendEmail(mailModel);
        sendMailService.saveMail(mailModel);
        return "save";
    }

}




