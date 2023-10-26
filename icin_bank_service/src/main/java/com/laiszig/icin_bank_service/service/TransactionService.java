package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.controller.request.TransactionRequest;
import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.entity.Transaction;
import com.laiszig.icin_bank_service.exception.AccountNotFoundException;
import com.laiszig.icin_bank_service.exception.InsufficientBalanceException;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final AccountRepository accountRepository;

    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getAllTransactions (){
        return transactionRepository.findAll();
    }

    public void makeTransfer(TransactionRequest transactionRequest) {
        String sourceAccountNumber = transactionRequest.getSourceAccountNumber();
        Account sourceAccount = accountRepository.findAccountByAccountNumber(sourceAccountNumber);
        String targetAccountNumber = transactionRequest.getTargetAccountNumber();
        Account targetAccount = accountRepository.findAccountByAccountNumber(targetAccountNumber);

        if (sourceAccount == null || targetAccount == null) {
            throw new AccountNotFoundException("Source or target account not found");
        }

        if (!isAmountAvailable(transactionRequest.getAmount(), sourceAccount.getBalance())) {
            throw new InsufficientBalanceException("Insufficient balance in the source account");
        }

        Transaction transaction = new Transaction();
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setSourceAccount(sourceAccount);
        transaction.setTargetAccount(targetAccount);
        transaction.setTargetUsername(targetAccount.getUser());
        transaction.setInitiationDate(LocalDateTime.now());
        transaction.setCompletionDate(LocalDateTime.now());

        updateAccountsBalance(sourceAccount, targetAccount, transactionRequest.getAmount());

        transactionRepository.save(transaction);
    }

    public void updateAccountsBalance(Account sourceAccount, Account targetAccount, double amount) {
        sourceAccount.setBalance((sourceAccount.getBalance() - amount));
        targetAccount.setBalance((targetAccount.getBalance() + amount));

        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);
    }

    public boolean isAmountAvailable(double amount, double accountBalance) {
        return (accountBalance - amount) > 0;
    }

}
