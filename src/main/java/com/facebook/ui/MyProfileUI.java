package com.facebook.ui;

import com.facebook.service.ShowProfileDetailsService;

import java.awt.*;
import java.io.IOException;

public class MyProfileUI extends UI {

    public void showMyProfileUI() throws IOException, InterruptedException, AWTException {
        LoadingUI loadingUI = new LoadingUI();
        ShowProfileDetailsService showProfileDetailsService = new ShowProfileDetailsService();
        loadingUI.popProgressBar();
        showProfileDetailsService.showProfileDetails();


    }

    @Override
    public void closeApplication() {

    }
}



