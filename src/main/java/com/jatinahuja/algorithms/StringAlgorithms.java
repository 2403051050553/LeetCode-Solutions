package com.jatinahuja.algorithms;

public final class StringAlgorithms {
    private StringAlgorithms() {
    }

    public static boolean isPalindrome(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(text.charAt(left)) != Character.toLowerCase(text.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static int firstUniqueCharacterIndex(String text) {
        int[] frequencies = new int[Character.MAX_VALUE + 1];
        for (int index = 0; index < text.length(); index++) {
            frequencies[text.charAt(index)]++;
        }
        for (int index = 0; index < text.length(); index++) {
            if (frequencies[text.charAt(index)] == 1) {
                return index;
            }
        }
        return -1;
    }
}
