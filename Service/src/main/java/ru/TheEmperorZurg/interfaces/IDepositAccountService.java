package ru.TheEmperorZurg.interfaces;

import java.math.BigDecimal;
import java.util.Date;

public interface IDepositAccountService extends IAccountService {

    Long createDepositAccount(Long clientId, Long bankId, Date endDate);

    IDepositAccountService saveUpInterest(Long accountId);

    IDepositAccountService accrueInterest(Long accountId);

    BigDecimal getInterestOnBalance(Long accountId);

    Date getDepositEndDAte(Long accountId);

    boolean isTermEnded(Long accountId);
}
