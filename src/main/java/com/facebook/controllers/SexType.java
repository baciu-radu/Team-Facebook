package com.facebook.controllers;

public enum SexType {
    MALE("male"), FEMALE("female");

    String sex;

    SexType(String sex) {

        this.sex = sex;
    }
    public static SexType fromString(String sex) {
        SexType foundType = null;
        for(SexType t: SexType.values()) {
            if(t.getSex().equals(sex)) {
                foundType = t;
            }
        }
        if(foundType != null) {
            return foundType;
        } else {
            System.out.println("Invalid sex. Valid options are: [male, female]" );
            return null;
        }
    }


    public String getSex() {
        return sex;
    }
}
