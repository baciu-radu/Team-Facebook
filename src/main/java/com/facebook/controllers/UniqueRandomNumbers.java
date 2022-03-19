package com.facebook.controllers;

import java.util.ArrayList;
import java.util.Collections;

public class UniqueRandomNumbers {

    public static void randomGenerator() {

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 30; i < 50; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int i = 0; i < 10; i++) {
            System.out.println(list.get(i));
        }
    }
}
