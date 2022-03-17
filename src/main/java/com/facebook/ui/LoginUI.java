package com.facebook.ui;

import com.facebook.model.User;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
        /*
        Radu Code
         */
//        System.out.println("Successfully logged in. Taking you to your account");
//        Path idTablePath = Paths.get("src\\main\\resources", "CurrentUserIDTable.txt.txt");
//        String currentUserIDText = Files.readString(idTablePath);
//
//        Files.write(currentUserIDTable, String.valueOf(user.getId()).getBytes());
//        Path idTable =User.getNewID();
//        System.out.println(User.getNewID());
//
        MyProfileUI.showMyProfileUI();
        /*
        Radu Code
         */
    }


    @Override
    public void closeApplication() {

    }
}
