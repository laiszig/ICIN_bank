package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.utils.CodeGenerator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    private static final String CHECKING = "CHECKING";
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

    public Account deposit(double amount) {

        Authentication authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticationContext.getName();

        Account account = getUserAccount(username, CHECKING);

        account.setBalance(account.getBalance() + amount);
        return accountRepository.save(account);
    }

    public Account withdraw(double amount) {

        Authentication authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticationContext.getName();

        Account account = getUserAccount(username, CHECKING);

        if (account.getBalance() < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        account.setBalance(account.getBalance() - amount);
        return accountRepository.save(account);
    }

    public Double getCheckingBalance() {
        Authentication authenticationContext = SecurityContextHolder.getContext().getAuthentication();
        String username = authenticationContext.getName();
        System.out.println(username);
        if (username == null) {
            throw new RuntimeException("User not authenticated");
        }

        List<Account> userAccounts = getUserAccounts(username);
        String sourceAccountNumber = getSourceAccountNumber(userAccounts, CHECKING);

        if (sourceAccountNumber != null) {
            return getAccountBalance(sourceAccountNumber);
        } else {
            throw new RuntimeException("No checking account found for the user");
        }
    }

    private Account getUserAccount(String username, String accountType) {
        List<Account> userAccounts = getUserAccounts(username);
        String sourceAccountNumber = getSourceAccountNumber(userAccounts, accountType);
        return getAccountByNumber(sourceAccountNumber);
    }

    public List<Account> getUserAccounts(String username) {
        List<Account> userAccounts = accountRepository.findAccountsByUserUsername(username);
        if (userAccounts == null || userAccounts.isEmpty()) {
            throw new RuntimeException("No accounts found for the user");
        }
        return userAccounts;
    }

    public String getSourceAccountNumber(List<Account> userAccounts, String accountType) {
        for (Account userAccount : userAccounts) {
            if (userAccount.getAccountType().equalsIgnoreCase(accountType)) {
                return userAccount.getAccountNumber();
            }
        }
        return null;
    }

    public Double getAccountBalance(String accountNumber) {
        Account sourceAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if (sourceAccount != null) {
            return sourceAccount.getBalance();
        } else {
            throw new RuntimeException("Source account not found");
        }
    }

}
