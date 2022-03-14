package com.facebook.ui;

import java.util.Scanner;

public class EditProfileUI extends MyProfileUI {
    public static void enterProfileDetails() {
        Scanner in = new Scanner(System.in);
//    System("Enter name:");
        System.out.println("Enter name:");
        String name = in.nextLine();
        System.out.println("Enter name:");
        int age = in.nextInt();

    }

}
