package com.facebook.service;

import com.facebook.dao.AddFriend;
import com.facebook.dao.GetLastUserID;
import com.facebook.model.UniqueRandomAccounts;


import java.io.IOException;
import java.util.Scanner;

public class FindFriendsService {
    public static void findFriends() throws IOException {
        UniqueRandomAccounts.randomGenerator(GetLastUserID.getLastUserID());
        System.out.println("\n Type the User No. of the person you want to Add as Friend");
        AddFriendService.addFriend();
//        Scanner in = new Scanner(System.in);
//        int friendToAdd = in.nextInt();
//        AddFriend.writeFriendToList(friendToAdd);
//        System.out.println("Friend Successfully Added To Your FriendList");

    }

}
