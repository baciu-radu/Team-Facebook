package com.facebook.service;

import com.facebook.model.User;

public class UserService {

    public void createNewAccount (User user) {

        long id = user.getId();
        String emailAddress = user.getEmailAddress();
        String password = user.getPassword();

        System.out.println(id + "; " + emailAddress + "; " + password);

    }

}
