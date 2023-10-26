package com.laiszig.icin_bank_service.repository;

import com.laiszig.icin_bank_service.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
