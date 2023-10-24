package com.laiszig.icin_bank_service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "checkbook")
@NoArgsConstructor
@AllArgsConstructor
public class Checkbook {

    @Id
    @Column(name = "checkbook_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
}
