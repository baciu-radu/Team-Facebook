package com.facebook.model;

public interface GenericEntity {

    int getId();

    void setId(int id);

    String toDataBaseFormat();

    String getStoragePath();

}
