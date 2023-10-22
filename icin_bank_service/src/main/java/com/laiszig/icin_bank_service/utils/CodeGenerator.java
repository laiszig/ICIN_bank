package com.laiszig.icin_bank_service.utils;

import com.mifmif.common.regex.Generex;

import java.util.regex.Pattern;

public class CodeGenerator {

    public static final String SORT_CODE_PATTERN_STRING = "[0-9]{2}-[0-9]{2}-[0-9]{2}";

    public static final String ACCOUNT_NUMBER_PATTERN_STRING = "[0-9]{8}";
//    public static final Pattern SORT_CODE_PATTERN = Pattern.compile("^[0-9]{2}-[0-9]{2}-[0-9]{2}$");
//    public static final Pattern ACCOUNT_NUMBER_PATTERN = Pattern.compile("^[0-9]{8}$");

    Generex sortCodeGenerex = new Generex(SORT_CODE_PATTERN_STRING);
    Generex accountNumberGenerex = new Generex(ACCOUNT_NUMBER_PATTERN_STRING);

    public CodeGenerator(){}

//    public String generateSortCode() {
//        return sortCodeGenerex.random();
//    }

    public String generateAccountNumber() {
        return accountNumberGenerex.random();
    }

}
