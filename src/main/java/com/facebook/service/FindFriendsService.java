package com.facebook.service;

import com.facebook.model.FindFriends;

public class FindFriendsService {
    public static void getFriends() {
        for (int i = 0; i < 10; i++) {
            int randomID = FindFriends.getRandomID(40, 50);
            System.out.println("Random ID is:" + randomID);
        }


    }
}
