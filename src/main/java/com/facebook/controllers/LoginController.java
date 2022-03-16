package com.facebook.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {

    public boolean validateAccount (String account) {

        Pattern accountPattern = Pattern.compile("\\S+@\\w+\\.\\w+");
        Matcher accountMatcher = accountPattern.matcher(account);

        return accountMatcher.matches();
    }


}
