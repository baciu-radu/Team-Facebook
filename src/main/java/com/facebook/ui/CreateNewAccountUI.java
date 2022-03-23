package com.facebook.ui;


import com.facebook.controllers.CreateNewAccountController;
import com.facebook.dao.AccountChecker;
import com.facebook.model.User;
import com.facebook.model.UserDetails;
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
        CreateNewAccountController createNewAccountController = new CreateNewAccountController();
        AccountChecker accountChecker = new AccountChecker();
        EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
        Scanner in = new Scanner(System.in);
        User user = new User();
        String emailAddress = "";
        String newPassword = "";

        loadingUI.popProgressBar();

        System.out.println("Enter email address:");
        emailAddress = in.nextLine();

        boolean isAccountValid = createNewAccountController.validateAccount(emailAddress);

        while (!isAccountValid) {
            System.out.println("Wrong email format. Please provide a valid email address!");
            emailAddress = in.nextLine();
            isAccountValid = createNewAccountController.validateAccount(emailAddress);
        }

        boolean isAlreadyExists = accountChecker.checkAccountExists(emailAddress);

        while (isAlreadyExists) {
            System.out.println("Email address already in use. Please provide a new email address!");
            emailAddress = in.nextLine();
            isAlreadyExists = accountChecker.checkAccountExists(emailAddress);
        }

        newPassword = ui.getMaskedPassword("Enter password");

        boolean isPasswordValid = createNewAccountController.validatePassword(newPassword);

        while (!isPasswordValid) {
            System.out.println("Wrong password format." +
                    "\n" + "The password length must be between 8 - 20 characters and must contain at least 1 capital letter, 1 number and 1 special character.");
            newPassword = ui.getMaskedPassword("Enter password");
            isPasswordValid = createNewAccountController.validatePassword(newPassword);
        }

        System.out.println("Press Enter to Sign Up");
        System.in.read();

        loadingUI.popProgressBar();
        userService.createNewAccount(new User(emailAddress, newPassword));

        System.out.println("Account successfully created!");
        TimeUnit.MILLISECONDS.sleep(2000);
        editUserDetailsService.editAccount(new UserDetails(user.getId() + "- Name Not Assigned",user.getId() + "- Age Not Assigned", user.getId() + "- Sex Not Assigned"));

        loadingUI.popProgressBar();
        mainUI.showMainUI();
    }

    @Override
    public void closeApplication() {

    }
}
