package com.facebook.ui;

import com.facebook.model.User;
import com.facebook.service.ShowProfileDetailsService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MyProfileUI extends UI {
    //    public static void main(String[] args) {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void showMyProfileUI() throws IOException {
//        Runtime.getRuntime().exec("cls");
        Scanner in = new Scanner(System.in);
        MyProfileUI myProfileUI = new MyProfileUI();
        System.out.println("---------------------------------------------------");
        ShowProfileDetailsService.showProfileDetails();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "Option - Menu" +
                "\n" +
                "\n" + "\t\t\t\t" + "0 - Exit" +
                "\n" + "\t\t\t\t" + "1 - Show Profile Details" +
                "\n" + "\t\t\t\t" + "2 - Edit Profile" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        String option = "Start";

        while (option != "0") {

            option = in.next();

            switch (option) {

                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Show Profile Details");
                    ShowProfileDetailsService.showProfileDetails();
                    break;
                case "2":
                    System.out.println("Edit Profile Details");
                    EditProfileUI.showEditProfileUI();
                    break;
                case "3":
                    System.out.println("Show Profile ID, email and password");
//                    StoreEditedAccountData.writeUserToDatabase(User user);
//                    CurrentUserService currentUserService = new CurrentUserService();
//                    currentUserService.getAccount(User user);
////                    user.getID();
                    break;
                default:
                    System.err.println("Invalid option");
            }

        }
    }



    @Override
    public void closeApplication() {

    }
}



