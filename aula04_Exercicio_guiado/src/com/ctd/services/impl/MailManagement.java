package com.ctd.services.impl;

import com.ctd.entities.Mail;
import com.ctd.services.ChekMail;

public class MailManagement extends ChekMail {

    @Override
    public void processMail(Mail mail) {
        if (mail.getSubject().equals("Gerência")){
            System.out.println("email enviado para a Gerência");
        }else if (this.chekMailnextMail != null){
            this.chekMailnextMail.processMail(mail);
        }
    }
}
