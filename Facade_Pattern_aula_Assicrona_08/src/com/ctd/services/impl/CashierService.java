package com.ctd.services.impl;

import com.ctd.model.Account;

public class CashierService {

    public void withdrawMoney(Account account, double amount){

        if (account.getBalance() >= amount){
            System.out.println("Successful withdrawal");
            account.setBalance( account.getBalance() - amount );
        }
        else {
            System.out.println("insufficient balance");
        }
    }
}
