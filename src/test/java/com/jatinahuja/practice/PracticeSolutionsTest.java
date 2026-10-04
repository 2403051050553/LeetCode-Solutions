package com.jatinahuja.practice;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;

class PracticeSolutionsTest {
    @Test
    void arrayPracticeCoversCommonArrayProblems() {
        assertArrayEquals(new int[] {0, 1}, ArrayPractice.twoSum(new int[] {2, 7, 11}, 9));
        assertArrayEquals(new int[0], ArrayPractice.twoSum(new int[] {1, 2}, 8));
        assertTrue(ArrayPractice.containsDuplicate(new int[] {1, 2, 1}));
        assertFalse(ArrayPractice.containsDuplicate(new int[] {1, 2, 3}));
        assertEquals(6, ArrayPractice.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertThrows(IllegalArgumentException.class, () -> ArrayPractice.maxSubArray(new int[0]));
        assertEquals(5, ArrayPractice.maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        assertArrayEquals(
                new int[] {24, 12, 8, 6},
                ArrayPractice.productExceptSelf(new int[] {1, 2, 3, 4}));
        assertArrayEquals(
                new int[][] {{1, 6}, {8, 10}},
                ArrayPractice.mergeIntervals(new int[][] {{8, 10}, {1, 3}, {2, 6}}));
        int[] moved = {0, 1, 0, 3, 12};
        ArrayPractice.moveZeroes(moved);
        assertArrayEquals(new int[] {1, 3, 12, 0, 0}, moved);
        assertEquals(2, ArrayPractice.majorityElement(new int[] {2, 2, 1, 2}));
        int[] rotated = {1, 2, 3, 4, 5, 6, 7};
        ArrayPractice.rotateRight(rotated, 3);
        assertArrayEquals(new int[] {5, 6, 7, 1, 2, 3, 4}, rotated);
        assertEquals(49, ArrayPractice.maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }

    @Test
    void stringPracticeCoversCommonStringProblems() {
        assertTrue(StringPractice.isAnagram("listen", "silent"));
        assertFalse(StringPractice.isAnagram("aab", "abb"));
        List<Set<String>> groups = StringPractice.groupAnagrams(
                        new String[] {"eat", "tea", "tan", "ate", "nat", "bat"})
                .stream()
        .map(Set::copyOf)
                .toList();
        assertEquals(
                Set.of(Set.of("eat", "tea", "ate"), Set.of("tan", "nat"), Set.of("bat")),
                new HashSet<>(groups));
        assertEquals(3, StringPractice.longestSubstringLength("abcabcbb"));
        assertEquals("fl", StringPractice.longestCommonPrefix(new String[] {"flower", "flow", "flight"}));
        assertTrue(StringPractice.isValidParentheses("({[]})"));
        assertFalse(StringPractice.isValidParentheses("(]"));
        assertEquals("blue is sky the", StringPractice.reverseWords("  the sky is blue  "));
        assertEquals(0, StringPractice.firstUniqueCharacterIndex("leetcode"));
        assertEquals(-1, StringPractice.firstUniqueCharacterIndex("aabb"));
        assertEquals("BANC", StringPractice.minWindow("ADOBECODEBANC", "ABC"));
        assertEquals("", StringPractice.minWindow("abc", "z"));
    }

    @Test
    void binarySearchPracticeCoversSortedAndRotatedInputs() {
        assertEquals(2, BinarySearchPractice.search(new int[] {-1, 0, 3, 5, 9}, 3));
        assertEquals(-1, BinarySearchPractice.search(new int[] {1, 2, 3}, 4));
        assertEquals(2, BinarySearchPractice.searchInsert(new int[] {1, 3, 5, 6}, 5));
        assertEquals(1, BinarySearchPractice.searchRotated(new int[] {4, 5, 6, 7, 0, 1, 2}, 5));
        assertEquals(-1, BinarySearchPractice.searchRotated(new int[] {4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(1, BinarySearchPractice.findMinRotated(new int[] {3, 4, 5, 1, 2}));
        int[] peakInput = {1, 2, 3, 1};
        int peak = BinarySearchPractice.findPeakElement(peakInput);
        assertTrue(peakInput[peak] > peakInput[Math.max(0, peak - 1)]);
        assertTrue(peakInput[peak] > peakInput[Math.min(peakInput.length - 1, peak + 1)]);
    }

    @Test
    void slidingWindowPracticeCoversWindowAndSubstringPatterns() {
        assertArrayEquals(
                new int[] {3, 3, 5, 5, 6, 7},
                SlidingWindowPractice.maxSlidingWindow(new int[] {1, 3, -1, -3, 5, 3, 6, 7}, 3));
        assertEquals(2, SlidingWindowPractice.minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        assertEquals(4, SlidingWindowPractice.characterReplacement("AABABBA", 1));
        assertTrue(SlidingWindowPractice.checkInclusion("ab", "eidbaooo"));
        assertFalse(SlidingWindowPractice.checkInclusion("ab", "eidboaoo"));
        assertEquals(6, SlidingWindowPractice.longestOnes(
                new int[] {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
    }

    @Test
    void stackPracticeCoversMonotonicAndExpressionProblems() {
        assertArrayEquals(
                new int[] {1, 1, 4, 2, 1, 1, 0, 0},
                StackPractice.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73}));
        assertEquals(9, StackPractice.evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        assertEquals("/home", StackPractice.simplifyPath("/home//foo/../"));
        assertEquals("1219", StackPractice.removeKdigits("1432219", 3));
        assertEquals("0", StackPractice.removeKdigits("10", 2));
    }

    @Test
    void dynamicProgrammingPracticeCoversClassicProblems() {
        assertEquals(8, DynamicProgrammingPractice.climbStairs(5));
        assertEquals(4, DynamicProgrammingPractice.rob(new int[] {1, 2, 3, 1}));
        assertEquals(3, DynamicProgrammingPractice.coinChange(new int[] {1, 2, 5}, 11));
        assertEquals(-1, DynamicProgrammingPractice.coinChange(new int[] {2}, 3));
        assertTrue(DynamicProgrammingPractice.wordBreak(
                "leetcode", Set.of("leet", "code")));
        assertEquals(4, DynamicProgrammingPractice.lengthOfLIS(
                new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        assertEquals(28, DynamicProgrammingPractice.uniquePaths(3, 7));
        assertEquals(3, DynamicProgrammingPractice.numDecodings("226"));
        assertEquals(0, DynamicProgrammingPractice.numDecodings("06"));
        assertTrue(DynamicProgrammingPractice.canPartition(new int[] {1, 5, 11, 5}));
        assertFalse(DynamicProgrammingPractice.canPartition(new int[] {1, 2, 3, 5}));
    }

    @Test
    void backtrackingPracticeReturnsExpectedCombinations() {
        assertEquals(8, BacktrackingPractice.subsets(new int[] {1, 2, 3}).size());
        assertEquals(6, BacktrackingPractice.permutations(new int[] {1, 2, 3}).size());
        assertEquals(
                Set.of(List.of(2, 2, 3), List.of(7)),
                new HashSet<>(BacktrackingPractice.combinationSum(new int[] {7, 2, 3}, 7)));
        assertEquals(
                Set.of("((()))", "(()())", "(())()", "()(())", "()()()"),
                new HashSet<>(BacktrackingPractice.generateParenthesis(3)));
    }

    @Test
    void linkedListPracticeReversesMergesAndDetectsCycles() {
        LinkedListPractice.ListNode reversed =
                LinkedListPractice.reverseList(list(1, 2, 3));
        assertArrayEquals(new int[] {3, 2, 1}, listValues(reversed));
        assertArrayEquals(
                new int[] {1, 1, 2, 3, 4, 4},
                listValues(LinkedListPractice.mergeTwoLists(list(1, 2, 4), list(1, 3, 4))));
        LinkedListPractice.ListNode cyclic = list(1, 2, 3);
        cyclic.next.next.next = cyclic.next;
        assertTrue(LinkedListPractice.hasCycle(cyclic));
        assertFalse(LinkedListPractice.hasCycle(list(1, 2, 3)));
    }

    @Test
    void treePracticeTraversesAndValidatesBinarySearchTrees() {
        TreePractice.TreeNode root = new TreePractice.TreeNode(2);
        root.left = new TreePractice.TreeNode(1);
        root.right = new TreePractice.TreeNode(3);
        assertEquals(2, TreePractice.maxDepth(root));
        assertEquals(List.of(1, 2, 3), TreePractice.inorderTraversal(root));
        assertTrue(TreePractice.isValidBST(root));
        root.right.left = new TreePractice.TreeNode(0);
        assertFalse(TreePractice.isValidBST(root));
    }

    @Test
    void graphPracticeCountsFillsAndChecksCourseDependencies() {
        assertEquals(1, GraphPractice.numIslands(new char[][] {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        }));
        assertTrue(GraphPractice.canFinish(2, new int[][] {{1, 0}}));
        assertFalse(GraphPractice.canFinish(2, new int[][] {{1, 0}, {0, 1}}));
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        assertArrayEquals(
                new int[][] {{2, 2, 2}, {2, 2, 0}, {2, 0, 1}},
                GraphPractice.floodFill(image, 1, 1, 2));
    }

    private static LinkedListPractice.ListNode list(int... values) {
        LinkedListPractice.ListNode dummy = new LinkedListPractice.ListNode(0);
        LinkedListPractice.ListNode current = dummy;
        for (int value : values) {
            current.next = new LinkedListPractice.ListNode(value);
            current = current.next;
        }
        return dummy.next;
    }

    private static int[] listValues(LinkedListPractice.ListNode head) {
        int size = 0;
        for (LinkedListPractice.ListNode node = head; node != null; node = node.next) {
            size++;
        }
        int[] values = new int[size];
        int index = 0;
        for (LinkedListPractice.ListNode node = head; node != null; node = node.next) {
            values[index++] = node.val;
        }
        return values;
    }
}
