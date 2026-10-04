package com.jatinahuja.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class ArrayPractice {
    private ArrayPractice() {
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            Integer other = seen.get(target - numbers[i]);
            if (other != null) {
                return new int[] {other, i};
            }
            seen.put(numbers[i], i);
        }
        return new int[0];
    }

    public static boolean containsDuplicate(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        for (int number : numbers) {
            if (!seen.add(number)) {
                return true;
            }
        }
        return false;
    }

    public static int maxSubArray(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input must not be empty");
        }
        int current = numbers[0];
        int best = current;
        for (int i = 1; i < numbers.length; i++) {
            current = Math.max(numbers[i], current + numbers[i]);
            best = Math.max(best, current);
        }
        return best;
    }

    public static int maxProfit(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int best = 0;
        for (int price : prices) {
            lowest = Math.min(lowest, price);
            best = Math.max(best, price - lowest);
        }
        return best;
    }

    public static int[] productExceptSelf(int[] numbers) {
        int[] result = new int[numbers.length];
        Arrays.fill(result, 1);
        int prefix = 1;
        for (int i = 0; i < numbers.length; i++) {
            result[i] = prefix;
            prefix *= numbers[i];
        }
        int suffix = 1;
        for (int i = numbers.length - 1; i >= 0; i--) {
            result[i] *= suffix;
            suffix *= numbers[i];
        }
        return result;
    }

    public static int[][] mergeIntervals(int[][] intervals) {
        int[][] sorted = new int[intervals.length][2];
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i] == null || intervals[i].length != 2
                    || intervals[i][0] > intervals[i][1]) {
                throw new IllegalArgumentException("Each interval must have an ordered start and end");
            }
            sorted[i] = intervals[i].clone();
        }
        Arrays.sort(sorted, (left, right) -> Integer.compare(left[0], right[0]));
        int[][] merged = new int[sorted.length][2];
        int size = 0;
        for (int[] interval : sorted) {
            if (size == 0 || interval[0] > merged[size - 1][1]) {
                merged[size++] = interval;
            } else {
                merged[size - 1][1] = Math.max(merged[size - 1][1], interval[1]);
            }
        }
        return Arrays.copyOf(merged, size);
    }

    public static void moveZeroes(int[] numbers) {
        int next = 0;
        for (int number : numbers) {
            if (number != 0) {
                numbers[next++] = number;
            }
        }
        while (next < numbers.length) {
            numbers[next++] = 0;
        }
    }

    public static int majorityElement(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input must not be empty");
        }
        int candidate = 0;
        int votes = 0;
        for (int number : numbers) {
            if (votes == 0) {
                candidate = number;
            }
            votes += number == candidate ? 1 : -1;
        }
        return candidate;
    }

    public static void rotateRight(int[] numbers, int steps) {
        if (numbers.length == 0) {
            return;
        }
        int shift = Math.floorMod(steps, numbers.length);
        reverse(numbers, 0, numbers.length - 1);
        reverse(numbers, 0, shift - 1);
        reverse(numbers, shift, numbers.length - 1);
    }

    public static int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int best = 0;
        while (left < right) {
            best = Math.max(best, (right - left) * Math.min(heights[left], heights[right]));
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
        }
        return best;
    }

    public static java.util.List<java.util.List<Integer>> threeSum(int[] numbers) {
        int[] sorted = numbers.clone();
        Arrays.sort(sorted);
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        for (int i = 0; i < sorted.length - 2; i++) {
            if (i > 0 && sorted[i] == sorted[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = sorted.length - 1;
            while (left < right) {
                long sum = (long) sorted[i] + sorted[left] + sorted[right];
                if (sum == 0) {
                    result.add(java.util.List.of(sorted[i], sorted[left], sorted[right]));
                    int leftValue = sorted[left];
                    int rightValue = sorted[right];
                    while (left < right && sorted[left] == leftValue) {
                        left++;
                    }
                    while (left < right && sorted[right] == rightValue) {
                        right--;
                    }
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static int longestConsecutive(int[] numbers) {
        Set<Integer> values = new HashSet<>();
        for (int number : numbers) {
            values.add(number);
        }
        int longest = 0;
        for (int number : values) {
            if (number == Integer.MIN_VALUE || !values.contains(number - 1)) {
                int length = 1;
                int next = number;
                while (next != Integer.MAX_VALUE && values.contains(next + 1)) {
                    next++;
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static int trap(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int leftMaximum = 0;
        int rightMaximum = 0;
        int water = 0;
        while (left < right) {
            if (heights[left] <= heights[right]) {
                leftMaximum = Math.max(leftMaximum, heights[left]);
                water += leftMaximum - heights[left++];
            } else {
                rightMaximum = Math.max(rightMaximum, heights[right]);
                water += rightMaximum - heights[right--];
            }
        }
        return water;
    }

    public static int subarraySum(int[] numbers, int target) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);
        int prefix = 0;
        int count = 0;
        for (int number : numbers) {
            prefix += number;
            count += prefixCounts.getOrDefault(prefix - target, 0);
            prefixCounts.merge(prefix, 1, Integer::sum);
        }
        return count;
    }

    private static void reverse(int[] numbers, int left, int right) {
        while (left < right) {
            int value = numbers[left];
            numbers[left++] = numbers[right];
            numbers[right--] = value;
        }
    }
}
