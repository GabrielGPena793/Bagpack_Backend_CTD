package com.ctd.services.impl;

import com.ctd.entities.Mail;
import com.ctd.services.ChekMail;

public class MailCommercial extends ChekMail {

    @Override
    public void processMail(Mail mail) {
        if (mail.getSubject().equals("Comercial")){
            System.out.println("email enviado para o Comercial");
        }else if(this.chekMailnextMail != null){
            this.chekMailnextMail.processMail(mail);
        }
    }
}
