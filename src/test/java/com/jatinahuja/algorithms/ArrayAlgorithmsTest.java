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
}
