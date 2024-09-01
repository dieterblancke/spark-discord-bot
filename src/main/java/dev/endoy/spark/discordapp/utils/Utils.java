package dev.endoy.spark.discordapp.utils;

import java.util.Random;

public class Utils {

    private static final Random RANDOM_INSTANCE = new Random();

    private Utils() {
    }

    public static int randomRangeInt(int min, int max) {
        return (int) (RANDOM_INSTANCE.nextDouble() < 0.5 ? ((1 - RANDOM_INSTANCE.nextDouble()) * (max - min) + min) : (RANDOM_INSTANCE.nextDouble() * (max - min) + min));
    }
}
