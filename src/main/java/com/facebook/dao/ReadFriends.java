package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFriends {
    public static void readFriends() throws IOException {
        String id = GetCurrentUserID.getCurrentUserID();
        if (FindUser.findUser(String.valueOf(id)) == true) {
            Path friendList = Paths.get("src\\main\\resources", "FriendList.txt");
            List<String> lines = Files.readAllLines(friendList);
            String[] friend;
            for (String line : lines) {
                friend = line.split(";");
                for (int i = 1; i < friend.length; i++) {
                    if (friend[0].equals(id)) {
                        System.out.println( "-----------------------------\n"+"Friend No. :"+ Integer.parseInt(friend[i]));
                        FindUser.findPrintUser(Integer.parseInt(friend[i]));
                    }


                }
            }
        }
    }
}
