package com.ctd.model.entities;

import java.time.LocalDate;

public class Card {

    private int numberCard;
    private int securityCode;
    private LocalDate expirationDate;
    private Type type;


    public Card() {
    }

    public Card(int numberCard, int securityCode, LocalDate expirationDate, Type type) {
        this.numberCard = numberCard;
        this.securityCode = securityCode;
        this.expirationDate = expirationDate;
        this.type = type;
    }

    public int getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(int numberCard) {
        this.numberCard = numberCard;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
