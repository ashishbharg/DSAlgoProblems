package algoexpert.graphs.normal;

import java.util.*;

/**
 * You're given a two-dimensional array of potentially unequal height and width containing only 0s and 1s. Each 0
 * represents a land, and each 1 represents part of a river. A river consists of any number of 1s that are either
 * horizontally or vertically adjacent (but not diagonally adjacent). The number of adjacent 1s forming a river
 * determine its size.
 *
 * Note that the river can twist. In other words, it doesn't have to be a straight vertical line or a straight horizontal
 * line; it can be L-shaped for example.
 *
 * Write a function that returns an array of the sizes of all rivers represented in the input matrix. The sizes don't need
 * to be in any particular order.
 *
 * Example 1:
 * matrix: [
 *     [1, 0, 0, 1, 0],
 *     [1, 0, 1, 0, 0],
 *     [0, 0, 1, 0, 1],
 *     [1, 0, 1, 0, 1],
 *     [1, 0, 1, 1, 0]
 *   ]
 * Output: [1, 2, 2, 2, 5]
 *
 * Example 2:
 * matrix: [
 *     [1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0],
 *     [1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0],
 *     [0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1],
 *     [1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0],
 *     [1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1]
 *   ]
 * Output: [2, 1, 21, 5, 2, 1]
 */
public class RiverSizes {

    public static void main(String[] args) {

        int [][] matrix = new int[][] {
                {1, 0, 0, 1, 0},
                {1, 0, 1, 0, 0},
                {0, 0, 1, 0, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 0}
        };
        List<Integer> riverSizes = riverSizes(matrix);
        System.out.println(riverSizes);
        String expected = "[2, 1, 5, 2, 2]";
        assert expected.equals(riverSizes);
        riverSizes = riverSizesV2(matrix);
        System.out.println(riverSizes);
        expected = "[2, 1, 5, 2, 2]";
        assert expected.equals(riverSizes);

        matrix = new int[][] {
                {1, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 1, 0},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1}
        };
        riverSizes = riverSizes(matrix);
        System.out.println(riverSizes);
        expected = "[2, 1, 21, 5, 2, 1]";
        assert expected.equals(riverSizes);
        riverSizes = riverSizesV2(matrix);
        System.out.println(riverSizes);
        expected = "[2, 1, 21, 5, 2, 1]";
        assert expected.equals(riverSizes);
    }

    // Time Complexity - O(m.n) | Space Complexity - O(m.n). This solution uses breadth-first approach
    public static List<Integer> riverSizes(int[][] matrix) {

        int riverCount;
        List<Integer> rivers = new ArrayList<>();
        boolean[][] visited =  new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                riverCount = bfs(matrix, i, j, visited);
                if (riverCount != 0) {
                    rivers.add(riverCount);
                }
            }
        }
        return rivers;
    }

    private static int bfs(int[][] matrix, int i, int j, boolean[][] visited) {

        int currentRiverSize = 0;
        Deque<Integer[]> nodesToExplore = new LinkedList<>();
        nodesToExplore.offerLast(new Integer[] {i, j});
        while (!nodesToExplore.isEmpty()) {
            Integer[] currentNode = nodesToExplore.pop();
            i = currentNode[0];
            j = currentNode[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            currentRiverSize++;
            List<Integer[]> unvisitedNeighbors = getUnvisitedNeighbors(i, j, matrix, visited);
            for (Integer[] neighbor : unvisitedNeighbors) {
                nodesToExplore.offerLast(neighbor);
            }
        }
        return currentRiverSize;
    }

    private static List<Integer[]> getUnvisitedNeighbors(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbors = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNeighbors.add(new Integer[] {i - 1, j});
        }
        if (j > 0 && !visited[i][j - 1]) {
            unvisitedNeighbors.add(new Integer[] {i, j - 1});
        }
        if (i < matrix.length - 1 && !visited[i + 1][j]) {
            unvisitedNeighbors.add(new Integer[] {i + 1, j});
        }
        if (j < matrix[0].length - 1 && !visited[i][j + 1]) {
            unvisitedNeighbors.add(new Integer[] {i, j + 1});
        }
        return unvisitedNeighbors;
    }

    // Time Complexity - O(m.n) | Space Complexity - O(1). This solution uses depth first search.
    public static List<Integer> riverSizesV2(int[][] matrix) {

        int riverCount;
        List<Integer> rivers = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0 || matrix[i][j] == -1) {
                    continue;
                }
                riverCount = dfs(matrix, i, j);
                rivers.add(riverCount);
            }
        }
        return rivers;
    }

    private static int dfs(int[][] matrix, int i, int j) {

        int riverCount = 0;
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return riverCount;
        }
        if (matrix[i][j] == 0 || matrix[i][j] == -1) {
            return riverCount;
        }
        matrix[i][j] = -1;
        return 1 + dfs(matrix, i + 1, j) + dfs(matrix, i, j + 1) + dfs(matrix, i - 1, j) + dfs(matrix, i, j - 1);
    }
}
