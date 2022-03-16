package com.facebook.dao;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AccountChecker {

    public boolean checkAccountExists (String email) throws IOException {

        List<String> listOfAccounts;
        listOfAccounts = Files.readAllLines(Paths.get("src\\main\\resources", "UsersTable.txt"));
        String[] accounts = listOfAccounts.toArray(new String[0]);
        String[] accountElements;

        for (String account : accounts) {

                accountElements = account.split("; ");

                if (accountElements[1].equals(email)) {
                    return true;
                }
        }

        return false;
    }

}
