package com.ctd.services.impl;

import com.ctd.model.Account;
import com.ctd.services.IWithdrawalService;

public class WithdrawalService implements IWithdrawalService {

    private AuthenticationService authenticationService;
    private AccountService accountService;
    private CashierService cashierService;

    public WithdrawalService(AuthenticationService authenticationService, AccountService accountService, CashierService cashierService) {
        this.authenticationService = authenticationService;
        this.accountService = accountService;
        this.cashierService = cashierService;
    }

    @Override
    public void withdrawal(Integer id, String passaword, Double amount) {

        Account account = authenticationService.validateUserAndPassword(id, passaword);

        if (account != null){
            System.out.println();
            System.out.println("Account Status:");
            accountService.getStatusAccount(account);
            System.out.println();
            System.out.println("Processing withdraw...");
            cashierService.withdrawMoney(account, amount);
            System.out.println();
            System.out.println("Account Status:");
            accountService.getStatusAccount(account);
        }
    }
}
