package com.facebook.dao;

import com.facebook.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreNewAccountData {

    public void writeNewUserDataToDatabase (User user) throws IOException {

        Path usersTablePath = Paths.get("src\\main\\resources", "UsersTable.txt");
        Path lastUserIDTable = Paths.get("src\\main\\resources", "LastUserIDTable.txt");
        String lastUserIDText = Files.readString(lastUserIDTable);

        if ("".equals(lastUserIDText)) {

        }
        else {
            int lastUserID = Integer.parseInt(lastUserIDText);
            lastUserID++;
            user.setId(lastUserID);
        }

        Files.write(usersTablePath, (user.getId() + ";" + user.getEmailAddress() + ";" + user.getPassword() + "\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(lastUserIDTable, String.valueOf(user.getId()).getBytes());


    }

}
