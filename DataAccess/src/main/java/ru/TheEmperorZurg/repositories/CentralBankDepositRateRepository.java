package ru.TheEmperorZurg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.CentralBankDepositRate;

import java.util.List;

@Repository
public interface CentralBankDepositRateRepository extends JpaRepository<CentralBankDepositRate, Long> {

    List<CentralBankDepositRate> findAllByOrderByOrderIndex();
}
