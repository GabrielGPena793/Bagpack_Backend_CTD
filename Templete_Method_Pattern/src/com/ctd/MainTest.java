package com.ctd;

import com.ctd.model.entities.Card;
import com.ctd.model.entities.Credit;
import com.ctd.model.entities.Debit;
import com.ctd.model.entities.Type;
import com.ctd.services.PaymentService;
import com.ctd.services.impl.CreditProcessor;
import com.ctd.services.impl.DebitProcessor;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Map;

public class MainTest {

    Map<String, PaymentService> paymentServices = Map.of("Credit", new CreditProcessor(), "Debit", new DebitProcessor());

    @Test
    public void creditPayment(){
        LocalDate date = LocalDate.of(2025,3,9);

        Card creditCard = new Credit(51133551, 250, date, Type.CREDIT , 5000.00, 1000.00);

        PaymentService paymentService = paymentServices.get("Credit");

        System.out.println("Payment made by credit card: " +
                paymentService.processingPayment(creditCard, 4000.00));

    }

    @Test
    public void debitPayment(){
        LocalDate date = LocalDate.of(2000,3,9);

        Card debitCard = new Debit(51133551, 250, date, Type.DEBIT , 2000.00);

        PaymentService paymentService = paymentServices.get("Debit");

        System.out.println("Payment made by debit card: " +
                paymentService.processingPayment(debitCard, 3000.00));

    }
}
