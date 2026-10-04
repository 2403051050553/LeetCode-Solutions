package com.jatinahuja.practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public final class GraphPractice {
    private GraphPractice() {
    }

    public static int numIslands(char[][] grid) {
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == '1') {
                    islands++;
                    sinkIsland(grid, row, column);
                }
            }
        }
        return islands;
    }

    public static boolean canFinish(int courseCount, int[][] prerequisites) {
        List<List<Integer>> nextCourses = new ArrayList<>();
        int[] incoming = new int[courseCount];
        for (int i = 0; i < courseCount; i++) {
            nextCourses.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            nextCourses.get(prerequisite[1]).add(prerequisite[0]);
            incoming[prerequisite[0]]++;
        }
        Deque<Integer> ready = new ArrayDeque<>();
        for (int course = 0; course < courseCount; course++) {
            if (incoming[course] == 0) {
                ready.addLast(course);
            }
        }
        int completed = 0;
        while (!ready.isEmpty()) {
            int course = ready.removeFirst();
            completed++;
            for (int next : nextCourses.get(course)) {
                if (--incoming[next] == 0) {
                    ready.addLast(next);
                }
            }
        }
        return completed == courseCount;
    }

    public static int[][] floodFill(int[][] image, int startRow, int startColumn, int color) {
        int oldColor = image[startRow][startColumn];
        if (oldColor == color) {
            return image;
        }
        fill(image, startRow, startColumn, oldColor, color);
        return image;
    }

    private static void sinkIsland(char[][] grid, int row, int column) {
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length
                || grid[row][column] != '1') {
            return;
        }
        grid[row][column] = '0';
        sinkIsland(grid, row - 1, column);
        sinkIsland(grid, row + 1, column);
        sinkIsland(grid, row, column - 1);
        sinkIsland(grid, row, column + 1);
    }

    private static void fill(int[][] image, int row, int column, int oldColor, int color) {
        if (row < 0 || row >= image.length || column < 0 || column >= image[row].length
                || image[row][column] != oldColor) {
            return;
        }
        image[row][column] = color;
        fill(image, row - 1, column, oldColor, color);
        fill(image, row + 1, column, oldColor, color);
        fill(image, row, column - 1, oldColor, color);
        fill(image, row, column + 1, oldColor, color);
    }
}
