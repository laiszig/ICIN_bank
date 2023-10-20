package com.laiszig.icin_bank_service.controller.request;

import com.laiszig.icin_bank_service.entity.User;
import lombok.Data;

@Data
public class AccountRequest {

    private Long id;
    private User user;
    private Long accountNumber;
    private Long balance;
    private String accountType;
}
