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

@RestController
public class AccountController {

    private final AccountService accountService;
    private final UserService userService;

    public AccountController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/account")
    public List<Account> getAll() {
        return accountService.getAllAccounts();
    }

    @PostMapping("/account/search")
    public Account searchAccountByNumber(@RequestBody AccountRequest accountRequest) {
        return accountService.getAccountByNumber(accountRequest.getAccountNumber());
    }

    @PutMapping(value = "/account")
    public ResponseEntity<?> createAccount(@RequestBody AccountRequest accountRequest) {

        Account account = new Account();
        account.setAccountType(accountRequest.getAccountType());
        account.setUser(userService.findUser(accountRequest.getUserId()));
        account.setStatus(Status.OPEN);
        account.setBalance(0L);
        accountService.createAccount(account);
        return new ResponseEntity<>("Account created successfully", HttpStatus.OK);

    }
}
