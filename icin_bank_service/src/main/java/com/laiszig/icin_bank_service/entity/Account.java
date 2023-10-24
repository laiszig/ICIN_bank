package com.laiszig.icin_bank_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @Column(name = "account_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "account_number")
    private String accountNumber;

    @Column(name = "account_balance")
    private Double balance;

    @Column(name = "account_type")
    private String accountType;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;


}
