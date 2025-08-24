package ru.TheEmperorZurg.interfaces;

import ru.TheEmperorZurg.entities.BankDepositRate;
import ru.TheEmperorZurg.entities.BankEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IBankService {

    BankEntity createBank(String name, BigDecimal debitPercent, BigDecimal creditLimit,
                          BigDecimal creditFee, BigDecimal suspiciousLimit);

    Optional<BankEntity> findById(Long bankId);

    Optional<BankEntity> findByName(String name);

    List<BankEntity> getAllBanks();

    Long createAccount(Long bankId, Long clientId, AccountType accountType);

    IBankService updateDepositInterestRates(Long bankId, List<BankDepositRate> newRates);

    List<BankDepositRate> getDepositInterestRates(Long bankId);

    IBankService onCentralBankRatesUpdated(List<BankDepositRate> newRates);

    IBankService deleteBank(Long bankId);
}
