package com.facebook.model;

import java.util.Random;

public class FindFriends {
    public static int getRandomID(int min, int max) {
        Random random = new Random();
        return random.ints(min, max)
                .findFirst()
                .getAsInt();
    }
//    public static int getRandomID(int min, int max) {
//        Random random = new Random();
//        return random.nextInt(max - min) + min;
//    }
}
