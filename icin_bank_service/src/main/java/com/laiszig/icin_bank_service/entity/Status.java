package com.laiszig.icin_bank_service.entity;

import lombok.Getter;

@Getter
public enum Status {

    OPEN("OPEN"),
    CLOSED("CLOSED");

    private final String description;

    Status(String description) {
        this.description = description;
    }

}
