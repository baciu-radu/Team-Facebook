package com.facebook.model;

import java.nio.file.Path;
import java.nio.file.Paths;

public class User implements GenericEntity {

    static Path path = Paths.get("src\\main\\resources", "UsersTable.txt");
    private static final String USER_REPOSITORY_PATH = String.valueOf(path);
    private static int newID = 1;
    private int id;
    private String email;
    private String password;

    public User () {
    }

    public User(String email, String password) {
        this.id = newID++;
        this.email = email;
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
        return String.format("%s;%s;%s", id, email, password.hashCode());
    }

    @Override
    public String getStoragePath() {
        return USER_REPOSITORY_PATH;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + com.facebook.model.User.this.id +
                ", email='" + email + '\'' +
                '}';
    }
}
