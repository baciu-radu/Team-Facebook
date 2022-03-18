package com.facebook.model;

public class UserDetails {

    private int id;
    private String emailAddress;
    private String password;
    private String name;
    private String age;
    private String sex;
    //        String livesIn = "not assigned";
//        String fromTown = "not assigned";
//        String worksAt = "not assigned";
//        String studies = "not assigned";
//        String relationshipStatus = "not assigned";
    private int friendsNo;


    public UserDetails(String name, String age, String sex) {
        this.id = User.getId();
        this.emailAddress = User.getEmailAddress();
        this.password = User.getPassword();
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.friendsNo = friendsNo;
    }

//    public UserDetails(String name, String age, String sex) {
//    }


    public int getId() {
        return id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPassword() {
        return password;
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

    public String getName() {        return name;    }

    public String getAge() {        return age;    }

    public String getSex() {        return sex;    }

    public int getFriendsNo() {        return friendsNo;    }

    public void setName(String name) {        this.name = name;    }

    public void setAge(String age) {        this.age = age;    }

    public void setSex(String sex) {        this.sex = sex;    }

    public void setFriendsNo(int friendsNo) {        this.friendsNo = friendsNo;    }
}
