package com.facebook.model;

import com.facebook.dao.GetCurrentUserID;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProfileDetails {
    GetCurrentUserID getCurrentUserID = new GetCurrentUserID();
    private String emailAddress;
    private String password;
    private String name;
    private String age;
    private String sex;
    private static String oldName;
    private static String oldAge;
    private static String oldSex;
//    private int friendsNo;

    public String getOldName() throws IOException {

        String id = getCurrentUserID.getCurrentUserID();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
//            if (userDetails[0].equals(Integer.toString(id))) {
            if (userDetails[0].equals(id)) {
              oldName= userDetails[3];

            }
        }


    return oldName;
    }

    public  String getOldAge() throws IOException {
        String id = getCurrentUserID.getCurrentUserID();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(id)) {
                oldAge= userDetails[4];

            }
        }
    return oldAge;
    }
    public  String getOldSex() throws IOException {
        String id = getCurrentUserID.getCurrentUserID();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(id)) {
                oldSex= userDetails[5];

            }
        }
        return oldSex;
    }
}
