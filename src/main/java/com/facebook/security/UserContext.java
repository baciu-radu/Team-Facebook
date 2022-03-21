package com.facebook.security;

import com.facebook.model.User;

public class UserContext {

    private static User loggedInUser;

    public static void setLoggedInUser(User user) {

        loggedInUser = user;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void clear() {
        loggedInUser = null;
    }

}
