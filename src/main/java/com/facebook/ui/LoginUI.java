package com.facebook.ui;

import com.facebook.controllers.LoginController;
import com.facebook.dao.AccountChecker;
import com.facebook.dao.PasswordChecker;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LoginUI extends UI {

    public void showLoginUI() throws IOException, InterruptedException, AWTException {

        LoadingUI loadingUI = new LoadingUI();
        UI ui = new LoginUI();
        LoginController loginController = new LoginController();
        AccountChecker accountChecker = new AccountChecker();
        PasswordChecker passwordChecker = new PasswordChecker();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);
        String user = "";
        String password = "";

        loadingUI.popProgressBar();

        System.out.println("Enter email address:");
        user = in.nextLine();
        boolean isUserValid = loginController.validateAccount(user);

        while (!isUserValid) {
            System.out.println("Wrong email format. Please provide a valid email address!");
            user = in.nextLine();
            isUserValid = loginController.validateAccount(user);
        }

        int retryAccountCounter = 2;
        boolean isAlreadyExists = accountChecker.checkAccountExists(user);

        while (!isAlreadyExists) {

            isUserValid = loginController.validateAccount(user);

            while (!isUserValid) {
                System.out.println("Wrong email format. Please provide a valid email address!");
                user = in.nextLine();
                isUserValid = loginController.validateAccount(user);
            }

            System.out.println("Account does not exist. Please check your spelling and try again! Retries left: " + retryAccountCounter);
            if (retryAccountCounter != 0) {
                retryAccountCounter--;
                user = in.nextLine();
                isAlreadyExists = accountChecker.checkAccountExists(user);
            }
            else {
                loadingUI.popProgressBar();
                System.out.println("Account does not exist." +
                        "\n" + "\u23F3 Returning to Main Page...");
                TimeUnit.MILLISECONDS.sleep(3000);
                loadingUI.popProgressBar();
                mainUI.showMainUI();
            }

        }

        password = ui.getMaskedPassword("Enter password");

        int retryPasswordCounter = 2;
        boolean isPassword = passwordChecker.checkPasswordExists(password);

        while (!isPassword) {
            System.out.println("Incorrect password. Please try again! Retries left: " + retryPasswordCounter);
            if (retryPasswordCounter != 0) {
                retryPasswordCounter--;
                password = ui.getMaskedPassword("Enter password");
                isPassword = passwordChecker.checkPasswordExists(password);
            }
            else {
                loadingUI.popProgressBar();
                System.out.println("Incorrect password. Password limit exceeded." +
                        "\n" + "\u23F3 Closing application...");
                TimeUnit.MILLISECONDS.sleep(3000);
                loadingUI.popProgressBar();
                ui.closeApplication();
            }
        }

        System.out.println("Press Enter to Log In");
        System.in.read();

        loadingUI.popProgressBar();
    }


    @Override
    public void closeApplication() {
        System.exit(0);
    }
}
