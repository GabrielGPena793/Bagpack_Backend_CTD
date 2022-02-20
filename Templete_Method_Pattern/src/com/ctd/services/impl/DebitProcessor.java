package com.ctd.services.impl;

import com.ctd.model.entities.Card;
import com.ctd.model.entities.Debit;
import com.ctd.services.PaymentService;

public class DebitProcessor extends PaymentService {


    @Override
    protected boolean authorizedPayment(Card card, double amount) {
        Debit currentCard = (Debit) card;

        return currentCard.getBalanceAvaliable() >= amount;
    }
}
