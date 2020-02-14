package com.migros.ServiceHealth.Service;

import com.migros.ServiceHealth.Model.MailModel;

import java.util.List;

public interface SendMailService {
    List<MailModel> allMail();
    void saveMail(MailModel mailModel);
    void sendEmail(MailModel mailModel);
}
