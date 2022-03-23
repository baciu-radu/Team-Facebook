package com.facebook;

<<<<<<< HEAD
import com.facebook.model.HomePage;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        HomePage homePage = new HomePage();
        homePage.newsFeed();
=======
import com.facebook.ui.MainUI;

import java.awt.*;
import java.io.IOException;

public class Application {

    static MainUI mainUI = new MainUI();

    public static void main(String[] args) throws AWTException, InterruptedException, IOException {

        mainUI.showMainUI();
>>>>>>> main

    }

}