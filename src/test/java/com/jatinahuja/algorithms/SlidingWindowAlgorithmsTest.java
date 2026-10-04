package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Random;
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

    @Test
    void maximumsMatchesBruteForceAcrossDeterministicRandomInputs() {
        Random random = new Random(0x5EED);
        for (int trial = 0; trial < 250; trial++) {
            int[] numbers = new int[1 + random.nextInt(20)];
            for (int index = 0; index < numbers.length; index++) {
                numbers[index] = random.nextInt(41) - 20;
            }
            int windowSize = 1 + random.nextInt(numbers.length);

            assertArrayEquals(
                    bruteForceMaximums(numbers, windowSize),
                    SlidingWindowAlgorithms.maximums(numbers, windowSize),
                    "Mismatch for trial " + trial + " and window size " + windowSize);
        }
    }

    private static int[] bruteForceMaximums(int[] numbers, int windowSize) {
        int[] maximums = new int[numbers.length - windowSize + 1];
        for (int start = 0; start < maximums.length; start++) {
            int maximum = numbers[start];
            for (int index = start + 1; index < start + windowSize; index++) {
                maximum = Math.max(maximum, numbers[index]);
            }
            maximums[start] = maximum;
        }
        return maximums;
    }
}
