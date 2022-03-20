package com.facebook.service;

import com.facebook.dao.AddFriend;

import java.io.IOException;
import java.util.Scanner;

public class AddFriendService {
    public static void addFriend() throws IOException {
        Scanner in = new Scanner(System.in);
        int friendToAdd = in.nextInt();
//        String friendToAdd = in.nextLine();
        AddFriend.writeFriendToList(friendToAdd);
        System.out.println("Friend Successfully Added To Your FriendList");
    }
}
