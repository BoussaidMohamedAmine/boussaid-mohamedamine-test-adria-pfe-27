package com.app.transactionservice.service;

import com.app.transactionservice.entity.Transaction;
import com.app.transactionservice.feign.AccountRestClient;
import com.app.transactionservice.model.Account;
import com.app.transactionservice.model.Status;
import com.app.transactionservice.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private AccountRestClient accountRestClient;

    public TransactionServiceImpl(TransactionRepository transactionRepository , AccountRestClient accountRestClient , Integer max_amount) {
        this.transactionRepository = transactionRepository;
        this.accountRestClient = accountRestClient;
    }

    @Override
    public Transaction makeTransaction(Transaction transaction) {

        Account account = accountRestClient.getAccount(transaction.getAccountId());
        if(account.getStatus() == Status.BLOCKED){
            throw new RuntimeException("Account is blocked");
        }
        if(transaction.getAmount() < 1000){
            throw new RuntimeException("Amount is lower than max amount");
        }
        Transaction savedtransaction = new Transaction();
        savedtransaction.setId(UUID.randomUUID());
        savedtransaction.setCreatedAt(new Date());
        savedtransaction.setAmount(transaction.getAmount());
        savedtransaction.setCurrency(transaction.getCurrency());
        savedtransaction.setCountry(transaction.getCountry());
        savedtransaction.setAccountId(transaction.getAccountId());


        return transactionRepository.save(savedtransaction);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }


}
