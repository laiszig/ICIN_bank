package com.laiszig.icin_bank_service.controller;

import com.laiszig.icin_bank_service.entity.Checkbook;
import com.laiszig.icin_bank_service.entity.Status;
import com.laiszig.icin_bank_service.service.CheckbookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckbookController {

    private final CheckbookService checkbookService;

    public CheckbookController(CheckbookService checkbookService) {
        this.checkbookService = checkbookService;
    }

    @GetMapping("/checkbook")
    public List<Checkbook> getAll(){
        return checkbookService.getAllCheckbookRequests();
    }

    @PutMapping("/checkbook/approve/{id}")
    public ResponseEntity<Checkbook> approveCheckbookStatus(@PathVariable Long id) {
        Checkbook updatedCheckbook = checkbookService.approveStatus(id);
        return ResponseEntity.ok(updatedCheckbook);
    }

    @PutMapping("/checkbook/deny/{id}")
    public ResponseEntity<Checkbook> denyCheckbookStatus(@PathVariable Long id) {
        Checkbook updatedCheckbook = checkbookService.denyStatus(id);
        return ResponseEntity.ok(updatedCheckbook);
    }

    @PostMapping("/checkbook")
    public ResponseEntity<Checkbook> createCheckbook(
            @RequestParam(name = "accountId") Long accountId) {
        Checkbook createdCheckbook = checkbookService.createCheckbookRequest(accountId);
        return ResponseEntity.ok(createdCheckbook);
    }

}
