package ru.TheEmperorZurg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.TheEmperorZurg.entities.transactions.AddMoneyTransaction;
import ru.TheEmperorZurg.entities.transactions.BaseTransaction;
import ru.TheEmperorZurg.entities.transactions.TransferMoneyTransaction;
import ru.TheEmperorZurg.entities.transactions.WithdrawTransaction;
import ru.TheEmperorZurg.enums.TransactionStatus;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<BaseTransaction, Long> {

    List<BaseTransaction> findByStatus(TransactionStatus status);

    @Query("SELECT t FROM BaseTransaction t WHERE t.senderAccount.id = :accountId OR t.receiverAccount.id = :accountId")
    List<BaseTransaction> findByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM BaseTransaction t WHERE t.senderAccount.id = :accountId")
    List<BaseTransaction> findBySenderAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM BaseTransaction t WHERE t.receiverAccount.id = :accountId")
    List<BaseTransaction> findByReceiverAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM BaseTransaction t WHERE t.senderAccount.client.id = :clientId OR t.receiverAccount.client.id = :clientId")
    List<BaseTransaction> findByClientId(@Param("clientId") Long clientId);

    @Query("SELECT t FROM BaseTransaction t WHERE t.senderAccount.client.passport = :passport OR t.receiverAccount.client.passport = :passport")
    List<BaseTransaction> findByClientPassport(@Param("passport") Integer passport);

    @Query("SELECT t FROM AddMoneyTransaction t WHERE t.receiverAccount.id = :accountId")
    List<AddMoneyTransaction> findAddMoneyTransactionsByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM WithdrawTransaction t WHERE t.senderAccount.id = :accountId")
    List<WithdrawTransaction> findWithDrawTransactionsByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM TransferMoneyTransaction t WHERE t.senderAccount.id = :accountId OR t.receiverAccount.id = :accountId")
    List<TransferMoneyTransaction> findTransferTransactionsByAccountId(@Param("accountId") Long accountId);

    @Query("SELECT t FROM BaseTransaction t WHERE t.status = 'CANCELLED' AND t.cancelledAt IS NOT NULL")
    List<BaseTransaction> findCancelledTransactions();
}
