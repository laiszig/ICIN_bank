package com.laiszig.icin_bank_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {

    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_account_id")
    private Account sourceAccount;

    @ManyToOne
    @JoinColumn(name = "target_account_id")
    private Account targetAccount;

    @ManyToOne
    @JoinColumn(name = "username")
    private User targetUsername;

    @Column(name = "amount")
    private Double amount;

    @Column(name = "initiation_date")
    private LocalDateTime initiationDate;

    @Column(name = "completion_date")
    private LocalDateTime completionDate;

}
