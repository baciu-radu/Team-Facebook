package com.facebook.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProfileDetails {
    private String emailAddress;
    private String password;
    private String name;
    private String age;
    private String sex;
    private static String oldName;
    private static String oldAge;
    private static String oldSex;
//    private int friendsNo;

    public static String getOldName() throws IOException {
        int id = User.getId();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(Integer.toString(id))) {
//                System.out.println("Name successfully updated");
              oldName= userDetails[3];

            }
        }


    return oldName;
    }

    public static String getOldAge() throws IOException {
        int id = User.getId();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(Integer.toString(id))) {
//                System.out.println("Name successfully updated");
                oldAge= userDetails[4];

            }
        }
    return oldAge;
    }
    public static String getOldSex() throws IOException {
        int id = User.getId();
        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        for (String line : lines) {
            userDetails = line.split(";");
            if (userDetails[0].equals(Integer.toString(id))) {
//                System.out.println("Name successfully updated");
                oldSex= userDetails[4];

            }
        }
        return oldSex;
    }
}
