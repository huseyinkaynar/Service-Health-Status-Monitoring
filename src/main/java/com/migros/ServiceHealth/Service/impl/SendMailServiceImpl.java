package com.migros.ServiceHealth.Service.impl;

import com.migros.ServiceHealth.Model.MailModel;
import com.migros.ServiceHealth.Model.ServicesModel;
import com.migros.ServiceHealth.Repositories.MailRepository;
import com.migros.ServiceHealth.Repositories.ServicesRepository;
import com.migros.ServiceHealth.Service.CheckStatusService;
import com.migros.ServiceHealth.Service.SendMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    MailRepository mailRepository;
    @Autowired
    ServicesRepository servicesRepository;
    @Autowired
    CheckStatusService checkStatusService;

    ArrayList<ArrayList<String>> all=new ArrayList<>();



    @Override
    public List<MailModel> allMail() {
        return mailRepository.findAll();
    }

    @Override
    public void saveMail(MailModel mailModel) {

        mailRepository.save(mailModel);

    }



    @Override
    public void sendEmail(MailModel mailModel) {
        List<ServicesModel> serviceList=checkStatusService.allServices();
        serviceList.forEach((a)->{
            all.add(new ArrayList<>(Arrays.asList(a.getName(), a.getUrl(),a.getStatus(),a.getDate().toString())));

        });
        System.out.println(all);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);

        try {
            messageHelper.setTo(mailModel.getToMail());
            messageHelper.setText(all.toString(),true);
            messageHelper.setSubject(mailModel.getMailSubject());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        javaMailSender.send(mimeMessage);




    }






}
