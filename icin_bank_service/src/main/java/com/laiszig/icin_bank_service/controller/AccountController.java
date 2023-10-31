package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.controller.request.AccountRequest;
import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.entity.Status;
import com.laiszig.icin_bank_service.service.AccountService;
import com.laiszig.icin_bank_service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/admin/accounts")
    public List<Account> getAll() {
        return accountService.getAllAccounts();
    }

    @PutMapping(value = "/admin/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {

        Account account = new Account();
        account.setAccountType(accountRequest.getAccountType());
        account.setUser(userService.findUser(accountRequest.getUserId()));
        account.setStatus(Status.OPEN);
        account.setBalance(0.0);
        accountService.createAccount(account);

        return new ResponseEntity<>("Account created successfully", HttpStatus.OK);
    }

    @GetMapping("admin/account/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id).orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @PostMapping("/user/account/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.deposit(id, amount);
    }

    @PostMapping("/user/account/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request) {
        Double amount = request.get("amount");
        return accountService.withdraw(id, amount);
    }

    @GetMapping("/account/balance")
    public Double getCheckingBalance() {
        return accountService.getCheckingBalance();
    }

}
