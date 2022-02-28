package com.ctd.services.impl;

import com.ctd.model.Account;

public class AccountService {

    public void getStatusAccount(Account account){
        System.out.println("Account id : " + account.getId() +
                "\nbalance: R$ " + String.format("%.2f" ,account.getBalance()));
    }
}
