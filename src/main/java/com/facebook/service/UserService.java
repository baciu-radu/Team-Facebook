package com.facebook.service;

import com.facebook.dao.StoreNewAccountData;
import com.facebook.model.User;

import java.io.IOException;

public class UserService {

    public void createNewAccount (User user) throws IOException {

        StoreNewAccountData storeNewAccountData = new StoreNewAccountData();
        storeNewAccountData.writeNewUserDataToDatabase(user);
    }

}
