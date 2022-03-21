package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FindUser {
    public static void findPrintUser(int id) throws IOException {

        Path profileDetailsTable = Paths.get("src\\main\\resources", "ProfileDetailsTable.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        boolean found = false;
        while (found == false) {
            for (String line : lines) {
                userDetails = line.split(";");

                if (userDetails[0].equals(Integer.toString(id))) {
                    found = true;
                    System.out.println("Name = " + userDetails[3] + "\nAge = " + userDetails[4] + "\nSex = " + userDetails[5]);

                }
            }
        }
    }

    public static boolean findUser(String id) throws IOException {
        Path profileDetailsTable = Paths.get("src\\main\\resources", "FriendList.txt");
        List<String> lines = Files.readAllLines(profileDetailsTable);
        String[] userDetails;
        boolean found = false;

        for (String line : lines) {
            userDetails = line.split(";");

            if (userDetails[0].equals(id)) {
                found = true;

            }
        }

        return found;

    }
}
