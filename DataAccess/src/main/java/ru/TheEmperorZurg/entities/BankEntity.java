package ru.TheEmperorZurg.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;

import java.math.BigDecimal;
import java.util.List;


@Entity
@Table(name = "banks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "debit_percent", nullable = false, precision = 15, scale = 2)
    private BigDecimal debitPercent;

    @Column(name = "credit_limit", nullable = false, precision = 15, scale = 2)
    private BigDecimal creditLimit;

    @Column(name = "credit_fee", nullable = false, precision = 15, scale = 2)
    private BigDecimal creditFee;

    @Column(name = "suspicious_limit", nullable = false, precision = 15, scale = 2)
    private BigDecimal suspiciousLimit;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BaseAccount> accounts;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BankDepositRate> bankDepositRates;
}
