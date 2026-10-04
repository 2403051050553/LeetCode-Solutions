package com.jatinahuja.algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public final class SlidingWindowAlgorithms {
    private SlidingWindowAlgorithms() {
    }

    public static int[] maximums(int[] numbers, int windowSize) {
        if (windowSize < 1 || windowSize > numbers.length) {
            throw new IllegalArgumentException("Window size must be between 1 and the input length");
        }

        int[] maximums = new int[numbers.length - windowSize + 1];
        Deque<Integer> candidateIndices = new ArrayDeque<>();
        for (int index = 0; index < numbers.length; index++) {
            while (!candidateIndices.isEmpty() && candidateIndices.peekFirst() <= index - windowSize) {
                candidateIndices.removeFirst();
            }
            while (!candidateIndices.isEmpty()
                    && numbers[candidateIndices.peekLast()] <= numbers[index]) {
                candidateIndices.removeLast();
            }

            candidateIndices.addLast(index);
            if (index >= windowSize - 1) {
                maximums[index - windowSize + 1] = numbers[candidateIndices.peekFirst()];
            }
        }
        return maximums;
    }
}
