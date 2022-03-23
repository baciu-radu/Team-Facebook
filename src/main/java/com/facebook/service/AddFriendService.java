package com.facebook.service;

import com.facebook.dao.AddFriend;

import java.io.IOException;
import java.util.Scanner;

public class AddFriendService {
    public void addFriend() throws IOException {

        AddFriend addFriend = new AddFriend();
        Scanner in = new Scanner(System.in);
        int friendToAdd = in.nextInt();
        addFriend.writeFriendToList(friendToAdd);
        System.out.println("Friend Successfully Added To Your FriendList");
    }
}
