package com.app.accountservice.web.rest;

import com.app.accountservice.entity.Account;
import com.app.accountservice.service.AccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {

    private AccountService accountService;

    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll() {
        return accountService.getAccounts();
    }

    @GetMapping("/accounts/{id}")
    public Account findOne(@PathVariable UUID id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/accounts")
    public Account save(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }
}
