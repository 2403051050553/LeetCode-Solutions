package com.jatinahuja.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class BacktrackingPractice {
    private BacktrackingPractice() {
    }

    public static List<List<Integer>> subsets(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        makeSubsets(numbers, 0, new ArrayList<>(), result);
        return result;
    }

    public static List<List<Integer>> permutations(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        makePermutations(numbers, new boolean[numbers.length], new ArrayList<>(), result);
        return result;
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int[] sorted = candidates.clone();
        for (int candidate : candidates) {
            if (candidate <= 0) {
                throw new IllegalArgumentException("Candidates must be positive");
            }
        }
        Arrays.sort(sorted);
        List<List<Integer>> result = new ArrayList<>();
        makeCombinations(sorted, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static List<String> generateParenthesis(int pairs) {
        if (pairs < 0) {
            throw new IllegalArgumentException("Pair count must not be negative");
        }
        List<String> result = new ArrayList<>();
        makeParentheses(pairs, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void makeSubsets(
            int[] numbers, int index, List<Integer> current, List<List<Integer>> result) {
        if (index == numbers.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        makeSubsets(numbers, index + 1, current, result);
        current.add(numbers[index]);
        makeSubsets(numbers, index + 1, current, result);
        current.remove(current.size() - 1);
    }

    private static void makePermutations(
            int[] numbers, boolean[] used, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == numbers.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                current.add(numbers[i]);
                makePermutations(numbers, used, current, result);
                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    private static void makeCombinations(
            int[] candidates, int remaining, int start,
            List<Integer> current, List<List<Integer>> result) {
        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length && candidates[i] <= remaining; i++) {
            current.add(candidates[i]);
            makeCombinations(candidates, remaining - candidates[i], i, current, result);
            current.remove(current.size() - 1);
        }
    }

    private static void makeParentheses(
            int pairs, int opened, int closed, StringBuilder current, List<String> result) {
        if (current.length() == pairs * 2) {
            result.add(current.toString());
            return;
        }
        if (opened < pairs) {
            current.append('(');
            makeParentheses(pairs, opened + 1, closed, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        if (closed < opened) {
            current.append(')');
            makeParentheses(pairs, opened, closed + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
