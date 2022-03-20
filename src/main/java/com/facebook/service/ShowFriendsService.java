package com.facebook.service;

import com.facebook.dao.ReadFriends;

import java.io.IOException;

public class ShowFriendsService {
    public static void showFriends() throws IOException {
        ReadFriends.readFriends();
    }
}
