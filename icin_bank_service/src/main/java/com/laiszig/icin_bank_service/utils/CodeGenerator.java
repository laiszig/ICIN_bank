package com.laiszig.icin_bank_service.utils;

import com.mifmif.common.regex.Generex;

import java.util.regex.Pattern;

public class CodeGenerator {

    public static final String ACCOUNT_NUMBER_PATTERN_STRING = "[0-9]{8}";

    Generex accountNumberGenerex = new Generex(ACCOUNT_NUMBER_PATTERN_STRING);

    public CodeGenerator(){}

    public String generateAccountNumber() {
        return accountNumberGenerex.random();
    }

}
