package leetcode.dailyquestions.dynamicprogramming.medium;


import java.util.Arrays;

/**
 * https://leetcode.com/problems/coloring-a-border/
 *
 * You are given an m x n integer matrix grid, and three integers row, col, and color. Each value in the grid represents
 * the color of the grid square at that location.
 *
 * Two squares belong to the same connected component if they have the same color and are next to each other in any of the 4 directions.
 *
 * The border of a connected component is all the squares in the connected component that are either 4-directionally
 * adjacent to a square not in the component, or on the boundary of the grid (the first or last row or column).
 *
 * You should color the border of the connected component that contains the square grid[row][col] with color.
 *
 * Return the final grid.
 *
 *
 * Example 1:
 * Input: grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
 * Output: [[3,3],[3,2]]
 *
 * Example 2:
 * Input: grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
 * Output: [[1,3,3],[2,3,3]]
 *
 * Example 3:
 * Input: grid = [[1,1,1],[1,1,1],[1,1,1]], row = 1, col = 1, color = 2
 * Output: [[2,2,2],[2,1,2],[2,2,2]]
 */
public class ColoringABorder {

    public static void main(String[] args) {

        int[][] grid = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        int row = 1, col = 1, color = 2;

        colorBorder(grid, row, col, color);
        System.out.println(Arrays.deepToString(grid));
    }

    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {

        dfs(grid, row, col, grid[row][col]);

        for(int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    static int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private static void dfs(int[][] grid, int row, int col, int color) {

        int count = 0;

        grid[row][col] = -color;

        for(int[] dir: dirs) {
            int rowDash = row + dir[0];
            int colDash = col + dir[1];

            if (rowDash < 0 || colDash < 0 || rowDash >= grid.length || colDash >= grid[0].length || Math.abs(grid[rowDash][colDash]) != color) {
                continue;
            }

            count++;

            if (grid[rowDash][colDash] > 0) {
                dfs(grid, rowDash, colDash, color);
            }

        }

        if (count == 4) {
            grid[row][col] = color;
        }
    }
}
