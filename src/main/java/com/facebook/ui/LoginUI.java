package com.facebook.ui;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class LoginUI extends UI {

    public void showLoginUI() throws IOException, InterruptedException, AWTException {

        LoadingUI loadingUI = new LoadingUI();
        UI ui = new LoginUI();
        Scanner in = new Scanner(System.in);
        String user = "";
        String password = "";

        loadingUI.popProgressBar();

        System.out.println("Enter email address:");
        user = in.nextLine();
        password = ui.getMaskedPassword("Enter password");

        System.out.println("Press Enter to Log In");
        System.in.read();

        loadingUI.popProgressBar();
    }


    @Override
    public void closeApplication() {

    }
}
