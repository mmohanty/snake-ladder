package com.example.snakeladder.util;

import java.util.Random;

public class DiceUtil {

    public static int getNextNumber(int upperBound){
        Random random = new Random();
        return random.nextInt(upperBound);
    }
}
