package com.ctd.services.impl;

import com.ctd.entities.Mail;
import com.ctd.services.ChekMail;

public class MailSpan extends ChekMail {

    @Override
    public void processMail(Mail mail) {
        if (!mail.getSubject().equals("Gerência") || !mail.getSubject().equals("Tecnico") || !mail.getSubject().equals("Comercial")){
            System.out.println("email de Span");
        }else if (this.chekMailnextMail != null){
            this.chekMailnextMail.processMail(mail);
        }
    }
}
