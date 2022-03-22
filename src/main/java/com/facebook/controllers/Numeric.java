package com.facebook.controllers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Numeric {
    public static boolean isNumeric(String str) {
        Pattern p = Pattern.compile("\\d+");
        Matcher matcher = p.matcher(str);
        return matcher.matches();

    }
}

