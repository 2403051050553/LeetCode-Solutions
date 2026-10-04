package com.jatinahuja.practice;

public final class BinarySearchPractice {
    private BinarySearchPractice() {
    }

    public static int search(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int searchInsert(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }

    public static int searchRotated(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] == target) {
                return middle;
            }
            if (numbers[left] <= numbers[middle]) {
                if (numbers[left] <= target && target < numbers[middle]) {
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            } else if (numbers[middle] < target && target <= numbers[right]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public static int findMinRotated(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input must not be empty");
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] > numbers[right]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return numbers[left];
    }

    public static int findPeakElement(int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("Input must not be empty");
        }
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int middle = left + (right - left) / 2;
            if (numbers[middle] < numbers[middle + 1]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
