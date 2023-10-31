package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.utils.CodeGenerator;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final HttpSession httpSession;

    public AccountService(AccountRepository accountRepository, HttpSession httpSession) {
        this.accountRepository = accountRepository;
        this.httpSession = httpSession;
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

    public Double getCheckingBalance() {


        var authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        var username = authenticationContext.getName();
        System.out.println(username);
        if (username == null) {
            // Handle the case where the username is null (not authenticated)
            throw new RuntimeException("User not authenticated");
        }

        List<Account> sourceAccounts = accountRepository.findAccountsByUserUsername((String) username);
        if (sourceAccounts == null || sourceAccounts.isEmpty()) {
            // Handle the case where no accounts are found for the user
            throw new RuntimeException("No accounts found for the user");
        }

        String accountType = "CHECKING";
        String sourceAccountNumber = null;
        for (Account userAccount : sourceAccounts) {
            if (userAccount.getAccountType().equalsIgnoreCase(accountType)) {
                sourceAccountNumber = userAccount.getAccountNumber();
                break;
            }
        }

        if (sourceAccountNumber != null) {
            Account sourceAccount = accountRepository.findAccountByAccountNumber(sourceAccountNumber);
            if (sourceAccount != null) {
                return sourceAccount.getBalance();
            } else {
                // Handle the case where sourceAccount is null (not found in the repository)
                throw new RuntimeException("Source account not found");
            }
        } else {
            // Handle the case where sourceAccountNumber is null (no matching account type)
            throw new RuntimeException("No checking account found for the user");
        }
    }

}
