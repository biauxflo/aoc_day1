package com.aoc.day1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exercise2 {

    public static void main(String[] args) {
        String filePath = "day1/src/main/resources/input.txt";
        int sum = calculateSumWithSpellOutDigit(filePath);
        System.out.println("Sum of calibration values: " + sum);
    }

    private static int calculateSumWithSpellOutDigit(String filePath) {
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
        String onlyDigits = replaceWordsWithNumbers(line);
        char[] chars = onlyDigits.toCharArray();
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
        return 0;
    }

    private static int findLastDigit(char[] line) {
        for (int i = line.length - 1; i >= 0; i--) {
            if (Character.isDigit(line[i])) {
                return Character.getNumericValue(line[i]);
            }
        }
        return 0;
    }

    public static String replaceWordsWithNumbers(String input) {
        Map<String, String> wordToNumber = new HashMap<>();
        wordToNumber.put("one", "o1e");
        wordToNumber.put("two", "t2o");
        wordToNumber.put("three", "t3e");
        wordToNumber.put("four", "f4r");
        wordToNumber.put("five", "f5e");
        wordToNumber.put("six", "s6x");
        wordToNumber.put("seven", "s7n");
        wordToNumber.put("eight", "e8t");
        wordToNumber.put("nine", "n9e");

        for (Map.Entry<String, String> entry : wordToNumber.entrySet()) {
            input = input.replaceAll(entry.getKey(), entry.getValue());
        }
        return input;
    }
}
