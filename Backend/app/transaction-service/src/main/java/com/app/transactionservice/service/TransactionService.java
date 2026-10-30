package com.app.transactionservice.service;

import com.app.transactionservice.entity.Transaction;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

public interface TransactionService {

    public Transaction makeTransaction(UUID accountId , BigDecimal amount , String currency , String country , Instant createdAt);
}
