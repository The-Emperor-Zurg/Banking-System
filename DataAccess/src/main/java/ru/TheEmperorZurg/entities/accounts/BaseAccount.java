package ru.TheEmperorZurg.entities.accounts;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.TheEmperorZurg.entities.BankEntity;
import ru.TheEmperorZurg.entities.ClientEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "account_type", discriminatorType = DiscriminatorType.STRING)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    protected ClientEntity client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    protected BankEntity bank;

    @Column(name = "balance", nullable = false, precision = 15, scale = 2)
    protected BigDecimal balance =  BigDecimal.ZERO;

    // Поле только для DEPOSIT и DEBIT
    @Column(name = "interest_on_balance", precision = 15, scale = 2)
    protected BigDecimal interestOnBalance;

    @Column(name = "days_counter")
    protected Integer daysCounter;

    @Temporal(TemporalType.DATE)
    @Column(name = "previous_check_day")
    protected Date previousCheckDay;

    // Поле только для DEPOSIT
    @Temporal(TemporalType.DATE)
    @Column(name = "deposit_end_date")
    protected Date depositEndDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "created_at", updatable = false)
    protected Date createdAt;

    @Temporal(TemporalType.DATE)
    @Column(name = "updated_at")
    protected Date updatedAt;

    public abstract AccountType getAccountType();

    public boolean hasInterestCalculation() {
        return interestOnBalance != null && daysCounter != null;
    }

    public boolean hasDepositEndDate() {
        return depositEndDate != null;
    }

    @PrePersist
    protected void onCreate() {
        Date now = new Date();
        createdAt = now;
        updatedAt = now;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }
}
