package com.jatinahuja.algorithms;

import java.util.HashMap;
import java.util.Map;

public final class ArrayAlgorithms {
    private ArrayAlgorithms() {
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> indicesByValue = new HashMap<>();
        for (int index = 0; index < numbers.length; index++) {
            int complement = target - numbers[index];
            Integer complementIndex = indicesByValue.get(complement);
            if (complementIndex != null) {
                return new int[] {complementIndex, index};
            }
            indicesByValue.put(numbers[index], index);
        }
        throw new IllegalArgumentException("No pair sums to the target");
    }

    public static int maxSubarraySum(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input must contain at least one number");
        }

        int currentSum = numbers[0];
        int maximumSum = numbers[0];
        for (int index = 1; index < numbers.length; index++) {
            currentSum = Math.max(numbers[index], currentSum + numbers[index]);
            maximumSum = Math.max(maximumSum, currentSum);
        }
        return maximumSum;
    }
}
