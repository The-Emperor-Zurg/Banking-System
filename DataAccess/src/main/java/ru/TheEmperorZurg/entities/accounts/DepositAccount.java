package ru.TheEmperorZurg.entities.accounts;

import ru.TheEmperorZurg.entities.BankEntity;
import ru.TheEmperorZurg.entities.ClientEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;

public class DepositAccount extends BaseAccount {

    public DepositAccount(ClientEntity client, BankEntity bank, Date endDate) {
        this.client = client;
        this.bank = bank;
        this.depositEndDate = endDate;

        this.balance = BigDecimal.ZERO;
        this.interestOnBalance = BigDecimal.ZERO;
        this.daysCounter = 0;
        this.previousCheckDay = new Date();
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.DEBIT;
    }
}
