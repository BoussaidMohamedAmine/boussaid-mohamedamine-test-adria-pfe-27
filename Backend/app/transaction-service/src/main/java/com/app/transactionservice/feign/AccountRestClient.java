package com.app.transactionservice.feign;

import com.app.transactionservice.model.Account;
import com.app.transactionservice.model.Status;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;


@FeignClient(name= "account-service")
public interface AccountRestClient {

    @GetMapping("/accounts/{id}")
    @CircuitBreaker(name="account-service" ,fallbackMethod = "getDefaultAccount")
    Account getCustomer(@PathVariable("id") UUID id);

    default Account getDefaultAccount(UUID id , Exception exception){
        return new Account(id, "NULL" , "NULL" ,0.0, Status.NULL );
    }
}