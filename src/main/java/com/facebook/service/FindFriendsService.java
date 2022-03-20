package com.facebook.service;

import com.facebook.dao.GetLastUserID;
import com.facebook.model.UniqueRandomAccounts;


import java.io.IOException;

public class FindFriendsService {
    public static void findFriends() throws IOException {
        UniqueRandomAccounts.randomGenerator(GetLastUserID.getLastUserID());

    }

}
