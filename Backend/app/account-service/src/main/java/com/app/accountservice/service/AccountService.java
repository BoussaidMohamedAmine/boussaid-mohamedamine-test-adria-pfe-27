package com.app.accountservice.service;


import com.app.accountservice.entity.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    public List<Account> getAccounts();
    public Account getAccountById(UUID accountId);
    public Account saveAccount(Account account);
}
