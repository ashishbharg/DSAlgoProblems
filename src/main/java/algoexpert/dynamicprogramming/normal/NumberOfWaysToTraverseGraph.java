package algoexpert.dynamicprogramming.normal;

/**
 * You are given two positive integers representing the width and height of a grid-shaped, rectangular graph. Write a function
 * that returns the number of ways to reach the bottom right corner of the graph when starting at the top left corner.
 * Each move you take must either go down or right. In other words, you can never move up, or left in the graph.
 *
 * For example, given the graph illustrated below, with the width = 2, and height = 3, there are three ways to reach the
 * bottom right corner when starting at the top left corner.
 *
 *  _ _
 * |_|_|
 * |_|_|
 * |_|_|
 * 1, Down, Down, Right
 * 2. Down, Right, Down
 * 3. Right, Down, Down
 *
 * Note: you must assume that width * height >= 2. In other words, graph will never be a 1x1 grid.
 */
public class NumberOfWaysToTraverseGraph {

    public static void main(String[] args) {
        int numberOfWaysToTraverseGraph = numberOfWaysToTraverseGraph(4, 3);
        assert 10 == numberOfWaysToTraverseGraph;

        numberOfWaysToTraverseGraph = numberOfWaysToTraverseGraph(5, 9);
        assert 495 == numberOfWaysToTraverseGraph;

        numberOfWaysToTraverseGraph = numberOfWaysToTraverseGraph(5, 5);
        assert 70 == numberOfWaysToTraverseGraph;

        numberOfWaysToTraverseGraph = numberOfWaysToTraverseGraph(5, 6);
        assert 126 == numberOfWaysToTraverseGraph;
    }

    //Time Complexity - O(n.m) | Space Complexity - O(n.m)
    public static int numberOfWaysToTraverseGraph(int width, int height) {

        int[][] graph = new int[height][width];
        for (int i = 0; i < height; i++) {
            graph[i][0] = 1;
        }

        for (int j = 0; j < width; j++) {
            graph[0][j] = 1;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                graph[i][j] = graph[i - 1][j] + graph[i][j - 1];
            }
        }
        return graph[height - 1][width - 1];
    }
}
