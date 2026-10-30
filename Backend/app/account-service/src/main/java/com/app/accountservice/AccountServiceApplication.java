package com.app.accountservice;

import com.app.accountservice.entity.Account;
import com.app.accountservice.enums.Status;
import com.app.accountservice.repository.AccountRepository;
import org.apache.hc.core5.reactor.IOSession;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository) {
        return args -> {

            List<Account> accounts = List.of(
                    new Account(UUID.randomUUID(), "CUST-0001", "MAD", 15250.75, Status.ACTIVE),
                    new Account(UUID.randomUUID(), "CUST-0002", "EUR", 3200.00,  Status.ACTIVE),
                    new Account(UUID.randomUUID(), "CUST-0003", "USD", 547.00,     Status.BLOCKED),
                    new Account(UUID.randomUUID(), "CUST-0004", "MAD", 87500.50, Status.ACTIVE),
                    new Account(UUID.randomUUID(), "CUST-0005", "GBP", 125.30,   Status.BLOCKED)
            );

            for(Account account : accounts) {
                accountRepository.save(account);
            }

        };
    }

}
