package com.jatinahuja.practice;

import java.util.Set;

public final class DynamicProgrammingPractice {
    private DynamicProgrammingPractice() {
    }

    public static int climbStairs(int steps) {
        if (steps < 0) {
            throw new IllegalArgumentException("Step count must not be negative");
        }
        int oneStepBefore = 1;
        int twoStepsBefore = 1;
        for (int step = 2; step <= steps; step++) {
            int current = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = current;
        }
        return oneStepBefore;
    }

    public static int rob(int[] houses) {
        int twoBack = 0;
        int oneBack = 0;
        for (int money : houses) {
            int current = Math.max(oneBack, twoBack + money);
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    public static int coinChange(int[] coins, int amount) {
        if (amount < 0) {
            return -1;
        }
        int[] best = new int[amount + 1];
        java.util.Arrays.fill(best, amount + 1);
        best[0] = 0;
        for (int value = 1; value <= amount; value++) {
            for (int coin : coins) {
                if (coin > 0 && coin <= value) {
                    best[value] = Math.min(best[value], best[value - coin] + 1);
                }
            }
        }
        return best[amount] > amount ? -1 : best[amount];
    }

    public static boolean wordBreak(String value, Set<String> dictionary) {
        boolean[] canBuild = new boolean[value.length() + 1];
        canBuild[0] = true;
        for (int end = 1; end <= value.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (canBuild[start] && dictionary.contains(value.substring(start, end))) {
                    canBuild[end] = true;
                    break;
                }
            }
        }
        return canBuild[value.length()];
    }

    public static int lengthOfLIS(int[] numbers) {
        int[] tails = new int[numbers.length];
        int size = 0;
        for (int number : numbers) {
            int left = 0;
            int right = size;
            while (left < right) {
                int middle = left + (right - left) / 2;
                if (tails[middle] < number) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = number;
            if (left == size) {
                size++;
            }
        }
        return size;
    }

    public static int uniquePaths(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            return 0;
        }
        int[] paths = new int[columns];
        java.util.Arrays.fill(paths, 1);
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                paths[column] += paths[column - 1];
            }
        }
        return paths[columns - 1];
    }

    public static int numDecodings(String value) {
        if (value.isEmpty() || value.charAt(0) == '0') {
            return 0;
        }
        int twoBack = 1;
        int oneBack = 1;
        for (int i = 1; i < value.length(); i++) {
            int current = value.charAt(i) == '0' ? 0 : oneBack;
            int pair = Integer.parseInt(value.substring(i - 1, i + 1));
            if (pair >= 10 && pair <= 26) {
                current += twoBack;
            }
            twoBack = oneBack;
            oneBack = current;
        }
        return oneBack;
    }

    public static boolean canPartition(int[] numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        if (total % 2 != 0) {
            return false;
        }
        boolean[] possible = new boolean[total / 2 + 1];
        possible[0] = true;
        for (int number : numbers) {
            for (int sum = total / 2; sum >= number; sum--) {
                possible[sum] |= possible[sum - number];
            }
        }
        return possible[total / 2];
    }

}
