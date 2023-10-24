package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.utils.CodeGenerator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountByNumber (String accNumber) {
        return accountRepository.findAccountByAccountNumber(accNumber);
    }

    public Optional<Account> getAccount(Long id) {
        return accountRepository.findById(id);
    }

    public Account createAccount(Account account) {
        CodeGenerator codeGenerator = new CodeGenerator();
        account.setAccountNumber(codeGenerator.generateAccountNumber());
        return accountRepository.save(account);
    }

    public Account deposit(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(Long id, double amount) {
        Account account = getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

}
