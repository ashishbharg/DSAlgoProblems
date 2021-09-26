package leetcode.dailyquestions.graphs.hard;

import java.util.Arrays;
import java.util.LinkedList;

public class ShortestPathInGridWithObstaclesElimination {

    public static void main(String[] args) {
        ShortestPathInGridWithObstaclesElimination obj = new ShortestPathInGridWithObstaclesElimination();

        int [][] grid = new int [][] {{0,0,0},{1,1,0},{0,0,0},{0,1,1},{0,0,0}};
        int k = 1;
        int result = obj.shortestPath(grid, k);
        System.out.println(result);
        assert 6 == result;

        grid = new int [][] {{0,1,1}, {1,1,1}, {1,0,0}};
        k = 1;
        result = obj.shortestPath(grid, k);
        System.out.println(result);
        assert -1 == result;
    }

    public int shortestPath(int[][] grid, int k) {

        return bfs(0, 0, k, grid);
    }

    int[][] dirs = new int[][] {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    private int bfs(int row, int col, int k, int[][] grid) {

        LinkedList<Pair> queue = new LinkedList<>();

        queue.addLast(new Pair(row, col, k, 0));
        int ans = 0;
        int[][] lives = new int[grid.length][grid[0].length];


        for(int[] life: lives) {
            Arrays.fill(life, -1);
        }

        while(queue.size() > 0) {

            Pair pair = queue.removeFirst();


            if (pair.row == grid.length - 1 && pair.col == grid[0].length - 1) {
                return pair.dist;
            }


            int currLives = pair.k;

            if (grid[pair.row][pair.col] == 1) {
                currLives -= 1;
            }

            for (int[] dir: dirs) {
                int rowDash = pair.row + dir[0];
                int colDash = pair.col + dir[1];

                if (rowDash < 0 || colDash < 0 || rowDash >= grid.length || colDash >= grid[0].length || lives[rowDash][colDash] >= currLives ) {
                    continue;
                }
                queue.addLast(new Pair(rowDash, colDash, currLives, pair.dist + 1));
                lives[rowDash][colDash] = currLives;
            }

        }

        return -1;
    }

    class Pair {
        int row;
        int col;
        int k;
        int dist;

        Pair(int row, int col, int k, int dist) {
            this.row = row;
            this.col = col;
            this.k = k;
            this.dist = dist;
        }
    }
}
