package leetcode.dailyquestions.arrays.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/brick-wall/
 *
 * There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the
 * same height but different width. You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick
 * in this row from left to right. If your line go through the edge of a brick, then the brick is not considered as
 * crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.
 *
 * Example:
 *
 * Input: [[1,2,2,1],
 *         [3,1,2],
 *         [1,3,2],
 *         [2,4],
 *         [3,1,2],
 *         [1,3,1,1]]
 *
 * Output: 2
 *
 * Note:
 *
 * The width sum of bricks in different rows are the same and won't exceed INT_MAX.
 * The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.
 */
public class BrickWall {

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();
        List<Integer> wallRow = Arrays.asList(1, 2, 2, 1);
        wall.add(wallRow);
        wallRow = Arrays.asList(3, 1, 2);
        wall.add(wallRow);
        wallRow = Arrays.asList(1, 3, 2);
        wall.add(wallRow);
        wallRow = Arrays.asList(2, 4);
        wall.add(wallRow);
        wallRow = Arrays.asList(3, 1, 2);
        wall.add(wallRow);
        wallRow = Arrays.asList(1, 3, 1, 1);
        wall.add(wallRow);
        int count = leastBricks(wall);
        System.out.println(count);
    }

    // Time Complexity - O(n.m) where n is the number of walls and m is the number of bricks in the wall
    // Space Complexity - O(m) where m is the number of total bricks in the wall.
    public static int leastBricks(List<List<Integer>> wall) {

        int maxOccurrence = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> wallRow: wall) {
            int prefixSum = 0;
            for (int i = 0; i < wallRow.size() - 1; i++) {
                prefixSum += wallRow.get(i);
                map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
                maxOccurrence = Math.max(maxOccurrence, map.get(prefixSum));
            }
        }

        return wall.size() - maxOccurrence;
    }
}