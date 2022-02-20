package com.ctd.services;

import com.ctd.model.entities.Card;

import java.time.LocalDate;

public abstract class PaymentService {


    public boolean processingPayment(Card card, double amount){
        boolean authorized = Boolean.FALSE;
        System.out.println("Processing payment...");

        if (card.getExpirationDate().isAfter(LocalDate.now())){
            boolean PaymentAuthorized = authorizedPayment(card,amount);

            if (PaymentAuthorized){
                System.out.println("Authorized payment, making payment...");
                authorized = Boolean.TRUE;
            }
            else {
                System.out.println("Payment denied!");
            }

        }
        else {
            System.out.println("Card date has expired!");
        }

        return authorized;
    }

    protected abstract boolean authorizedPayment(Card card,double amount);

}
