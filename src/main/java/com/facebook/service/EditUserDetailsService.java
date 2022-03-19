package com.facebook.service;

import com.facebook.dao.StoreEditedAccountData;
import com.facebook.model.User;
import com.facebook.model.UserDetails;

import java.io.IOException;

public class EditUserDetailsService {
    public static void editAccount(UserDetails userDetails) throws IOException {

        StoreEditedAccountData storeEditedAccountData = new StoreEditedAccountData();
        storeEditedAccountData.writeCurrentUserDataToDatabase(userDetails);
    }
}
