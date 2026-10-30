package com.app.accountservice.service;

import com.app.accountservice.entity.Account;
import com.app.accountservice.repository.AccountRepository;
import org.springframework.ai.mcp.annotation.McpTool;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    @McpTool(description = "Get All accounts")
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account getAccountById(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public Account saveAccount(Account account) {
        Account savedAccount = accountRepository.findById(account.getId()).orElse(null);
        if (savedAccount == null) {
            savedAccount = accountRepository.save(account);
        }
        return savedAccount;
    }
}
