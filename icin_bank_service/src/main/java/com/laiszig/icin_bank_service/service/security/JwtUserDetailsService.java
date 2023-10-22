package com.laiszig.icin_bank_service.service.security;

import com.laiszig.icin_bank_service.controller.request.UserRequest;
import com.laiszig.icin_bank_service.entity.User;
import com.laiszig.icin_bank_service.repository.RoleRepository;
import com.laiszig.icin_bank_service.repository.UserRepository;
import com.laiszig.icin_bank_service.security.Role;
import com.laiszig.icin_bank_service.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private RoleRepository roleRepository;


//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return Optional.ofNullable(userRepository.findByUsername(username))
//                .map(user -> new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),new ArrayList<>()))
//                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UserDetailsImpl(user);
    }

    public User save(UserRequest user) {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
        newUser.setEmail(user.getEmail());
        newUser.setRole(roleRepository.findRoleByName("USER"));
        return userRepository.save(newUser);
    }
}