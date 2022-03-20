package com.facebook.dao;

import com.facebook.controllers.FindUser;
import com.facebook.model.GetOldFriendList;
import com.facebook.model.ModifyProfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AddFriend {
    public static void writeFriendToList(int friendToAdd) throws IOException {
        Path friendListTablePath = Paths.get("src\\main\\resources", "FriendList.txt");

        if (FindUser.findUser(GetCurrentUserID.getCurrentUserID()) == false) {
            String currentUserID = GetCurrentUserID.getCurrentUserID();
            Files.write(friendListTablePath, (currentUserID + ";" + friendToAdd + ";"+"\n").getBytes(), StandardOpenOption.APPEND);

        } else {
            String addFriend = GetOldFriendList.getOldFriendList() + Integer.toString(friendToAdd).concat(";");
//            String addFriend = friendToAdd.concat(";");
            ModifyProfile.modifyFriends(GetOldFriendList.getOldFriendList(), addFriend);

        }

    }
}