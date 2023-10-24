package com.laiszig.icin_bank_service.repository;

import com.laiszig.icin_bank_service.entity.Checkbook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckbookRepository extends JpaRepository<Checkbook, Long> {
}
