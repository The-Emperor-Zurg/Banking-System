package ru.TheEmperorZurg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.TransactionEntity;
import ru.TheEmperorZurg.enums.TransactionStatus;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

    List<TransactionEntity> findByStatus(TransactionStatus status);

    List<TransactionEntity> findByTransactionType(String transactionType);

    @Query("SELECT t FROM TransactionEntity t WHERE t.senderAccount.id = :accountId OR t.receiverAccount.id = :accountId")
    List<TransactionEntity> findByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM TransactionEntity t WHERE t.senderAccount.id = :accountId")
    List<TransactionEntity> findBySenderAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM TransactionEntity t WHERE t.receiverAccount.id = :accountId")
    List<TransactionEntity> findByReceiverAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM TransactionEntity t WHERE t.senderAccount.client.id = :clientId OR t.receiverAccount.client.id = :clientId")
    List<TransactionEntity> findByClientId(@Param("cleintId") Long clientId);

    @Query("SELECT t FROM TransactionEntity t WHERE t.senderAccount.client.passport = :passport OR t.receiverAccount.client.passport = :passport")
    List<TransactionEntity> findByClientPassport(@Param("passport") String passport);
}
