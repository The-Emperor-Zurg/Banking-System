package ru.TheEmperorZurg.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "bank_deposit_rates")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankDepositRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private BankEntity bank;

    @Column(name = "upper_limit", nullable = false)
    private Integer upperLimit;

    @Column(name = "percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    public BankDepositRate(BankEntity bank, Integer upperLimit, BigDecimal percentage, Integer orderIndex) {
        this.bank = bank;
        this.upperLimit = upperLimit;
        this.percentage = percentage;
        this.orderIndex = orderIndex;
    }
}
