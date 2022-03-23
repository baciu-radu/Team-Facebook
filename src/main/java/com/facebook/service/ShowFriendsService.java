package com.facebook.service;

import com.facebook.dao.ReadFriends;

import java.io.IOException;

public class ShowFriendsService {
    public void showFriends() throws IOException {
        ReadFriends readFriends = new ReadFriends();
        readFriends.readFriends();
    }
}
