package com.aoc.day1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Exercise2Test {
    @Test
    void test() {
        String example ="two1nine\neightwothree\nabcone2threexyz\nxtwone3four\n4nineeightseven2\nzoneight234\n7pqrstsixteen";
        String[] lines = example.split("\n");
        AtomicInteger sum = new AtomicInteger();
        Arrays.stream(lines).forEach(line -> sum.addAndGet(Exercise2.getCalibrationValue(line)));
        assert sum.get() == 281;
    }
}
