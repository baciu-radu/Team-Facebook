package com.facebook.dao;

import com.facebook.model.UserDetails;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StoreFriendList {
    public void writeFriendIDToList(int id) throws IOException {

        Path frientListTablePath = Paths.get("src\\main\\resources", "FriendList.txt");


        Files.write(frientListTablePath, (id + "\n").getBytes(), StandardOpenOption.APPEND);
        Files.write(frientListTablePath,(";").getBytes(), StandardOpenOption.WRITE);

    }
    public void writeCreateUserDataToDatabase (UserDetails userDetails) throws IOException {
        Path profileDetailsTablePath = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        Files.write(profileDetailsTablePath, (userDetails.getId() + "; " + userDetails.getEmailAddress() + "; " + userDetails.getPassword() + "; " + UserDetails.getName() + "; " + "Age Not Assigned" + "; " + "Sex Not Assigned"+ "\n").getBytes(), StandardOpenOption.APPEND);
    }

}
