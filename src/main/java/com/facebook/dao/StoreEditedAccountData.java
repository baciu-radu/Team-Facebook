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

        Files.write(profileDetailsTablePath, (userDetails.getId() + "; " + userDetails.getEmailAddress() + "; " + userDetails.getPassword() + "; " + userDetails.getName() + "; " + userDetails.getAge() + "; " + userDetails.getSex()+ "\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(idTablePath, (userDetails.getId()+";").getBytes(), StandardOpenOption.WRITE);

    }
    public void writeCreateUserDataToDatabase (UserDetails userDetails) throws IOException {
        Path profileDetailsTablePath = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        Files.write(profileDetailsTablePath, (userDetails.getId() + "; " + userDetails.getEmailAddress() + "; " + userDetails.getPassword() + "; " + UserDetails.getName() + "; " + "Age Not Assigned" + "; " + "Sex Not Assigned"+ "\n").getBytes(), StandardOpenOption.APPEND);
    }


}
