package com.facebook.ui;

import com.facebook.controllers.Numeric;
import com.facebook.controllers.SexType;

import java.util.Scanner;

public class EditProfileUI extends MyProfileUI {
    public static void enterProfileDetails() {
        Scanner in = new Scanner(System.in);
//    System("Enter name:");
        System.out.println("Enter name:");
        String name = in.nextLine();

        System.out.println("Enter age:");
        Boolean x = false;
        while (x == false) {
            String age = in.nextLine();
            if (Numeric.isNumeric(age) == false) {
                System.out.println("Invalid age, please retry using only numbers");
//
            } else x = true;

        }

        SexType sexType;
        do  {
            System.out.print("Enter Sex=");
            String sex = in.next();
            sexType = SexType.fromString(sex);
        } while (sexType == null);

        String sex = in.nextLine();
    }
}
