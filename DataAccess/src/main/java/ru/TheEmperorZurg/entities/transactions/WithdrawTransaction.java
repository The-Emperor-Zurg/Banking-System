package ru.TheEmperorZurg.entities.transactions;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;
import ru.TheEmperorZurg.enums.TransactionType;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("WITHDRAW")
@NoArgsConstructor
public class WithdrawTransaction extends BaseTransaction {

    public WithdrawTransaction(BaseAccount senderAccount, BigDecimal amount) {
        this.senderAccount = senderAccount;
        this.amount = amount;

        this.receiverAccount = null;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.WITHDRAW_MONEY;
    }
}
