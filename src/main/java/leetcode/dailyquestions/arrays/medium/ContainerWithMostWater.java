package leetcode.dailyquestions.arrays.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines
 * are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with
 * the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of
 * water the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Example 3:
 * Input: height = [4,3,2,1,4]
 * Output: 16
 *
 * Example 4:
 * Input: height = [1,2,1]
 * Output: 2
 */

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = new int[] {1,8,6,2,5,4,8,3,7};
        int maxArea = maxArea(height);
        System.out.println(maxArea);
        assert 49 == maxArea;

        height = new int[] {1,1};
        maxArea = maxArea(height);
        System.out.println(maxArea);
        assert 1 == maxArea;

        height = new int[] {4,3,2,1,4};
        maxArea = maxArea(height);
        System.out.println(maxArea);
        assert 16 == maxArea;

        height = new int[] {1,2,1};
        maxArea = maxArea(height);
        System.out.println(maxArea);
        assert 2 == maxArea;
    }

    public static int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;

        int maxArea = Integer.MIN_VALUE;
        int currentArea;
        while (i < j) {

            currentArea = Math.min(height[i], height[j]) * (j - i);

            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

            maxArea = Math.max(maxArea, currentArea);
        }
        return maxArea;
    }
}
