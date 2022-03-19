package com.facebook.ui;

import com.facebook.controllers.Numeric;
import com.facebook.controllers.SexType;
import com.facebook.model.ProfileDetails;
import com.facebook.model.UserDetails;
import com.facebook.service.EditUserDetailsService;
import com.facebook.service.ShowProfileDetailsService;
import com.facebook.service.UserService;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EditProfileUI extends MyProfileUI {
    public static void enterProfileDetails() throws IOException {
        LoadingUI loadingUI = new LoadingUI();
        UI ui = new EditProfileUI();
        EditUserDetailsService editUserDetailsService = new EditUserDetailsService();
        MainUI mainUI = new MainUI();
        Scanner in = new Scanner(System.in);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "facebook - Edit Profile" +
                "\n" +
                "\n" + "\t\t\t\t" + "0 - Exit" +
                "\n" + "\t\t\t\t" + "1 - Name" +
                "\n" + "\t\t\t\t" + "2 - Age" +
                "\n" + "\t\t\t\t" + "3 - Sex" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        System.out.println("---------------What do you want to edit?---------------");
        String option = "";
        while (option != "0") {

            option = in.next();

            switch (option) {

                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Name");
                    ProfileDetails.getOldName();
                    System.out.println(ProfileDetails.getOldName());
                    break;
                case "2":
                    System.out.println("Age");
//                    EditProfileUI.enterProfileDetails();
                    break;
                case "3":
                    System.out.println("Sex");
                    break;
                default:
                    System.err.println("Invalid option");
            }

        }
        
        String name = null;
        String age = null;
        String sex;
        
        

//    System("Enter name:");

        // reading name from console
//        Parser parser = new Parser();
        boolean matches = false;
        while (matches == false) {
            System.out.println("Enter name:");
            name = in.nextLine();
//            BufferedReader reader = new BufferedReader(new ImputStreamReader(System.in));
            //  if (name.matches("[A-Za-z]+[ ]+ [A-Za-z]" ) == false) {
            if (name.matches("[A-Za-z]+\\s[A-Za-z]+") == false) {
                System.out.println("Invalid name, use only characters");
            } else matches = true;
        }


        // read age from console
        System.out.println("Enter age:");
        Boolean x = false;
        while (x == false) {
            age = in.nextLine();
            if (Numeric.isNumeric(age) == false) {
                System.out.println("Invalid age, please retry using only numbers");
//
            } else x = true;

        }

        SexType sexType;
        do {
            System.out.print("Enter Sex=");
            sex = in.next();
            sexType = SexType.fromString(sex);
        } while (sexType == null);
        editUserDetailsService.editAccount(new UserDetails(name, age, sex));
//        System.out.println(sexType);

//        String sex = in.nextLine();
        System.out.println("               0 - Exit");
        System.out.println("               1 - Show Profile Details");
    }
}
//String emailRegex = "[A-Za-z\\.\\-_]+@\\w+\\.\\w+";