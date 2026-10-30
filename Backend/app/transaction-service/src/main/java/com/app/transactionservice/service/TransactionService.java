package com.app.transactionservice.service;

import com.app.transactionservice.entity.Transaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionService {

    public Transaction makeTransaction(Transaction transaction);
    public List<Transaction> getAllTransactions();
}
