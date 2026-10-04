package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SearchAlgorithmsTest {
    @Test
    void lowerBoundFindsFirstMatchingValue() {
        assertEquals(1, SearchAlgorithms.lowerBound(new int[] {1, 3, 3, 7}, 3));
    }

    @Test
    void lowerBoundReturnsInsertionPointWhenValueIsAbsent() {
        assertEquals(2, SearchAlgorithms.lowerBound(new int[] {1, 3, 7}, 4));
    }

    @Test
    void lowerBoundHandlesEmptyInput() {
        assertEquals(0, SearchAlgorithms.lowerBound(new int[0], 4));
    }
}
