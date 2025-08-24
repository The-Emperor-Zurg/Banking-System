package ru.TheEmperorZurg.entities.accounts;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.BankEntity;
import ru.TheEmperorZurg.entities.ClientEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@DiscriminatorValue("DEBIT")
@NoArgsConstructor
public class DebitAccount extends BaseAccount {

    public DebitAccount(ClientEntity client, BankEntity bank) {
        this.client = client;
        this.bank = bank;

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
