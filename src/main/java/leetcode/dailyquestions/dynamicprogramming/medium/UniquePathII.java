package leetcode.dailyquestions.dynamicprogramming.medium;

/**
 * https://leetcode.com/problems/unique-paths-ii/
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner
 * of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be? An obstacle and space
 * is marked as 1 and 0 respectively in the grid.
 *
 * Example 1:
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Example 2:
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 * Constraints:
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
public class UniquePathII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int result = uniquePathsWithObstacles(obstacleGrid);
        assert result == 2;

        obstacleGrid = new int[][] {{1,0}};
        result = uniquePathsWithObstacles(obstacleGrid);
        assert result == 0;
    }

    // Time Complexity - O(n) | Space Complexity - O(1) where n is the number of elements in the matrix
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        for (int j = 0; j < cols; j++) {
            if (obstacleGrid[0][j] == 1 || (j > 0 && obstacleGrid[0][j - 1] == -1)) {
                obstacleGrid[0][j] = -1;
            } else {
                obstacleGrid[0][j] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            if (obstacleGrid[i][0] == 1 || (i > 0 && obstacleGrid[i - 1][0] == -1)) {
                obstacleGrid[i][0] = -1;
            } else {
                obstacleGrid[i][0] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = -1;
                    continue;
                }
                if (obstacleGrid[i - 1][j] == -1 || obstacleGrid[i][j - 1] == -1) {
                    obstacleGrid[i][j] = Math.max(obstacleGrid[i - 1][j], obstacleGrid[i][j - 1]);
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[rows - 1][cols - 1] == -1 ? 0 : obstacleGrid[rows - 1][cols - 1];
    }
}
