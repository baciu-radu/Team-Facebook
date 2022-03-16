package com.facebook.ui;

import com.facebook.controllers.LoginController;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class LoginUI extends UI {

    public void showLoginUI() throws IOException, InterruptedException, AWTException {

        LoadingUI loadingUI = new LoadingUI();
        UI ui = new LoginUI();
        LoginController loginController = new LoginController();
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

        password = ui.getMaskedPassword("Enter password");

        System.out.println("Press Enter to Log In");
        System.in.read();

        loadingUI.popProgressBar();
    }


    @Override
    public void closeApplication() {

    }
}
