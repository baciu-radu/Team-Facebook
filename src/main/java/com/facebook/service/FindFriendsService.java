package com.facebook.service;

import com.facebook.dao.AddFriend;
import com.facebook.dao.GetLastUserID;
import com.facebook.model.UniqueRandomAccounts;


import java.io.IOException;
import java.util.Scanner;

public class FindFriendsService {
    public void findFriends() throws IOException {
        AddFriendService addFriendService = new AddFriendService();
        UniqueRandomAccounts.randomGenerator(GetLastUserID.getLastUserID());
        System.out.println("\n Type the User No. of the person you want to Add as Friend");
        addFriendService.addFriend();

    }

}
