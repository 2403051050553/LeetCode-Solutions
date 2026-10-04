package com.jatinahuja.algorithms;

public final class SearchAlgorithms {
    private SearchAlgorithms() {
    }

    public static int lowerBound(int[] sortedNumbers, int target) {
        int low = 0;
        int high = sortedNumbers.length;
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (sortedNumbers[middle] < target) {
                low = middle + 1;
            } else {
                high = middle;
            }
        }
        return low;
    }
}
