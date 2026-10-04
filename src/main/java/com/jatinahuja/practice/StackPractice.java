package com.jatinahuja.practice;

import java.util.ArrayDeque;
import java.util.Deque;

public final class StackPractice {
    private StackPractice() {
    }

    public static int[] dailyTemperatures(int[] temperatures) {
        int[] days = new int[temperatures.length];
        Deque<Integer> waiting = new ArrayDeque<>();
        for (int day = 0; day < temperatures.length; day++) {
            while (!waiting.isEmpty() && temperatures[waiting.peek()] < temperatures[day]) {
                int previous = waiting.pop();
                days[previous] = day - previous;
            }
            waiting.push(day);
        }
        return days;
    }

    public static int evalRPN(String[] tokens) {
        Deque<Integer> numbers = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int right = numbers.pop();
                int left = numbers.pop();
                switch (token) {
                    case "+" -> numbers.push(left + right);
                    case "-" -> numbers.push(left - right);
                    case "*" -> numbers.push(left * right);
                    default -> numbers.push(left / right);
                }
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return numbers.pop();
    }

    public static String simplifyPath(String path) {
        Deque<String> folders = new ArrayDeque<>();
        for (String part : path.split("/")) {
            if (part.isEmpty() || part.equals(".")) {
                continue;
            }
            if (part.equals("..")) {
                if (!folders.isEmpty()) {
                    folders.removeLast();
                }
            } else {
                folders.addLast(part);
            }
        }
        return "/" + String.join("/", folders);
    }

    public static String removeKdigits(String number, int removals) {
        Deque<Character> digits = new ArrayDeque<>();
        for (char digit : number.toCharArray()) {
            while (removals > 0 && !digits.isEmpty() && digits.peekLast() > digit) {
                digits.removeLast();
                removals--;
            }
            digits.addLast(digit);
        }
        while (removals > 0 && !digits.isEmpty()) {
            digits.removeLast();
            removals--;
        }
        StringBuilder result = new StringBuilder();
        while (!digits.isEmpty() && digits.peekFirst() == '0') {
            digits.removeFirst();
        }
        for (char digit : digits) {
            result.append(digit);
        }
        return result.length() == 0 ? "0" : result.toString();
    }
}
