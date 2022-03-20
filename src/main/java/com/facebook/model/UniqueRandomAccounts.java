package com.facebook.model;

import com.facebook.controllers.FindUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class UniqueRandomAccounts {

    public static List<Integer> randomGenerator(int max) throws IOException {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 40; i < max; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 10; i++) {
            System.out.println("\n" +
                    "User No. :" +
                    + list.get(i)+

                    "-----------------------------------------");

            FindUser.findUser(list.get(i));
        }
        return list;

    }
}
