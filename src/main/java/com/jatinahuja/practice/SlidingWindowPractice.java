package com.jatinahuja.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SlidingWindowPractice {
    private SlidingWindowPractice() {
    }

    public static int[] maxSlidingWindow(int[] numbers, int windowSize) {
        if (windowSize < 1 || windowSize > numbers.length) {
            throw new IllegalArgumentException("Window size must fit the input");
        }
        int[] result = new int[numbers.length - windowSize + 1];
        Deque<Integer> indices = new ArrayDeque<>();
        for (int i = 0; i < numbers.length; i++) {
            while (!indices.isEmpty() && indices.peekFirst() <= i - windowSize) {
                indices.removeFirst();
            }
            while (!indices.isEmpty() && numbers[indices.peekLast()] <= numbers[i]) {
                indices.removeLast();
            }
            indices.addLast(i);
            if (i >= windowSize - 1) {
                result[i - windowSize + 1] = numbers[indices.peekFirst()];
            }
        }
        return result;
    }

    public static int minSubArrayLen(int target, int[] numbers) {
        int start = 0;
        int sum = 0;
        int best = Integer.MAX_VALUE;
        for (int end = 0; end < numbers.length; end++) {
            sum += numbers[end];
            while (sum >= target) {
                best = Math.min(best, end - start + 1);
                sum -= numbers[start++];
            }
        }
        return best == Integer.MAX_VALUE ? 0 : best;
    }

    public static int characterReplacement(String value, int replacements) {
        int[] counts = new int[Character.MAX_VALUE + 1];
        int start = 0;
        int mostCommon = 0;
        int best = 0;
        for (int end = 0; end < value.length(); end++) {
            mostCommon = Math.max(mostCommon, ++counts[value.charAt(end)]);
            while (end - start + 1 - mostCommon > replacements) {
                counts[value.charAt(start++)]--;
            }
            best = Math.max(best, end - start + 1);
        }
        return best;
    }

    public static boolean checkInclusion(String pattern, String value) {
        if (pattern.length() > value.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (char current : pattern.toCharArray()) {
            counts[current - 'a']++;
        }
        int start = 0;
        for (int end = 0; end < value.length(); end++) {
            counts[value.charAt(end) - 'a']--;
            if (end - start + 1 > pattern.length()) {
                counts[value.charAt(start++) - 'a']++;
            }
            if (end - start + 1 == pattern.length() && allZero(counts)) {
                return true;
            }
        }
        return false;
    }

    public static int longestOnes(int[] numbers, int flips) {
        int start = 0;
        int zeroes = 0;
        int best = 0;
        for (int end = 0; end < numbers.length; end++) {
            if (numbers[end] == 0) {
                zeroes++;
            }
            while (zeroes > flips) {
                if (numbers[start++] == 0) {
                    zeroes--;
                }
            }
            best = Math.max(best, end - start + 1);
        }
        return best;
    }

    private static boolean allZero(int[] counts) {
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
