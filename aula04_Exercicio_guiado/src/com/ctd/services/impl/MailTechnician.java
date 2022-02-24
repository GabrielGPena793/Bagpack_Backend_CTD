package com.ctd.services.impl;

import com.ctd.entities.Mail;
import com.ctd.services.ChekMail;

public class MailTechnician extends ChekMail {

    @Override
    public void processMail(Mail mail) {
        if (mail.getSubject().equals("Técnico")){
            System.out.println("email enviado para o Técnico");
        }else if(this.chekMailnextMail != null){
            this.chekMailnextMail.processMail(mail);
        }
    }
}
