package ru.TheEmperorZurg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.accounts.BaseAccount;
import ru.TheEmperorZurg.entities.accounts.DebitAccount;
import ru.TheEmperorZurg.entities.accounts.DepositAccount;

import java.util.List;


@Repository
public interface IAccountRepository extends JpaRepository<BaseAccount, Long> {

    List<BaseAccount> findByClientId(Long clientId);

    List<BaseAccount> findByBankId(Long bankId);

    @Query("SELECT a FROM BaseAccount a WHERE a.client.id = :clientId AND a.bank.id = :bankId")
    List<BaseAccount> findByClientIdAndBankId(Long clientId, Long bankId);

    @Query("SELECT a FROM BaseAccount a WHERE a.client.passport IS NULL OR a.client.passport IS NULL")
    List<BaseAccount> findSuspiciousAccounts();

    @Query("SELECT a FROM BaseAccount a WHERE a.client.passport = :passport AND a.bank.id = :bankId")
    List<BaseAccount> findByClientPassportAndBankId(@Param("passport") Integer passport, @Param("bankId") Long bankId);

    @Query("SELECT a FROM DebitAccount a WHERE a.client.id = :clientId")
    List<DebitAccount> findDebitAccountsByClientId(@Param("clientId") Long clientId);

    @Query("SELECT a FROM DepositAccount a WHERE a.client.id = :clienId")
    List<DepositAccount> findDepositAccountsByClientId(@Param("clientId") Long clientId);

    @Query("SELECT a FROM DepositAccount a WHERE a.depositEndDate < CURRENT_DATE")
    List<DepositAccount> findExpiredDepositAccounts();
}
