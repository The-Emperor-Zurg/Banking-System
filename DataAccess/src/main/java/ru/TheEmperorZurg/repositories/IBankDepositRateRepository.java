package ru.TheEmperorZurg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.TheEmperorZurg.entities.BankDepositRate;

import java.util.List;

public interface IBankDepositRateRepository extends JpaRepository<BankDepositRate, Long> {

    List<BankDepositRate> findByBankIdOrderByOrderIndex(Long bankId);

    void deleteByBankId(Long bankId);
}
