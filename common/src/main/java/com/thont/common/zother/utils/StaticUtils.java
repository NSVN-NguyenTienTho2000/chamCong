package com.thont.common.zother.utils;

import java.util.Random;

public class StaticUtils {

    private static Random random = new Random();

    private StaticUtils() {
    }

    public static int randomInt(int bound) {
        return random.nextInt(bound);
    }
}
