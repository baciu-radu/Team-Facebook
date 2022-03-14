package com.facebook.ui;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MyProfileUI {
    //    public static void main(String[] args) {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public static void showMyProfileUI() {
//        Runtime.getRuntime().exec("cls");
        Scanner in = new Scanner(System.in);
        System.out.println("------------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "facebook - My Profile" +
                "\n" +
                "\n" + "\t\t\t\t" + "0 - Exit" +
                "\n" + "\t\t\t\t" + "6 - Show Profile Details" +
                "\n" + "\t\t\t\t" + "7 - Edit Profile" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        String option="Start";

        while (option != "0") {

            option = in.next();

            switch (option) {

                case "1":
                    System.out.println("Log in");
                    break;
                case "2":
                    System.out.println("Forgot password?");
                    break;
                case "3":
                    System.out.println("Create new account");
                    break;
                case "4":
                    System.exit(0);
                    break;
                case "5":
                    System.out.println(" Taking you to your account");
//                    showMainUI();
                    MyProfileUI.clearScreen();
                    MyProfileUI.showMyProfileUI();

                default:
                    System.err.println("Invalid option");
            }

        }
    }

    public static void showProfileDetails() {
        Scanner in = new Scanner(System.in);

        String name = "not assigned";
        int age = 0;
//        String email="not assigned";
        String sex = "not assigned";
        String livesIn = "not assigned";
        String fromTown = "not assigned";
        String worksAt = "not assigned";
        String studies = "not assigned";
        String relationshipStatus = "not assigned";
        int followedBy = 0;
        //add date of join


        System.out.println("----------------------------MY PROFILE ---------------------------");
        System.out.println("\n Name= " + name);
        System.out.println("\n Name= " + age);
//        System.out.println("\n Name= " +email);
        System.out.println("\n Name= " + sex);
        System.out.println("\n Name= " + livesIn);
        System.out.println("\n Name= " + fromTown);
        System.out.println("\n Name= " + worksAt);
        System.out.println("\n Name= " + studies);
        System.out.println("\n Name= " + relationshipStatus);
        System.out.println("\n Name= " + followedBy);


    }

}



