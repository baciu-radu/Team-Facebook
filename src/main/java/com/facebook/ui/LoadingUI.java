package com.facebook.ui;

import java.awt.*;
import java.awt.event.InputEvent;
import java.util.concurrent.TimeUnit;

public class LoadingUI {

    public void click(int x, int y) throws AWTException {
        Robot bot = new Robot();
        bot.mouseMove(x, y);
        bot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        bot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void popProgressBar() throws InterruptedException, AWTException {

        LoadingUI loadingUI = new LoadingUI();

        loadingUI.click(65 , 825);
        TimeUnit.MILLISECONDS.sleep(1000);

        StringBuilder sb = new StringBuilder();
        System.out.println("\t\t\t\t\t\t\u23F3 Loading...");

        for (int i = 10; i <= 100; i += 10) {
            sb.setLength(0);
            for (int j = 0; j <= i; j += 2) {
                sb.append("\u2588");
            }
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.print(String.format("%-51s", sb) + " " + i + "%");
            System.out.print("\r");
        }

        loadingUI.click(65 , 900);
        TimeUnit.MILLISECONDS.sleep(1000);
        loadingUI.click(65 , 825);
        TimeUnit.MILLISECONDS.sleep(1000);
        loadingUI.click(65 , 900);

    }

}
