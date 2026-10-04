package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class SlidingWindowAlgorithmsTest {
    @Test
    void maximumsReturnsTheMaximumForEachOverlappingWindow() {
        assertArrayEquals(
                new int[] {3, 3, 5, 5, 6, 7},
                SlidingWindowAlgorithms.maximums(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
    }

    @Test
    void maximumsSupportsSingleElementAndFullLengthWindows() {
        int[] numbers = {4, -2, 7};
        assertArrayEquals(new int[] {4, -2, 7}, SlidingWindowAlgorithms.maximums(numbers, 1));
        assertArrayEquals(new int[] {7}, SlidingWindowAlgorithms.maximums(numbers, numbers.length));
    }

    @Test
    void maximumsHandlesRepeatedAndNegativeValues() {
        assertArrayEquals(
                new int[] {-1, -1, -1},
                SlidingWindowAlgorithms.maximums(new int[] {-4, -1, -1, -3}, 2));
    }

    @Test
    void maximumsRejectsInvalidWindowSizes() {
        assertThrows(
                IllegalArgumentException.class,
                () -> SlidingWindowAlgorithms.maximums(new int[] {1, 2}, 0));
        assertThrows(
                IllegalArgumentException.class,
                () -> SlidingWindowAlgorithms.maximums(new int[] {1, 2}, 3));
    }
}
