package leetcode.dailyquestions.arrays.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/rotate-image/
 *
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
 *
 * Example 1:
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 *
 *  Example 2:
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 *
 *  Example 3:
 * Input: matrix = [[1]]
 * Output: [[1]]
 *
 * Example 4:
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 *
 * Constraints:
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateArray {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        String expected = "[[7, 4, 1], [8, 5, 2], [9, 6, 3]]";
        assert expected.equals(Arrays.deepToString(matrix));

        matrix = new int[][] {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        expected = "[[15, 13, 2, 5], [14, 3, 4, 1], [12, 6, 8, 9], [16, 7, 10, 11]]";
        assert expected.equals(Arrays.deepToString(matrix));

        matrix = new int[][] {{1}};
        rotate(matrix);
        expected = "[[1]]";
        assert expected.equals(Arrays.deepToString(matrix));

        matrix = new int[][] {{1,2},{3,4}};
        rotate(matrix);
        expected = "[[3, 1], [4, 2]]";
        assert expected.equals(Arrays.deepToString(matrix));
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static void rotate(int[][] matrix) {

        // transpose the array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse the array
        for (int i = 0; i < matrix.length; i++) {
            int li = 0;
            int ri = matrix.length - 1;
            while (li < ri) {
                int temp = matrix[i][li];
                matrix[i][li] = matrix[i][ri];
                matrix[i][ri] = temp;
                li++;
                ri--;
            }
        }
    }
}
