package pepcoding.recursion.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/gold-mine-2-official/ojquestion
 *
 * 1. You are given a number n, representing the number of rows.
 * 2. You are given a number m, representing the number of columns.
 * 3. You are given n*m numbers, representing elements of 2d array a, which represents a gold mine.
 * 4. You are allowed to take one step left, right, up or down from your current position.
 * 5. You can't visit a cell with 0 gold and the same cell more than once.
 * 6. Each cell has a value that is the amount of gold available in the cell.
 * 7. You are required to identify the maximum amount of gold that can be dug out from the mine if you start and stop collecting
 * gold from any position in the grid that has some gold.
 */
public class GoldMineII {

    public static void main(String[] args) {
        int[][] goldMine = new int[][] {
                {10, 0, 100, 200, 0, 8, 0},
                {20, 0, 0, 0, 0, 6, 0},
                {30, 0, 0, 9, 12, 3, 4},
                {40, 0, 2, 5, 8, 3, 11},
                {0, 0, 0, 0, 0, 9, 0},
                {5, 6, 7, 0, 7, 4, 2},
                {8, 9, 10, 0, 1, 10, 8}
        };
        int maxGold = getMaxGold(goldMine);
        System.out.println(maxGold);
    }

    private static int getMaxGold(int[][] goldMine) {

        boolean[][] visited = new boolean[goldMine.length][goldMine[0].length];
        List<Integer> bag = new ArrayList<>();
        int maxGold = 0;

        for (int i = 0; i < goldMine.length; i++) {
            for (int j = 0; j < goldMine[0].length; j++) {
                if (goldMine[i][j] != 0 && !visited[i][j]) {
                    getGold(goldMine, i, j, visited, bag);

                    int totalGold = 0;
                    for (int gold : bag) {
                        totalGold += gold;
                    }

                    maxGold = Math.max(totalGold, maxGold);
                }
                bag.clear();
            }
        }
        return maxGold;
    }

    private static void getGold(int[][] goldMine, int i, int j, boolean[][] visited, List<Integer> bag) {

        if (i < 0 || j < 0 || i >= goldMine.length || j >= goldMine[0].length || goldMine[i][j] == 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        bag.add(goldMine[i][j]);
        getGold(goldMine, i - 1, j, visited, bag); // north
        getGold(goldMine, i, j + 1, visited, bag); // east
        getGold(goldMine, i, j - 1, visited, bag); // west
        getGold(goldMine, i + 1, j, visited, bag); // south
    }
}
