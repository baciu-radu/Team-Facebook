package com.facebook.ui;

import com.facebook.model.ModifyProfile;
import com.facebook.model.ProfileDetails;
import com.facebook.service.EnterProfileDetailsService;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EditProfileUI extends UI {
    public void showEditProfileUI() throws IOException, InterruptedException, AWTException {
        UI ui = new EditProfileUI();
        LoadingUI loadingUI = new LoadingUI();
        HomeUI homeUI = new HomeUI();
        ProfileDetails profileDetails = new ProfileDetails();
        EnterProfileDetailsService enterProfileDetailsService = new EnterProfileDetailsService();

        Scanner in = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "facebook - Edit Profile" +
                "\n" +
                "\n" + "\t\t\t\t" + "1 - Name" +
                "\n" + "\t\t\t\t" + "2 - Age" +
                "\n" + "\t\t\t\t" + "3 - Sex" +
                "\n" + "\t\t\t\t" + "-1 - Back to Home Page" +
                "\n" + "\t\t\t\t" + "x - Close" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        System.out.println("-------------What do you want to edit?-------------");
        String option = "";
        while (option != "0") {

            option = in.next();

            switch (option) {

                case "1":
                    System.out.println("Name");

                    enterProfileDetailsService.enterProfileName();
                    enterProfileDetailsService.getNewName();
                    System.out.println("Old name was: " + profileDetails.getOldName());
                    ModifyProfile.modifyProfile(profileDetails.getOldName(),enterProfileDetailsService.getNewName());
                    System.out.println("New name is: " + enterProfileDetailsService.getNewName());
                    System.out.println("---------------------------------------------------" + "\n" + "Press Enter to return to Home Page");
                    System.in.read();
                    loadingUI.popProgressBar();
                    homeUI.showHomeUI();
                    break;
                case "2":
                    System.out.println("Age");

                    enterProfileDetailsService.enterProfileAge();
                    enterProfileDetailsService.getNewAge();
                    System.out.println("Old age was: " + profileDetails.getOldAge());
                    ModifyProfile.modifyProfile(profileDetails.getOldAge(),enterProfileDetailsService.getNewAge());
                    System.out.println("New age is: " + enterProfileDetailsService.getNewAge());
                    System.out.println("---------------------------------------------------" + "\n" + "Press Enter to return to Home Page");
                    System.in.read();
                    loadingUI.popProgressBar();
                    homeUI.showHomeUI();
                    break;
                case "3":
                    System.out.println("Sex");

                    enterProfileDetailsService.enterProfileSex();
                    enterProfileDetailsService.getNewSex();
                    System.out.println("Old sex was: " + profileDetails.getOldSex());
                    ModifyProfile.modifyProfile(profileDetails.getOldSex(),enterProfileDetailsService.getNewSex());
                    System.out.println("New sex is: " + enterProfileDetailsService.getNewSex());
                    System.out.println("---------------------------------------------------" + "\n" + "Press Enter to return to Home Page");
                    System.in.read();
                    loadingUI.popProgressBar();
                    homeUI.showHomeUI();
                    break;
                case "-1":
                    loadingUI.popProgressBar();
                    homeUI.showHomeUI();
                    break;
                case "x":
                    ui.closeApplication();
                    break;
                default:
                    System.err.println("Invalid option");
            }

        }

    }

    @Override
    public void closeApplication() {
        System.out.println("Closing application.");
        System.exit(0);
    }
}
