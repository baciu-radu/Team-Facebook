package com.facebook.generic;

public interface GenericEntity {

    int getId();

    void setId(int id);

    String toDataBaseFormat();

    String getStoragePath();

}
