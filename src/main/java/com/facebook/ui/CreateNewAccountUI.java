package com.facebook.ui;

import com.facebook.dao.StoreEditedAccountData;
import com.facebook.model.User;
import com.facebook.model.UserDetails;
import com.facebook.service.CurrentUserService;
import com.facebook.service.EditUserDetailsService;
import com.facebook.service.UserService;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CreateNewAccountUI extends UI {

    public void showCreateNewAccountUI () throws IOException, InterruptedException, AWTException {

        LoadingUI loadingUI = new LoadingUI();
        UI ui = new CreateNewAccountUI();
        UserService userService = new UserService();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);
        StoreEditedAccountData storeEditedAccountData = new StoreEditedAccountData();



        String emailAddress = "";
        String newPassword = "";

        loadingUI.popProgressBar();



        System.out.println("Enter email address:");
        emailAddress = in.nextLine();

        newPassword = ui.getMaskedPassword("Enter password");

        System.out.println("Press Enter to Sign Up");
        System.in.read();

        loadingUI.popProgressBar();
        userService.createNewAccount(new User(emailAddress, newPassword));

        System.out.println("Account successfully created!");
        /**radu Code
         *
         */
        EditUserDetailsService.editAccount(new UserDetails("Name Not Assigned"," Age Not Assigned","Sex Not Assigned"));
        /**radu Code
         *
         */
        TimeUnit.MILLISECONDS.sleep(2000);

        loadingUI.popProgressBar();

        MyProfileUI.showMyProfileUI();
    }

    @Override
    public void closeApplication() {

    }
}
