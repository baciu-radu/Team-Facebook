package com.facebook;

import com.facebook.model.HomePage;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {

        HomePage homePage = new HomePage();
        homePage.newsFeed();

    }
}
