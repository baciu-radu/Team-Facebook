package com.facebook.service;

import com.facebook.controllers.NameController;
import com.facebook.ui.EditProfileUI;
import com.facebook.ui.LoadingUI;
import com.facebook.ui.MainUI;
import com.facebook.ui.UI;

import java.util.Scanner;

public class EnterProfileDetailsService {
    public static String newName;
    public static String newAge;
    public static String newSex;
    public static void enterProfileName(){
        LoadingUI loadingUI = new LoadingUI();
        UI ui = new EditProfileUI();
        EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);

        boolean matches = false;
        while (matches == false) {
            System.out.println("Enter name:");
            newName = in.nextLine();
            if (NameController.isName(newName)==false) {
                System.out.println("Invalid name, use only characters");
            } else matches = true;
        }
    }
    public static void enterProfileAge(){
        LoadingUI loadingUI = new LoadingUI();
        UI ui = new EditProfileUI();
        EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);

        boolean matches = false;
        while (matches == false) {
            System.out.println("Enter age:");
            newName = in.nextLine();
            if (NameController.isName(newName)==false) {
                System.out.println("Invalid name, use only characters");
            } else matches = true;
        }
    }
    public static String getNewName(){
        return newName;
    }

    public static String getNewAge() {
        return newAge;
    }
    public static String getNewSex() {
        return newSex;
    }
}
