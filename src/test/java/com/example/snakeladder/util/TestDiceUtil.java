package com.example.snakeladder.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDiceUtil {

    @Test
    public void testNextNumberGeneration(){
        for(int i = 0 ; i < 1000; i ++) {
            int num = DiceUtil.getNextNumber(6);
            Assertions.assertThat(num <= 6);
        }
    }
}
