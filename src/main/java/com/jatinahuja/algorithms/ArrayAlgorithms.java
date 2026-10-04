package com.jatinahuja.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

    public static int[][] mergeIntervals(int[][] intervals) {
        int[][] sortedIntervals = new int[intervals.length][2];
        for (int index = 0; index < intervals.length; index++) {
            if (intervals[index] == null || intervals[index].length != 2
                    || intervals[index][0] > intervals[index][1]) {
                throw new IllegalArgumentException("Each interval must contain an ordered start and end");
            }
            sortedIntervals[index] = intervals[index].clone();
        }

        Arrays.sort(sortedIntervals, (left, right) -> Integer.compare(left[0], right[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        for (int[] interval : sortedIntervals) {
            if (mergedIntervals.isEmpty()
                    || interval[0] > mergedIntervals.get(mergedIntervals.size() - 1)[1]) {
                mergedIntervals.add(interval);
            } else {
                int[] previous = mergedIntervals.get(mergedIntervals.size() - 1);
                previous[1] = Math.max(previous[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(int[][]::new);
    }
}
