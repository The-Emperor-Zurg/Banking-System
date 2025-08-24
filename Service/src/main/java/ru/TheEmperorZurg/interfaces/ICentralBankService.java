package ru.TheEmperorZurg.interfaces;

import ru.TheEmperorZurg.entities.CentralBankDepositRate;

import java.util.Date;
import java.util.List;

public interface ICentralBankService {

    Date getCurrentTime();

    ICentralBankService setTime(Date newTime);

    ICentralBankService skipDays(int days);

    ICentralBankService skipMonths(int months);

    List<CentralBankDepositRate> getRecommendedDepositRates();

    ICentralBankService updateRecommendedDepositRates(List<CentralBankDepositRate> newRates);

    ICentralBankService addBankObserver(IBankService bankService);

    ICentralBankService removeBankObserver(IBankService bankService);
}
