package com.aoc.day1;

import org.junit.jupiter.api.Test;

public class Exercise1Test {
    @Test
    public void testGetLineValue() {
        String line = "1234";
        int result = Exercise1.getCalibrationValue(line);
        assert result == 14;
    }

    @Test
    public void testGetLineValueSingleDigit() {
        String line = "8";
        int result = Exercise1.getCalibrationValue(line);
        assert result == 88;
    }    @Test
    public void testGetLineValueTwoDigit() {
        String line = "90";
        int result = Exercise1.getCalibrationValue(line);
        assert result == 90;
    }
}
