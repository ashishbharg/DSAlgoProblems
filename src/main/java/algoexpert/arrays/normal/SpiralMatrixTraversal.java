package algoexpert.arrays.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes in an n x m two dimensional array and returns a one dimensional array of all the array's elements
 * in spiral order.
 *
 * Spiral order starts at the top left corner of the two dimensional array, goes to the right, and proceeds in a spiral
 * pattern all the way until every element has been visited.
 *
 * Example:
 * array: [
 *     [1, 2, 3, 4],
 *     [12, 13, 14, 5],
 *     [11, 16, 15, 6],
 *     [10, 9, 8, 7]
 *   ]
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
 */
public class SpiralMatrixTraversal {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        List<Integer> result = spiralTraverse(matrix);
        String expected = "[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]";
        assert expected.equals(Arrays.toString(result.toArray()));

        matrix = new int[][] {
                {19, 32, 33, 34, 25, 8},
                {16, 15, 14, 13, 12, 11},
                {18, 31, 36, 35, 26, 9},
                {1, 2, 3, 4, 5, 6},
                {20, 21, 22, 23, 24, 7},
                {17, 30, 29, 28, 27, 10}
        };
        result = spiralTraverse(matrix);
        expected = "[19, 32, 33, 34, 25, 8, 11, 9, 6, 7, 10, 27, 28, 29, 30, 17, 20, 1, 18, 16, 15, 14, 13, 12, 26, 5, 24, 23, 22, 21, 2, 31, 36, 35, 4, 3]";
        assert expected.equals(Arrays.toString(result.toArray()));

        matrix = new int[][] {
                {27, 12, 35, 26},
                {25, 21, 94, 11},
                {19, 96, 43, 56},
                {55, 36, 10, 18},
                {96, 83, 31, 94},
                {93, 11, 90, 16}
        };
        result = spiralTraverse(matrix);
        expected = "[27, 12, 35, 26, 11, 56, 18, 94, 16, 90, 11, 93, 96, 55, 19, 25, 21, 94, 43, 10, 31, 83, 36, 96]";
        assert expected.equals(Arrays.toString(result.toArray()));
    }

    // Time Complexity - O(m.n) | Space Complexity - O(m.n)
    public static List<Integer> spiralTraverse(int[][] array) {

        int startRow = 0;
        int startCol = 0;
        int endRow = array.length - 1;
        int endCol = array[0].length - 1;

        List<Integer> result = new ArrayList<>();
        while (true) {
            for (int j = startCol; j <= endCol; j++) {
                result.add(array[startRow][j]);
            }
            for (int i = startRow + 1; i <= endRow; i++) {
                result.add(array[i][endCol]);
            }
            for (int j = endCol - 1; j >= startCol; j--) {
                if (startRow == endRow) {
                    break;
                }
                result.add(array[endRow][j]);
            }
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol){
                    break;
                }
                result.add(array[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;

            if (startRow > endRow || startCol > endCol) {
                break;
            }
        }
        return result;
    }
}
