package com.facebook.service;

import com.facebook.controllers.NameController;
import com.facebook.controllers.Numeric;
import com.facebook.controllers.SexType;
import com.facebook.ui.EditProfileUI;
import com.facebook.ui.LoadingUI;
import com.facebook.ui.MainUI;
import com.facebook.ui.UI;

import java.util.Scanner;

public class EnterProfileDetailsService {
    public static String newName;
    public static String newAge;
    public static String newSex;
    LoadingUI loadingUI = new LoadingUI();
    UI ui = new EditProfileUI();
    EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
    MainUI mainUI = new MainUI();
    public static Scanner in = new Scanner(System.in);


    //read name from console
    public static void enterProfileName(){
              boolean matches = false;
        while (matches == false) {
            System.out.println("Enter name:");
            newName = in.nextLine();
            if (NameController.isName(newName)==false) {
                System.out.println("Invalid name, use only characters");
            } else matches = true;
        }
    }


    //read age from console
    public static void enterProfileAge(){

        boolean matches = false;
        while (matches == false) {
            System.out.println("Enter age:");
            newAge = in.nextLine();
            if (Numeric.isNumeric(newAge)==false) {
                System.out.println("Invalid age, use only numbers");
            } else matches = true;
        }
    }


    //read age from console
    public static void enterProfileSex(){

        SexType sexType;
        do {
            System.out.print("Enter Sex=");
            newSex = in.next();
            sexType = SexType.fromString(newSex);
        } while (sexType == null);
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
