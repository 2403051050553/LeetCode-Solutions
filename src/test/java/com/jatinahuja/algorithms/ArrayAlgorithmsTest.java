package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ArrayAlgorithmsTest {
    @Test
    void twoSumHandlesDuplicateValues() {
        assertArrayEquals(new int[] {0, 1}, ArrayAlgorithms.twoSum(new int[] {3, 3}, 6));
    }

    @Test
    void twoSumRejectsMissingPair() {
        assertThrows(IllegalArgumentException.class, () -> ArrayAlgorithms.twoSum(new int[] {1, 2}, 8));
    }

    @Test
    void maximumSubarrayHandlesAllNegativeValues() {
        assertEquals(-2, ArrayAlgorithms.maxSubarraySum(new int[] {-5, -2, -7}));
    }

    @Test
    void maximumSubarrayRejectsEmptyInput() {
        assertThrows(IllegalArgumentException.class, () -> ArrayAlgorithms.maxSubarraySum(new int[0]));
    }

    @Test
    void mergeIntervalsSortsAndMergesOverlappingAndAdjacentRanges() {
        int[][] intervals = {{8, 10}, {1, 3}, {2, 6}, {10, 12}};
        assertArrayEquals(
                new int[][] {{1, 6}, {8, 12}},
                ArrayAlgorithms.mergeIntervals(intervals));
        assertArrayEquals(new int[][] {{8, 10}, {1, 3}, {2, 6}, {10, 12}}, intervals);
    }

    @Test
    void mergeIntervalsKeepsDisjointRangesAndSupportsEmptyInput() {
        assertArrayEquals(
                new int[][] {{-5, -2}, {0, 1}, {4, 7}},
                ArrayAlgorithms.mergeIntervals(new int[][] {{4, 7}, {-5, -2}, {0, 1}}));
        assertArrayEquals(new int[0][2], ArrayAlgorithms.mergeIntervals(new int[0][2]));
    }

    @Test
    void mergeIntervalsRejectsMalformedRanges() {
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayAlgorithms.mergeIntervals(new int[][] {{3, 1}}));
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayAlgorithms.mergeIntervals(new int[][] {{1}}));
        assertThrows(
                IllegalArgumentException.class,
                () -> ArrayAlgorithms.mergeIntervals(new int[][] {null}));
    }
}
