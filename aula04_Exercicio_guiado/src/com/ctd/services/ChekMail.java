package com.ctd.services;

import com.ctd.entities.Mail;

public abstract class ChekMail {

    protected ChekMail chekMailnextMail;

    public abstract void processMail (Mail mail);

    public ChekMail getNextMail(){
        return chekMailnextMail;
    }

    public ChekMail setNextMail(ChekMail chekMailnextMail){
        this.chekMailnextMail = chekMailnextMail;
        return this;
    }
}
