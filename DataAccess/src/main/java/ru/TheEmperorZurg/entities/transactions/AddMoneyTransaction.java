package ru.TheEmperorZurg.entities.transactions;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;
import ru.TheEmperorZurg.enums.TransactionType;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("ADD_MONEY")
@NoArgsConstructor
public class AddMoneyTransaction extends BaseTransaction {

    public AddMoneyTransaction(BaseAccount receiverAccount, BigDecimal amount) {
        this.receiverAccount = receiverAccount;
        this.amount = amount;

        this.senderAccount = null;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.ADD_MONEY;
    }
}
