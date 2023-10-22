package com.laiszig.icin_bank_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.laiszig.icin_bank_service.security.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "username")
    private String username;

    @Column(name = "password")
    @JsonIgnore
    private String password;

    @Column(name = "user_email")
    private String email;

    @OneToOne
    @JoinColumn(name = "role_name")
    private Role role;

    private Boolean enabled;

}
