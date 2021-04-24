package leetcode.dailyquestions.arrays.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/
 *
 * Given a matrix and a target, return the number of non-empty submatrices that sum to target.
 *
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x <= x2 and y1 <= y <= y2.
 *
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if they have some coordinate that is different: for example, if x1 != x1'.
 *
 * Example 1:
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * Output: 4
 * Explanation: The four 1x1 submatrices that only contain 0.
 *
 * Example 2:
 * Input: matrix = [[1,-1],[-1,1]], target = 0
 * Output: 5
 * Explanation: The two 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 *
 * Example 3:
 * Input: matrix = [[904]], target = 0
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= matrix.length <= 100
 * 1 <= matrix[0].length <= 100
 * -1000 <= matrix[i] <= 1000
 * -10^8 <= target <= 10^8
 *
 * Time Complexity: O(n^2.m) where n is number of column and m is number of row
 * Space Complexity: O(m) where m is the number of rows
 *
 * Reference for understanding: https://www.youtube.com/watch?v=elADMOC_hDI&t=610s
 */
public class SubmatricesEqualToTarget {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        int count = SubmatricesEqualToTarget.countSubMatricesEqualToTargetSum(matrix, 4);
        assert count == 17;

        matrix = new int[][] {{0,1,0},{1,1,1},{0,1,0}};
        count = SubmatricesEqualToTarget.countSubMatricesEqualToTargetSum(matrix, 0);
        assert count == 4;

        matrix = new int[][] {{1,-1},{-1,1}};
        count = SubmatricesEqualToTarget.countSubMatricesEqualToTargetSum(matrix, 0);
        assert count == 5;

        matrix = new int[][] {{904}};
        count = SubmatricesEqualToTarget.countSubMatricesEqualToTargetSum(matrix, 0);
        assert count == 0;

    }

    public static int countSubMatricesEqualToTargetSum(int[][] matrix, int target) {

        int rowLength = matrix.length, colLength = matrix[0].length;

        for (int row = 0;row < rowLength; row++) {
            for (int col = 1;col < colLength; col++) {
                matrix[row][col] += matrix[row][col - 1];
            }
        }

        int count = 0;

        for (int startCol = 0; startCol < colLength; startCol++) {
            for (int currCol = startCol; currCol < colLength; currCol++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int sum = 0;

                for (int row = 0; row < rowLength; row++) {
                    sum += matrix[row][currCol] - (startCol > 0 ? matrix[row][startCol -1] : 0);
                    count += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
            }
        }
        return count;
    }
}
