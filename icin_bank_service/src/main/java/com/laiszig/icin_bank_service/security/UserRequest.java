package com.laiszig.icin_bank_service.security;

import lombok.Data;

@Data
public class UserRequest {

    private String username;
    private String password;
    private String email;

}
