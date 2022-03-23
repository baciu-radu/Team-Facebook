package com.facebook.ui;

import com.facebook.service.ShowProfileDetailsService;

import java.awt.*;
import java.io.IOException;

public class MyProfileUI extends UI {

    public void showMyProfileUI() throws IOException, InterruptedException, AWTException {
        LoadingUI loadingUI = new LoadingUI();
        loadingUI.popProgressBar();
        ShowProfileDetailsService.showProfileDetails();


    }

    @Override
    public void closeApplication() {

    }
}



