package ru.TheEmperorZurg.entities.transactions;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;
import ru.TheEmperorZurg.enums.TransactionType;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("TRANSFER")
@NoArgsConstructor
public class TransferMoneyTransaction extends BaseTransaction {

    public TransferMoneyTransaction(BaseAccount senderAccount, BaseAccount receiverAccount, BigDecimal amount) {
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
    }

    @Override
    public TransactionType getTransactionType() {
        return TransactionType.TRANSFER;
    }
}
