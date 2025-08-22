package ru.TheEmperorZurg.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.AccountEntity;
import ru.TheEmperorZurg.enums.AccountType;

import java.util.List;


@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {

    List<AccountEntity> findByClientId(Long clientId);

    List<AccountEntity> findByBankId(Long bankId);

    List<AccountEntity> findByAccountType(AccountType accountType);

    @Query("SELECT a FROM AccountEntity a WHERE a.client.id = :clientId AND a.bank.id = :bankId")
    List<AccountEntity> findByClientIdAndBankId(@Param("clientId") Long clientId,
                                                @Param("bankId") Long BankId);

    @Query("SELECT a FROM AccountEntity a WHERE a.client.passport = :passport AND a.bank.id = :bankId")
    List<AccountEntity> findByClientPassportAndBankId(@Param("passport") Integer passport,
                                                      @Param("bankId") Long bankId);

    @Query("SELECT a FROM AccountEntity a WHERE a.client.passport IS NULL OR a.client.address IS NULL")
    List<AccountEntity> findSuspiciousAccounts();
}
