package com.jatinahuja.algorithms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StringAlgorithmsTest {
    @Test
    void palindromeIgnoresPunctuationAndCase() {
        assertTrue(StringAlgorithms.isPalindrome("A man, a plan, a canal: Panama!"));
    }

    @Test
    void detectsNonPalindrome() {
        assertFalse(StringAlgorithms.isPalindrome("algorithm"));
    }

    @Test
    void findsFirstUniqueCharacter() {
        assertEquals(4, StringAlgorithms.firstUniqueCharacterIndex("aabbc"));
    }

    @Test
    void returnsNegativeOneWhenNoUniqueCharacterExists() {
        assertEquals(-1, StringAlgorithms.firstUniqueCharacterIndex("aabb"));
    }
}
