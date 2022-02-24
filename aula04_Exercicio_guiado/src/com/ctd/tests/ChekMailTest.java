package com.ctd.tests;

import com.ctd.entities.Mail;
import com.ctd.services.ChekMail;
import com.ctd.services.impl.MailCommercial;
import com.ctd.services.impl.MailManagement;
import com.ctd.services.impl.MailSpan;
import com.ctd.services.impl.MailTechnician;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChekMailTest {

    ChekMail comercialMail = new MailCommercial().setNextMail(new MailManagement().setNextMail(new MailTechnician().setNextMail(new MailSpan())));

    @Test
    public void ShouldReturnMailManagementWhenSubjetctGerencia(){
        Mail mail = new Mail("exemplo", "gerencia@colmeia.com", "Gerência");

        comercialMail.processMail(mail);

    }

    @Test
    public void ShouldReturnMailTechnicianWhenSubjetctTecnico(){
        Mail mail = new Mail("exemplo", "gerencia@colmeia.com", "Técnico");

        comercialMail.processMail(mail);
    }

    @Test
    public void ShouldReturnMailCommercialWhenSubjetctComercial(){
        Mail mail = new Mail("exemplo", "gerencia@colmeia.com", "Comercial");

        comercialMail.processMail(mail);
    }


    @Test
    public void ShouldReturnMailSpanWhenSubjetctNotCorrespont(){
        Mail mail = new Mail("exemplo", "gerencia@colmeia.com", "dasdasfasga555");

        comercialMail.processMail(mail);
    }


}