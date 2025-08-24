package ru.TheEmperorZurg.interfaces;

import ru.TheEmperorZurg.enums.AccountType;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface IAccountService {

    IAccountService withdrawMoney(Long accountId, BigDecimal amount);

    IAccountService addMoney(Long accountId, BigDecimal amount);

    BigDecimal getBalance(Long accountId);

    IAccountService updateTime(Date newTime);

    boolean isSuspicious(Long accountId);
}
