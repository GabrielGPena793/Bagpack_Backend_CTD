package com.ctd.model;

public class Account {

    private int id;
    private Double balance;
    private String password;

    public Account() {
    }

    public Account(int id, Double balance, String password) {
        this.id = id;
        this.balance = balance;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
