package com.laiszig.icin_bank_service.controller.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionRequest {

    private Long transactionId;

    private String sourceAccountNumber;

    private String targetAccountNumber;

    private String targetOwnerName;

    private Double amount;
}
