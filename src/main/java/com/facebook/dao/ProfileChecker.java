package com.facebook.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProfileChecker {


        public boolean checkProfileExists (String id) throws IOException {

            List<String> listOfProfiles;
            listOfProfiles = Files.readAllLines(Paths.get("src\\main\\resources", "ProfileDetailsTable.txt"));
            String[] profiles = listOfProfiles.toArray(new String[0]);
            String[] profileElements;


            for (String profile : profiles) {

                profileElements = profile.split(";");

                if (profileElements[0].equals(id)) {

                    return true;
                }
            }

            return false;
        }

    }

