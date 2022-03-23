package com.facebook.dao;

import com.facebook.controllers.FindUser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFriends {
    public void readFriends() throws IOException {
        GetCurrentUserID getCurrentUserID = new GetCurrentUserID();
        String id = getCurrentUserID.getCurrentUserID();
        FindUser findUser = new FindUser();
        if (findUser.findUser(String.valueOf(id)) == true) {
            Path friendList = Paths.get("src\\main\\resources", "FriendList.txt");
            List<String> lines = Files.readAllLines(friendList);
            String[] friend;
            for (String line : lines) {
                friend = line.split(";");
                for (int i = 1; i < friend.length; i++) {
                    if (friend[0].equals(id)) {
                        System.out.println( "-----------------------------\n"+"Friend No. :"+ Integer.parseInt(friend[i]));
                        findUser.findPrintUser(friend[i]);
                    }


                }
            }
        }
    }
}
