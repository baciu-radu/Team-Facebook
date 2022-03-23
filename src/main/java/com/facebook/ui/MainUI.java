package com.facebook.ui;

import java.awt.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainUI extends UI {

    public void showMainUI () throws AWTException, InterruptedException, IOException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        LoginUI loginUI = new LoginUI();
        CreateNewAccountUI createNewAccountUI = new CreateNewAccountUI();
        UI ui = new MainUI();
        Scanner in = new Scanner(System.in);
        String option = "";

        System.out.println("---------------------------------------------------" +
                "\n" + "facebook" +
                "\n" +
                "\n" + "\t\t\t\t" + "1 - Log In" +
                "\n" + "\t\t\t\t" + "2 - Create new account" +
                "\n" + "\t\t\t\t" + "x - Close" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );

        System.out.println("Select an option (1, 2, x):");

        while (option != "x") {

            option = in.nextLine();

            switch (option) {

                case "1":
                    loginUI.showLoginUI();
                    break;
                case "2":
                    createNewAccountUI.showCreateNewAccountUI();
                    break;
                case "x":
                    ui.closeApplication();
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
