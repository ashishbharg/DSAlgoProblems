package leetcode.dailyquestions.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

public class SpiralMatrix {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1,2,3},
                                      {4,5,6},
                                      {7,8,9}};
        List<Integer> result = spiralOrder(matrix);
        System.out.println(result);
        Integer[] expected = new Integer[] {1,2,3,6,9,8,7,4,5};
        assert Arrays.deepEquals(result.toArray(new Integer[result.size()]), expected);

        matrix = new int[][] {{1,2,3,4},
                              {5,6,7,8},
                              {9,10,11,12}};
        result = spiralOrder(matrix);
        System.out.println(result);
        expected = new Integer[] {1,2,3,4,8,12,11,10,9,5,6,7};
        assert Arrays.deepEquals(result.toArray(new Integer[result.size()]), expected);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> ans = new ArrayList<Integer>();
        spiralOrder(matrix, 0, 0, matrix.length - 1, matrix[0].length - 1, ans);

        return ans;
    }

    private static void spiralOrder(int[][]matrix, int startI, int startJ, int endI, int endJ, List<Integer> ans) {

        while(true) {

            for (int j = startJ; j <= endJ; j++) {
                ans.add(matrix[startI][j]);
            }

            for (int i = startI + 1; i <= endI; i++) {
                ans.add(matrix[i][endJ]);
            }

            if (startI >= endI || startJ >= endJ) {
                break;
            }

            for (int j = endJ - 1; j >= startJ; j--) {
                ans.add(matrix[endI][j]);
            }

            for (int i = endI - 1; i >= startI + 1; i--) {
                ans.add(matrix[i][startJ]);
            }

            startI++;
            startJ++;
            endI--;
            endJ--;

            if (startI > endI || startJ > endJ) {
                break;
            }
        }

    }
}
