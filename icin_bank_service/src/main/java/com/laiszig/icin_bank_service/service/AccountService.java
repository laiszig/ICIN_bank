package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByNumber (Long accNumber) {
        return accountRepository.findAccountByAccountNumber(accNumber);
    }
}
