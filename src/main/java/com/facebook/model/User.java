package com.facebook.model;

public class User {

    private static long newID = 1;
    private long id;
    private String emailAddress;
    private String password;

    public User (String emailAddress, String password) {
        this.id = newID++;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public static long getNewID() {
        return newID;
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

    public static void setNewID(long newID) {
        User.newID = newID;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
