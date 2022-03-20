package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PasswordChecker {

    public boolean checkPasswordExists (String password) throws IOException {

        List<String> listOfPasswords;
        listOfPasswords = Files.readAllLines(Paths.get("src\\main\\resources", "UsersTable.txt"));
        String[] passwords = listOfPasswords.toArray(new String[0]);
        String[] passwordElements;

        for (String pass : passwords) {

            passwordElements = pass.split("; ");

            if (passwordElements[2].equals(password)) {
                return true;
            }
        }

        return false;
    }
}
