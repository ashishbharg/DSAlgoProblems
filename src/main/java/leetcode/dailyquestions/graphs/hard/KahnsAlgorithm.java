package leetcode.dailyquestions.graphs.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.com/problems/course-schedule/
 *
 * Kahn's Algorithm is an iterative way to write topological sorting.
 *
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 *
 * Example 1:
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: true
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0. So it is possible.
 *
 * Example 2:
 * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
 * Output: false
 * Explanation: There are a total of 2 courses to take.
 * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

public class KahnsAlgorithm {

    public static void main(String[] args) {

        int numOfCourses = 4;
        int[][] prerequisites = new int[][] {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        boolean result = canFinish(numOfCourses, prerequisites);
        System.out.println(result);
        assert result;

        numOfCourses = 2;
        prerequisites = new int[][] {{1, 0}};

        result = canFinish(numOfCourses, prerequisites);
        System.out.println(result);
        assert result;

        numOfCourses = 2;
        prerequisites = new int[][] {{1, 0}, {0, 1}};

        result = canFinish(numOfCourses, prerequisites);
        System.out.println(result);
        assert !result;

    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegrees = new int[numCourses];

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {

            int[] edge = prerequisites[i];

            graph.get(edge[1]).add(edge[0]);
        }


        return canFinish(numCourses, graph);

    }

    private static boolean canFinish(int numCourses, List<List<Integer>> graph) {

        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            for (int nbr: graph.get(i)) {
                indegree[nbr]++;
            }
        }

        LinkedList<Integer> queue = new LinkedList<>();


        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }


        int idx = 0;
        while(queue.size() > 0) {
            int rem = queue.removeFirst();

            idx++;
            for (int nbr: graph.get(rem)) {
                indegree[nbr]--;

                if (indegree[nbr] == 0) {
                    queue.addLast(nbr);
                }
            }
        }

        if (idx == numCourses) {
            return true;
        } else {
            return false;
        }

    }
}
