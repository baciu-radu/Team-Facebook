package com.facebook.dao;

import com.facebook.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreNewAccountData {

    public void writeNewUserDataToDatabase (User user) throws IOException {

        Path path = Paths.get("C:\\Users\\Adrian\\Desktop\\Java Assignments\\Team-Facebook\\src\\main\\java\\com\\facebook\\dao", "UsersTable.txt");
        Files.write(path, (user.getId() + "; " + user.getEmailAddress() + "; " + user.getPassword() + "\n").getBytes(), StandardOpenOption.APPEND);

    }


}
