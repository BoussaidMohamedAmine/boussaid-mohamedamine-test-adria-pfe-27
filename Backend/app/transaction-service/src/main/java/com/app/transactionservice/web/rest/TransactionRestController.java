package com.app.transactionservice.web.rest;

import com.app.transactionservice.entity.Transaction;
import com.app.transactionservice.service.TransactionService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Setter
@RestController
public class TransactionRestController {

    private TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transactions")
    public Transaction makeTransaction(@RequestBody Transaction transaction){
        return transactionService.makeTransaction(transaction);
    }

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions(){
        return transactionService.getAllTransactions();
    }
}
