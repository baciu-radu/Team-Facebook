package com.facebook.dao;

import com.facebook.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreEditedAccountData extends StoreNewAccountData {

    public void writeCurrentUserDataToDatabase(User user) throws IOException {

        Path idTablePath = Paths.get("src\\main\\resources", "CurrentUserIDTable.txt");
        String currentUserIDText = Files.readString(idTablePath);

        Files.write(idTablePath, (user.getId() + "; " + user.getEmailAddress() + "; " + user.getPassword() + "\n").getBytes(), StandardOpenOption.APPEND);


    }


}
