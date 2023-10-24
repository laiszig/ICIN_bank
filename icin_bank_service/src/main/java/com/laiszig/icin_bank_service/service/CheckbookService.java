package com.laiszig.icin_bank_service.service;

import com.laiszig.icin_bank_service.entity.Account;
import com.laiszig.icin_bank_service.entity.Checkbook;
import com.laiszig.icin_bank_service.entity.Status;
import com.laiszig.icin_bank_service.entity.User;
import com.laiszig.icin_bank_service.repository.AccountRepository;
import com.laiszig.icin_bank_service.repository.CheckbookRepository;
import org.hibernate.annotations.Check;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Objects;

@Service
public class CheckbookService {

    private final CheckbookRepository checkbookRepository;
    private final AccountRepository accountRepository;

    public CheckbookService(CheckbookRepository checkbookRepository, AccountRepository accountRepository) {
        this.checkbookRepository = checkbookRepository;
        this.accountRepository = accountRepository;
    }

    public List<Checkbook> getAllCheckbookRequests(){
        return checkbookRepository.findAll();
    }

    public Checkbook approveStatus(Long checkId) {
        Checkbook checkbook = checkbookRepository.findById(checkId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + checkId));

        checkbook.setStatus(Status.APPROVED);

        return checkbookRepository.save(checkbook);
    }

    public Checkbook denyStatus(Long checkId) {
        Checkbook checkbook = checkbookRepository.findById(checkId)
                .orElseThrow(() -> new IllegalArgumentException("Ticket not found with ID: " + checkId));

        checkbook.setStatus(Status.DENIED);

        return checkbookRepository.save(checkbook);
    }

    public Checkbook createCheckbookRequest(Long accountId) {
        if (accountId == null) {
            throw new IllegalArgumentException("Account ID is required");
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new EntityNotFoundException("Account not found with ID: " + accountId));

        if (!Objects.equals(account.getAccountType(), "CHECKING")) {
            throw new IllegalArgumentException("Account type must be CHECKING");
        }

        Checkbook checkbook = new Checkbook();
        checkbook.setStatus(Status.OPEN);
        checkbook.setAccount(account);

        return checkbookRepository.save(checkbook);
    }


}
