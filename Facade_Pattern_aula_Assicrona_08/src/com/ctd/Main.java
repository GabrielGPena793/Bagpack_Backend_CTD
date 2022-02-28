package com.ctd;

import com.ctd.model.Account;
import com.ctd.services.IWithdrawalService;
import com.ctd.services.impl.AccountService;
import com.ctd.services.impl.AuthenticationService;
import com.ctd.services.impl.CashierService;
import com.ctd.services.impl.WithdrawalService;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Account account1 = new Account(1,2500.00,"senha1");
        Account account2 = new Account(2,9620.00,"senha2");
        Account account3 = new Account(3,5500.00,"senha3");

        IWithdrawalService withdrawalService = new WithdrawalService(
                new AuthenticationService(Arrays.asList(account1,account2,account3)),
                new AccountService(),
                new CashierService());

        withdrawalService.withdrawal(2, "senha2", 5010.00);

    }
}
