package com.facebook.model;

public class User {

    private static int newID = 1;
    private int id;
    private String emailAddress;
    private String password;

    public User (String emailAddress, String password) {
        this.id = newID++;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public static int getNewID() {
        return newID;
    }

    public int getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public static void setNewID(int newID) {
        User.newID = newID;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
