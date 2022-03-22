package com.facebook.ui;

import com.facebook.controllers.Numeric;
import com.facebook.controllers.SexType;
import com.facebook.model.ModifyProfile;
import com.facebook.model.ProfileDetails;
import com.facebook.model.UserDetails;
import com.facebook.service.EditUserDetailsService;
import com.facebook.service.EnterProfileDetailsService;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EditProfileUI extends MyProfileUI {
    public static void showEditProfileUI() throws IOException {
        LoadingUI loadingUI = new LoadingUI();
        UI ui = new EditProfileUI();
        EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "facebook - Edit Profile" +
                "\n" +
                "\n" + "\t\t\t\t" + "x - Exit" +
                "\n" + "\t\t\t\t" + "1 - Name" +
                "\n" + "\t\t\t\t" + "2 - Age" +
                "\n" + "\t\t\t\t" + "3 - Sex" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        System.out.println("-------------What do you want to edit?-------------");
        String option = "";
        while (option != "0") {

            option = in.next();

            switch (option) {

                case "x":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Name");

                    EnterProfileDetailsService.enterProfileName();
                    EnterProfileDetailsService.getNewName();
                    System.out.println("Old name was: " + ProfileDetails.getOldName());
                    ModifyProfile.modifyProfile(ProfileDetails.getOldName(),EnterProfileDetailsService.getNewName());
                    System.out.println("New name is: " + EnterProfileDetailsService.getNewName());
                    MyProfileUI.showMyProfileUI();
                    break;
                case "2":
                    System.out.println("Age");

                    EnterProfileDetailsService.enterProfileAge();
                    EnterProfileDetailsService.getNewAge();
                    System.out.println("Old age was: " + ProfileDetails.getOldAge());
                    ModifyProfile.modifyProfile(ProfileDetails.getOldAge(),EnterProfileDetailsService.getNewAge());
                    System.out.println("New age is: " + EnterProfileDetailsService.getNewAge());
                    MyProfileUI.showMyProfileUI();

                    break;
                case "3":
                    System.out.println("Sex");

                    EnterProfileDetailsService.enterProfileSex();
                    EnterProfileDetailsService.getNewSex();
                    System.out.println("Old sex was: " + ProfileDetails.getOldSex());
                    ModifyProfile.modifyProfile(ProfileDetails.getOldSex(),EnterProfileDetailsService.getNewSex());
                    System.out.println("New sex is: " + EnterProfileDetailsService.getNewSex());
                    MyProfileUI.showMyProfileUI();
                    break;
                default:
                    System.err.println("Invalid option");
            }

        }

    }
}
