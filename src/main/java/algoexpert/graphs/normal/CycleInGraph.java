package algoexpert.graphs.normal;

/**
 * You're given a list of edges representing an unweighted, directed graph with at least one node. Write a function that
 * returns a boolean representing whether the given graph contains a cycle.
 *
 * For the purpose of this question, a cycle is defined as any number of vertices, including just one vertex, that are
 * connected in a closed chain. A cycle can also be defined as a chain of at least one vertex in which the first vertex is
 * the same as the last.
 *
 * The given list is what's called an adjacency  list, and it represents a graph. The number of vertices in the graph is
 * equal to the length of edges, where each index i in edges contains vertex i's outbound edges, in no particular order.
 * Each individual edge is represented by a positive integer that denotes an index (a destination vertex) in the list that
 * this vertex is connected to. Note that these edges are directed, meaning that you can travel from a particular vertex
 * to its destination, not the other way around (unless the destination vertex itself has an outbound edge to the original
 * vertex).
 *
 * Also note that this graph may contain self-loops. A self-loop edge is an edge that has the same destination and origin;
 * in other words, it's an edge that connects a vertex to itself. For the purpose of this question, a self loop is considered
 * a cycle.
 *
 * Example:
 * edges: [
 *     [1, 3],
 *     [2, 3, 4],
 *     [0],
 *     [],
 *     [2, 5],
 *     []
 *   ]
 * Output: true
 * Explanation: There are multiple cycles in this graph.
 *   1. 0 -> 1 -> 2 -> 0
 *   2. 0 -> 1 -> 4 -> 2 -> 0
 *   3. 1 -> 2 -> 0 -> 1
 *   These are just 3 examples, there are more.
 */
public class CycleInGraph {

    public static void main(String[] args) {
        int[][] edges = new int[][] {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
        };
        boolean isCycleInGraph = cycleInGraph(edges);
        assert isCycleInGraph;

        edges = new int[][] {
                {1},
                {2, 3, 4, 5, 6, 7},
                {},
                {2, 7},
                {5},
                {},
                {4},
                {}
        };
        isCycleInGraph = cycleInGraph(edges);
        assert !isCycleInGraph;
    }

    // Time Complexity - O(v+e) | Space Complexity - O(v)
    public static boolean cycleInGraph(int[][] edges) {

        int numberOfEdges = edges.length;
        boolean[] visited = new boolean[numberOfEdges];
        boolean[] currentlyInStack = new boolean[numberOfEdges];

        for (int i = 0; i < numberOfEdges; i++) {
            if (visited[i]) {
                continue;
            }

            boolean containsCycle = isNodeInCycle(i, edges, visited, currentlyInStack);
            if (containsCycle) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNodeInCycle(int i, int[][] edges, boolean[] visited, boolean[] currentlyInStack) {
        visited[i] = true;
        currentlyInStack[i] = true;

        boolean containsCycle = false;
        int[] neighbors = edges[i];
        for (int neighbor : neighbors) {
            if (!visited[neighbor]) {
                containsCycle = isNodeInCycle(neighbor, edges, visited, currentlyInStack);
            }
            if (containsCycle) {
                return true;
            } else if (currentlyInStack[neighbor]) {
                return true;
            }
        }

        currentlyInStack[i] = false;
        return false;
    }
}
