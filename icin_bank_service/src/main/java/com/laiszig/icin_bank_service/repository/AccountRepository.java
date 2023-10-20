package com.laiszig.icin_bank_service.repository;

import com.laiszig.icin_bank_service.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findAccountByAccountNumber(Long accountNumber);
}
