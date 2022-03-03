package com.facebook.user;

import com.facebook.generic.GenericEntity;

public class User implements GenericEntity {

    private static final String USER_REPOSITORY = "users.txt";
    private int user_id;
    private String email;
    private String password;

    public User(int user_id, String email, String password) {
        this.user_id = user_id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return user_id;
    }

    public void setId(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toDataBaseFormat() {
        return String.format("%s;%s;%s", user_id, email, password.hashCode());
    }

    @Override
    public String getStoragePath() {
        return USER_REPOSITORY;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", email='" + email + '\'' +
                '}';
    }
}
