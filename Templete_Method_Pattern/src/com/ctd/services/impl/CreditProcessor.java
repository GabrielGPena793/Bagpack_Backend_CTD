package com.ctd.services.impl;

import com.ctd.model.entities.Card;
import com.ctd.model.entities.Credit;
import com.ctd.services.PaymentService;

public class CreditProcessor extends PaymentService {

    @Override
    protected boolean authorizedPayment(Card card, double amount) {
        Credit currentCard = (Credit) card;

        double attLimit = currentCard.getLimit() - currentCard.getBalanceUsed();

        return attLimit >= amount;
    }
}
