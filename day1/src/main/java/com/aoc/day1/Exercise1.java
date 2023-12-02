package com.aoc.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Exercise1 {

    public static void main(String[] args) {
        String filePath = "day1/src/main/resources/input.txt";
        int sum = calculateSum(filePath);
        System.out.println("Sum of calibration values: " + sum);
    }

    private static int calculateSum(String filePath) {
        int sum = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                int calibrationValue = getCalibrationValue(line);
                sum += calibrationValue;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sum;
    }

    static int getCalibrationValue(String line) {
        char[] chars = line.toCharArray();
        int firstDigit = findFirstDigit(chars);
        int lastDigit = findLastDigit(chars);
        return firstDigit * 10 + lastDigit;
    }

    private static int findFirstDigit(char[] line) {
        for (char c : line) {
            if (Character.isDigit(c)) {
                return Character.getNumericValue(c);
            }
        }
        return 0; // Default if no digit is found
    }

    private static int findLastDigit(char[] line) {
        for (int i = line.length - 1; i >= 0; i--) {
            if (Character.isDigit(line[i])) {
                return Character.getNumericValue(line[i]);
            }
        }
        return 0; // Default if no digit is found
    }
}