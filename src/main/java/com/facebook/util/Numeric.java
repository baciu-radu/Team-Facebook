package com.facebook.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Numeric {
    public static boolean isNumeric(String str) {
        Pattern p = Pattern.compile("\\d+");
        Matcher matcher = p.matcher(str);
        return matcher.matches();

    }

    public static void main(String[] args) {
        System.out.println(isNumeric("1000 ansdsa"));
    }
}

