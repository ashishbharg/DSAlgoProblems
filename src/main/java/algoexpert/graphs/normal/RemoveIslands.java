package algoexpert.graphs.normal;

import java.util.*;

/**
 * You're given a two-dimensional array of potentially unequal height and width containing only 0s and 1s. The matrix represents
 * a two-toned image, wher each 0 represents white, and each 1 represents black. An island is defined as any number of
 * 1s that are either horizontally or vertically adjacent (but not diagonally adjacent) and that don't touch the border of the image.
 * In other words, a group of horizontally or vertically adjacent 1s isn't an island if any of those 1s are in the first row, last row,
 * first column or last column of the input matrix.
 *
 * Note that an island can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal
 * line; it can be L-shaped for example.
 *
 * You can think of islands as patches of black that don't touch the border of the two-toned image.
 *
 * Write a function that returns a modified version of the input matrix, where all the islands are removed. You remove an island
 * by replacing it with 0s.
 *
 * Naturally, you are allowed to mutate the input matrix.
 */
public class RemoveIslands {

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 1, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {1, 1, 0, 0, 1, 0},
                {1, 0, 1, 1, 0, 0},
                {1, 0, 0, 0, 0, 1}
        };
        removeIslands(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Time Complexity - O(m.n) | Space Complexity - O(m.n)
    public static int[][] removeIslands(int[][] matrix) {

        boolean[][] onesConnectedToBorder = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                boolean isRowBorder = i == 0 || i == matrix.length - 1;
                boolean isColBorder = j == 0 || j == matrix[0].length - 1;
                boolean isBorder = isRowBorder || isColBorder;
                if (!isBorder) {
                    continue;
                }

                if (matrix[i][j] == 0) {
                    continue;
                }
                findOnesConnectedToBorder(i, j, matrix, onesConnectedToBorder);
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (onesConnectedToBorder[i][j]) {
                    continue;
                }
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    private static void findOnesConnectedToBorder(int i, int j, int[][] matrix, boolean[][] onesConnectedToBorder) {

        Deque<Integer[]> queue = new LinkedList<>();
        queue.offerLast(new Integer[] {i, j});
        while (!queue.isEmpty()) {
            Integer[] node = queue.pop();
            i = node[0];
            j = node[1];
            if (onesConnectedToBorder[i][j]) {
                continue;
            }
            onesConnectedToBorder[i][j] = true;
            List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix);
            for (Integer[] neighbor : unvisitedNeighbors) {
                int row = neighbor[0];
                int col = neighbor[1];
                if (matrix[row][col] == 0) {
                    continue;
                }
                queue.offerLast(neighbor);
            }
        }
    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();
        if (i > 0) {
            unvisitedNeighbors.add(new Integer[] {i - 1, j});
        }
        if (i < matrix.length - 1) {
            unvisitedNeighbors.add(new Integer[] {i + 1, j});
        }
        if (j > 0) {
            unvisitedNeighbors.add(new Integer[] {i, j - 1});
        }
        if (j < matrix[0].length - 1) {
            unvisitedNeighbors.add(new Integer[] {i, j + 1});
        }
        return unvisitedNeighbors;
    }
}
