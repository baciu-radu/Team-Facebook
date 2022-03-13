package com.facebook.model;

public class User {

    private static long newID = 0;
    private long id;
    private String emailAddress;
    private String password;

    public User (String emailAddress, String password) {
        this.id = newID++;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }


}
