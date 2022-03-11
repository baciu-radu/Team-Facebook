package com.facebook.model;

public class User {

    private String emailAddress;
    private String password;

    public void User (String emailAddress, String password) {
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }
}
