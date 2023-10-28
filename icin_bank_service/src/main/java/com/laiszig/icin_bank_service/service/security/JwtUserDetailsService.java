package com.laiszig.icin_bank_service.service.security;

import com.laiszig.icin_bank_service.controller.request.UserRequest;
import com.laiszig.icin_bank_service.entity.User;
import com.laiszig.icin_bank_service.repository.RoleRepository;
import com.laiszig.icin_bank_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return Optional.ofNullable(userRepository.findByUsername(username))
                .map(userEntity -> new org.springframework.security.core.userdetails.User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getAuthorities()))
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));
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