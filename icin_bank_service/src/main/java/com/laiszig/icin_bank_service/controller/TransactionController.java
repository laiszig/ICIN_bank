package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.controller.request.TransactionRequest;
import com.laiszig.icin_bank_service.entity.Transaction;
import com.laiszig.icin_bank_service.service.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/user/transaction")
    public ResponseEntity<?> makeTransfer(@RequestBody TransactionRequest transactionRequest) {
            transactionService.makeTransfer(transactionRequest);
            return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/admin/transaction")
    public List<Transaction> getTransactions(){
        return transactionService.getAllTransactions();
    }

}
