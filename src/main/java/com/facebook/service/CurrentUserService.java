package com.facebook.service;

import com.facebook.dao.StoreEditedAccountData;
import com.facebook.dao.StoreNewAccountData;
import com.facebook.model.User;

import java.io.IOException;

public class CurrentUserService {
    public void getAccount (User user) throws IOException {

        StoreEditedAccountData storeEditedAccountData = new StoreEditedAccountData();
        storeEditedAccountData.writeNewUserDataToDatabase(user);
    }
}
