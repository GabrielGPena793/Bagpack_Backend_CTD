package com.ctd.model.entities;

import java.time.LocalDate;

public class Credit extends Card {

    private double limit;
    private double balanceUsed;

    public Credit() {
        super();
    }

    public Credit(int numberCard, int securityCode, LocalDate expirationDate, Type type, double limit, double balanceUsed) {
        super(numberCard, securityCode, expirationDate, type);
        this.limit = limit;
        this.balanceUsed = balanceUsed;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getBalanceUsed() {
        return balanceUsed;
    }

    public void setBalanceUsed(double balanceUsed) {
        this.balanceUsed = balanceUsed;
    }
}
