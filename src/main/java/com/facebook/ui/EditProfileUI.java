package com.facebook.ui;

import java.util.Scanner;

public class EditProfileUI extends MyProfileUI {
    public static void enterProfileDetails() {
        Scanner in = new Scanner(System.in);
//    System("Enter name:");
        System.out.println("Enter name:");
        String name = in.nextLine();
        System.out.println("Enter age:");
        int age = in.nextInt();
        System.out.println("Enter sex:");
        String sex = in.nextLine();

    }

}
