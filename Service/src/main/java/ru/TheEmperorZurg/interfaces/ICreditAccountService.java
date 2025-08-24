package ru.TheEmperorZurg.interfaces;

import java.math.BigDecimal;

public interface ICreditAccountService extends IAccountService {

    Long createCreaditAccount(Long clientId, Long bankId);

    BigDecimal getCreditLimit(Long accountId);

    BigDecimal getCreditFee(Long accountId);

    ICreditAccountService applyMonthlyFee(Long accountId);
}
