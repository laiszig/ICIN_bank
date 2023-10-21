package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.utils.CodeGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Account createAccount(Account account) {
        CodeGenerator codeGenerator = new CodeGenerator();
        account.setAccountNumber(codeGenerator.generateAccountNumber());
        return accountRepository.save(account);
    }
}
