package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.controller.request.TransactionRequest;
import com.laiszig.icin_bank_service.entity.Transaction;
import com.laiszig.icin_bank_service.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> makeTransfer(@RequestBody TransactionRequest transactionRequest) {
            transactionService.makeTransfer(transactionRequest);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/transaction")
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

}
