package ru.TheEmperorZurg.entities.accounts;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.BankEntity;
import ru.TheEmperorZurg.entities.ClientEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("CREDIT")
@NoArgsConstructor
public class CreditAccount extends BaseAccount {

    public CreditAccount(ClientEntity client, BankEntity bank) {
        this.client = client;
        this.bank = bank;

        this.balance = BigDecimal.ZERO;
        this.interestOnBalance = null;
        this.daysCounter = null;
        this.previousCheckDay = null;
    }

    @Override
    public AccountType getAccountType() {
        return AccountType.CREDIT;
    }
}
