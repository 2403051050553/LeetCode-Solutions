package com.jatinahuja.practice;

import java.util.ArrayList;
import java.util.List;

public final class MatrixPractice {
    private MatrixPractice() {
    }

    public static void rotateClockwise(int[][] matrix) {
        validateSquare(matrix);
        int size = matrix.length;
        for (int row = 0; row < size; row++) {
            for (int column = row + 1; column < size; column++) {
                int value = matrix[row][column];
                matrix[row][column] = matrix[column][row];
                matrix[column][row] = value;
            }
        }
        for (int[] row : matrix) {
            for (int left = 0, right = size - 1; left < right; left++, right--) {
                int value = row[left];
                row[left] = row[right];
                row[right] = value;
            }
        }
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int columns = matrix[0].length;
        validateRectangular(matrix, columns);
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = columns - 1;
        while (top <= bottom && left <= right) {
            for (int column = left; column <= right; column++) {
                result.add(matrix[top][column]);
            }
            top++;
            for (int row = top; row <= bottom; row++) {
                result.add(matrix[row][right]);
            }
            right--;
            if (top <= bottom) {
                for (int column = right; column >= left; column--) {
                    result.add(matrix[bottom][column]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int columns = matrix[0].length;
        validateRectangular(matrix, columns);
        if (columns == 0) {
            return;
        }
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;
        for (int column = 0; column < columns; column++) {
            firstRowHasZero |= matrix[0][column] == 0;
        }
        for (int row = 0; row < matrix.length; row++) {
            firstColumnHasZero |= matrix[row][0] == 0;
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        for (int row = 1; row < matrix.length; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }
        if (firstRowHasZero) {
            java.util.Arrays.fill(matrix[0], 0);
        }
        if (firstColumnHasZero) {
            for (int[] row : matrix) {
                row[0] = 0;
            }
        }
    }

    private static void validateSquare(int[][] matrix) {
        validateRectangular(matrix, matrix.length);
    }

    private static void validateRectangular(int[][] matrix, int columns) {
        for (int[] row : matrix) {
            if (row == null || row.length != columns) {
                throw new IllegalArgumentException("Matrix must be rectangular");
            }
        }
    }
}
