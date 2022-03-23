package com.facebook.ui;

import com.facebook.service.FindFriendsService;
import com.facebook.service.ShowFriendsService;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HomeUI extends UI {

    public void showHomeUI() throws IOException, InterruptedException, AWTException {

        UI ui = new HomeUI();
        MyProfileUI myProfileUI = new MyProfileUI();
        FindFriendsService findFriendsService = new FindFriendsService();
        ShowFriendsService showFriendsService = new ShowFriendsService();
        EditProfileUI editProfileUI = new EditProfileUI();
        LoadingUI loadingUI = new LoadingUI();
        Scanner in = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "Option - Menu" +
                "\n" +
                "\n" + "\t\t\t\t" + "1 - News Feed" +
                "\n" + "\t\t\t\t" + "2 - My Profile" +
                "\n" + "\t\t\t\t" + "3 - Edit Profile" +
                "\n" + "\t\t\t\t" + "4 - Messenger" +
                "\n" + "\t\t\t\t" + "5 - Show Friends" +
                "\n" + "\t\t\t\t" + "6 - Find Friends" +
                "\n" + "\t\t\t\t" + "x - Close" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        String option = "Start";

        while (option != "x") {

            option = in.next();

            switch (option) {

                case "1":
                    System.out.println("News Feed");
                    break;
                case "2":
                    System.out.println("My Profile");
                    myProfileUI.showMyProfileUI();
                    System.out.println("---------------------------------------------------" + "\n" + "Press Enter to return to Home Page");
                    System.in.read();
                    loadingUI.popProgressBar();
                    showHomeUI();
                    break;
                case "3":
                    System.out.println("Edit Profile Details");
                    editProfileUI.showEditProfileUI();
                    break;
                case "4":
                    System.out.println("Messenger");
                    MessageUI.messages();
                    break;
                case "5":
                    System.out.println("Show Friends" +
                            "\n" +
                            "---------------------------------------------------" +
                            "\nYour Friend List" +
                            "\n---------------------------------------------------" +
                            "\n" +
                            "\n");
                    showFriendsService.showFriends();
                    System.out.println("Show Friends" +
                            "\n" +
                            "---------------------------------------------------" +
                            "\nEnd of Friend List" +
                            "\n---------------------------------------------------" +
                            "\n" +
                            "\n");
                    break;
                case "6":
                    System.out.println("Find Friends");
                    findFriendsService.findFriends();
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
