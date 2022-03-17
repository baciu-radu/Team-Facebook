package com.facebook.dao;

import com.facebook.model.User;
import com.facebook.model.UserDetails;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreEditedAccountData extends StoreNewAccountData {

    public void writeCurrentUserDataToDatabase(UserDetails userDetails) throws IOException {

        Path profileDetailsTablePath = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        Path idTablePath = Paths.get("src\\main\\resources", "CurrentUserIDTable.txt");
        String currentUserIDText = Files.readString(idTablePath);

        Files.write(idTablePath, (userDetails.getId() + "; " + userDetails.getEmailAddress() + "; " + userDetails.getPassword() + "; " + userDetails.getName() + "; " + userDetails.getAge() + "; " + userDetails.getSex()+ "\n").getBytes(), StandardOpenOption.APPEND);


    }


}
