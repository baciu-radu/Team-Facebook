package com.facebook.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class User implements GenericEntity {

    static Path path = Paths.get("src\\main\\resources", "UsersTable.txt");
    private static final String USER_REPOSITORY_PATH = String.valueOf(path);
    private static int newID = 1;
    private int id;
    private String emailAddress;
    private String password;

    public User () {
    }

    public User(String emailAddress, String password) {
        this.id = newID++;
        this.emailAddress = emailAddress;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toDataBaseFormat() {
        return String.format("%s;%s;%s", id, emailAddress, password.hashCode());
    }

    @Override
    public String getStoragePath() {
        return USER_REPOSITORY_PATH;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + com.facebook.model.User.this.id +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
