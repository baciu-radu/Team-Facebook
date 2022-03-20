package com.facebook.model;

import com.facebook.dao.GetCurrentUserID;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GetOldFriendList {
    private static String oldFriendList;
    public static String getOldFriendList() throws IOException {
        String id = GetCurrentUserID.getCurrentUserID();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "FriendList.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(id)) {
                oldFriendList= line;
//                System.out.println(oldFriendList);

            }
        }


        return oldFriendList;
    }
}
