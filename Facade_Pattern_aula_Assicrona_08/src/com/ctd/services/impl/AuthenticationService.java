package com.ctd.services.impl;

import com.ctd.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AuthenticationService {

    private final List<Account> accounts;

    public AuthenticationService(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Account validateUserAndPassword(Integer id, String password){
        for (Account account : accounts) {

            if (account.getId() == id && account.getPassword().equals(password)) {
                System.out.println("successfully validated");
                return account;
            }
        }

        System.out.println("Passorword or id invalid!");
        return null;
    }
}
