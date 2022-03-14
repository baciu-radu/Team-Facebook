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
        MyProfileUI myProfileUI = new MyProfileUI();
        System.out.println("------------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String yearDate = dateFormat.format(new Date());
        System.out.println("---------------------------------------------------" +
                "\n" + "facebook - My Profile" +
                "\n" +
                "\n" + "\t\t\t\t" + "0 - Exit" +
                "\n" + "\t\t\t\t" + "1 - Show Profile Details" +
                "\n" + "\t\t\t\t" + "2 - Edit Profile" +
                "\n" +
                "\n" + "Meta \u00a9 " + yearDate +
                "\n" + "---------------------------------------------------"
        );
        String option = "Start";

        while (option != "0") {

            option = in.next();

            switch (option) {

                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Show Profile Details");
                    MyProfileUI.showProfileDetails();
                    break;
                case "2":
                    System.out.println("Edit Profile Details");
                    EditProfileUI.enterProfileDetails();
                    break;
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
//        String livesIn = "not assigned";
//        String fromTown = "not assigned";
//        String worksAt = "not assigned";
//        String studies = "not assigned";
//        String relationshipStatus = "not assigned";
        int followedBy = 0;
        //add date of join


        System.out.println("----------------------------MY PROFILE ---------------------------");
        System.out.println("\n Name= " + name); // still to create regex
        System.out.println("\n Age= " + age + " years");  //still create regex - age at account creation must be 18 or higher
//        System.out.println("\n Name= " +email);
        System.out.println("\n Sex= " + sex);  // still to Create enum
//        System.out.println("\n Name= " + livesIn);
//        System.out.println("\n Name= " + fromTown);
//        System.out.println("\n Name= " + worksAt);
//        System.out.println("\n Name= " + studies);
//        System.out.println("\n Name= " + relationshipStatus);
        System.out.println("\n Follow By= " + followedBy + " people");// still to create counter


    }

}



