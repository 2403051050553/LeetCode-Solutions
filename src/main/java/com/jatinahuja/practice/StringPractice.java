package com.jatinahuja.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class StringPractice {
    private StringPractice() {
    }

    public static boolean isAnagram(String first, String second) {
        if (first.length() != second.length()) {
            return false;
        }
        Map<Character, Integer> counts = new HashMap<>();
        for (char value : first.toCharArray()) {
            counts.merge(value, 1, Integer::sum);
        }
        for (char value : second.toCharArray()) {
            Integer count = counts.get(value);
            if (count == null) {
                return false;
            }
            if (count == 1) {
                counts.remove(value);
            } else {
                counts.put(value, count - 1);
            }
        }
        return counts.isEmpty();
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String word : words) {
            char[] letters = word.toCharArray();
            java.util.Arrays.sort(letters);
            groups.computeIfAbsent(new String(letters), ignored -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(groups.values());
    }

    public static int longestSubstringLength(String value) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int start = 0;
        int best = 0;
        for (int end = 0; end < value.length(); end++) {
            char current = value.charAt(end);
            if (lastSeen.containsKey(current)) {
                start = Math.max(start, lastSeen.get(current) + 1);
            }
            lastSeen.put(current, end);
            best = Math.max(best, end - start + 1);
        }
        return best;
    }

    public static String longestCommonPrefix(String[] words) {
        if (words.length == 0) {
            return "";
        }
        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (!words[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    public static boolean isValidParentheses(String value) {
        char[] openings = new char[value.length()];
        int size = 0;
        for (char current : value.toCharArray()) {
            if (current == '(' || current == '[' || current == '{') {
                openings[size++] = current;
            } else {
                if (current != ')' && current != ']' && current != '}') {
                    return false;
                }
                if (size == 0) {
                    return false;
                }
                char opening = openings[--size];
                if ((current == ')' && opening != '(')
                        || (current == ']' && opening != '[')
                        || (current == '}' && opening != '{')) {
                    return false;
                }
            }
        }
        return size == 0;
    }

    public static String reverseWords(String value) {
        String[] words = value.trim().split("\\s+");
        if (words.length == 1 && words[0].isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (result.length() > 0) {
                result.append(' ');
            }
            result.append(words[i]);
        }
        return result.toString();
    }

    public static int firstUniqueCharacterIndex(String value) {
        int[] counts = new int[Character.MAX_VALUE + 1];
        for (char current : value.toCharArray()) {
            counts[current]++;
        }
        for (int i = 0; i < value.length(); i++) {
            if (counts[value.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static String minWindow(String source, String target) {
        if (target.isEmpty() || source.length() < target.length()) {
            return "";
        }
        Map<Character, Integer> needed = new HashMap<>();
        for (char current : target.toCharArray()) {
            needed.merge(current, 1, Integer::sum);
        }
        int missing = target.length();
        int start = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;
        for (int end = 0; end < source.length(); end++) {
            char added = source.charAt(end);
            if (needed.getOrDefault(added, 0) > 0) {
                missing--;
            }
            needed.put(added, needed.getOrDefault(added, 0) - 1);
            while (missing == 0) {
                if (end - start + 1 < bestLength) {
                    bestStart = start;
                    bestLength = end - start + 1;
                }
                char removed = source.charAt(start++);
                needed.put(removed, needed.getOrDefault(removed, 0) + 1);
                if (needed.get(removed) > 0) {
                    missing++;
                }
            }
        }
        return bestLength == Integer.MAX_VALUE
                ? ""
                : source.substring(bestStart, bestStart + bestLength);
    }
}
