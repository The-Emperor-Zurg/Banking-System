package ru.TheEmperorZurg.entities.transactions;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;
import ru.TheEmperorZurg.enums.TransactionStatus;
import ru.TheEmperorZurg.enums.TransactionType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "transaction_type", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_account_id")
    protected BaseAccount senderAccount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reveiver_account_id")
    protected BaseAccount receiverAccount;

    @Column(name = "amount", nullable = false, precision = 15, scale = 2)
    protected BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "reveiver_account_id")
    protected TransactionStatus status = TransactionStatus.COMPLETED;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", updatable = false)
    protected Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "cancelled_at")
    protected Date cancelledAt;

    public abstract TransactionType getTransactionType();

    public boolean isCompleted() {
        return TransactionStatus.COMPLETED.equals(status);
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }

}
