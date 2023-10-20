package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.entity.User;
import com.laiszig.icin_bank_service.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public List<User> getAll(){
        return userService.findAllUsers();
    }

    @PostMapping("/user/{id}")
    public User searchUserById(@PathVariable Long id) {
        return userService.findUser(id);
    }
}
