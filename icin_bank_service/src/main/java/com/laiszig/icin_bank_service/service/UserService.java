package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.controller.request.UserRequest;
import com.laiszig.icin_bank_service.entity.User;
import com.laiszig.icin_bank_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUser (Long id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
