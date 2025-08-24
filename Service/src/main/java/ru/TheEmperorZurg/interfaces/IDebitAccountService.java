package ru.TheEmperorZurg.interfaces;

import java.math.BigDecimal;

public interface IDebitAccountService extends IAccountService {

    Long createDebitAccount(Long clientId, Long bankId);

    IDebitAccountService saveUpInterest(Long accountId);

    IDebitAccountService accrueInterest(Long accountId);

    BigDecimal getInterestOnBalance(Long accountId);
}
