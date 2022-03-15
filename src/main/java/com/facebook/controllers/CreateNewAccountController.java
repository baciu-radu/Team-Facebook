package com.facebook.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateNewAccountController {

    public boolean validateAccount (String account) {

        Pattern accountPattern = Pattern.compile("\\S+@\\w+\\.\\w+");
        Matcher accountMatcher = accountPattern.matcher(account);

        return accountMatcher.matches();
    }

    public boolean validatePassword (String password) {
        Pattern passwordPattern = Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*_+-]).{8,20}$");
        Matcher passwordMatcher = passwordPattern.matcher(password);

        return passwordMatcher.matches();
    }





}
