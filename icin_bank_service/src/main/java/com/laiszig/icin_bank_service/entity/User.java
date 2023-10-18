package com.laiszig.icin_bank_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laiszig.icin_bank_service.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
    @JsonIgnore
    private String password;

    private String email;

    private Role role;

}
