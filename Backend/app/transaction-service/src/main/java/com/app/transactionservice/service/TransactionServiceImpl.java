package com.app.transactionservice.service;

import com.app.transactionservice.entity.Transaction;
import com.app.transactionservice.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Service
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private TransactionRepository transactionRepository;
    private BigDecimal max_amount = BigDecimal.valueOf(1000);

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction makeTransaction(UUID accountId, BigDecimal amount, String currency, String country, Instant createdAt) {

        return null;
    }
}
