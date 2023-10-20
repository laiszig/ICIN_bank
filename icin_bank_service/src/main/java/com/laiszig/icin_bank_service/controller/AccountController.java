package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.controller.request.AccountRequest;
import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.service.AccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

//    @GetMapping("/account")
//    public List<Account> getAll() {
//        return accountService.findAll();
//    }

    @PostMapping("/account/search")
    public Account searchAccountByPincode(@RequestBody AccountRequest accountRequest) {
        return accountService.getAccountByNumber(accountRequest.getAccountNumber());
    }
}
