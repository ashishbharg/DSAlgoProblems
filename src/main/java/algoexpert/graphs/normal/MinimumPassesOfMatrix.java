package algoexpert.graphs.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Write a function that takes in an integer matrix of potentially unequal height and width and returns the minimum
 * number of passes required to convert all negative integers in the matrix to positive integers.
 *
 * A negative integer in the matrix can only be converted to a positive integer if one or more of its adjacent elements
 * is positive. An adjacent element is an element that is to the left, to the right, above, or below the current element
 * in the matrix. Converting a negative to a positive simply involves multiplying it by -1.
 *
 * Note that the 0 value is neither negative nor positive, meaning that a 0 can't convert an adjacent negative to positive.
 *
 * A single pass through the matrix involves converting all the negative integers that can be converted at a particular
 * point in time.
 *
 * Example:
 * matrix: [
 *  [0, -2, -1],
 *  [-5, 2, 0],
 *  [-6, -2, 0]
 * ]
 * Output: 2
 * Explanation:
 * After first pass, only 2 values can be converted to positives:
 * [
 *  [0, 2, -1],
 *  [5, 2, 0],
 *  [-6, 2, 0]
 * ]
 * After second pass, the remaining negatives will be converted to positives:
 * [
 *  [0, 2, 1],
 *  [5, 2, 0],
 *  [6, 2, 0]
 * ]
 */
public class MinimumPassesOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {0, -1, -3, 2, 0},
                {1, -2, -5, -1, -3},
                {3, 0, 0, -4, -1}
        };
        int minimumPasses = minimumPassesOfMatrix(matrix);
        assert 3 == minimumPasses;

        matrix = new int[][] {
                {1, 0, 0, -2, -3},
                {-4, -5, -6, -2, -1},
                {0, 0, 0, 0, -1},
                {1, 2, 3, 0, -2}
        };
        minimumPasses = minimumPassesOfMatrix(matrix);
        assert 7 == minimumPasses;

        matrix = new int[][] {
                {1, 0, 0, -2, -3},
                {-4, -5, -6, -2, -1},
                {0, 0, 0, 0, -1},
                {-1, 0, 3, 0, 3}
        };
        minimumPasses = minimumPassesOfMatrix(matrix);
        assert -1 == minimumPasses;

        matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6}
        };
        minimumPasses = minimumPassesOfMatrix(matrix);
        assert 0 == minimumPasses;
    }

    // Time Complexity - O(w * h) | Space Complexity - O(w * h) where w is the width of matrix and h is height of the matrix.
    public static int minimumPassesOfMatrix(int[][] matrix) {

        int passes = convertNegativeIndices(matrix);
        return containsNegativeIndex(matrix) ? -1 : passes;
    }

    private static int convertNegativeIndices(int[][] matrix) {

        Queue<Integer[]> nextPassQueue = fetchPositiveNumberIndices(matrix);
        int passes = 0;

        while (!nextPassQueue.isEmpty()) {
            Queue<Integer[]> currentPassQueue = nextPassQueue;
            nextPassQueue = new LinkedList<>();

            while (!currentPassQueue.isEmpty()) {
                Integer[] currentPosition = currentPassQueue.poll();
                int currentRow = currentPosition[0];
                int currentCol = currentPosition[1];

                List<Integer[]> adjacentPositions = getAdjacentPositions(currentRow, currentCol, matrix);

                for (Integer[] position: adjacentPositions) {
                    int i = position[0];
                    int j = position[1];

                    if (matrix[i][j] < 0) {
                        nextPassQueue.offer(new Integer[] {i, j});
                        matrix[i][j] *= -1;
                    }
                }
            }
            passes++;
        }

        return passes - 1;
    }

    private static List<Integer[]> getAdjacentPositions(int currentRow, int currentCol, int[][] matrix) {

        List<Integer[]> adjacentPositions = new ArrayList<>();

        if (currentRow > 0) {
            adjacentPositions.add(new Integer[] {currentRow - 1, currentCol});
        }

        if (currentRow < matrix.length - 1) {
            adjacentPositions.add(new Integer[] {currentRow + 1, currentCol});
        }

        if (currentCol > 0) {
            adjacentPositions.add(new Integer[] {currentRow, currentCol - 1});
        }

        if (currentCol < matrix[0].length - 1) {
            adjacentPositions.add(new Integer[] {currentRow, currentCol + 1});
        }
        return adjacentPositions;
    }

    private static Queue<Integer[]> fetchPositiveNumberIndices(int[][] matrix) {

        Queue<Integer[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    queue.offer(new Integer[]{i, j});
                }
            }
        }

        return queue;
    }

    private static boolean containsNegativeIndex(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
