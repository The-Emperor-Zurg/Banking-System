package ru.TheEmperorZurg.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "central_bank_deposit_rate")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CentralBankDepositRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "upper_limit", nullable = false)
    private Integer upperLimit;

    @Column(name = "percentage", nullable = false, precision = 5, scale = 2)
    private BigDecimal percentage;

    @Column(name = "order_index", nullable = false)
    private Integer orderIndex;

    public CentralBankDepositRate(Integer upperLimit, BigDecimal percentage, Integer orderIndex) {
        this.upperLimit = upperLimit;
        this.percentage = percentage;
        this.orderIndex = orderIndex;
    }
}
