package com.ctd.model.entities;

import java.time.LocalDate;

public class Debit extends Card {

    private double balanceAvaliable;

    public Debit() {
        super();
    }

    public Debit(int numberCard, int securityCode, LocalDate expirationDate, Type type, double balanceAvaliable) {
        super(numberCard, securityCode, expirationDate, type);
        this.balanceAvaliable = balanceAvaliable;
    }

    public double getBalanceAvaliable() {
        return balanceAvaliable;
    }

    public void setBalanceAvaliable(double balanceAvaliable) {
        this.balanceAvaliable = balanceAvaliable;
    }
}
