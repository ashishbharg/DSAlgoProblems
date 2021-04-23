package algoexpert.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Write a function that takes a non empty array of distinct integers and an integer representing a target sum. The function
 * should find all triplets in the array that sum up to the target sum and return a two dimensional array of all these triplets.
 * The numbers in all these triplets should be in ascending order, and the triplets themselves should be in ascending order
 * with respect to the numbers they hold.
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4], targetSum = 0
 * Output: [[-1,-1,2],[-1,0,1]]
 *
 * Example 2:
 * Input: nums = []
 * Output: []
 *
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 * Constraints:
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 */
public class ThreeNumberSum {

    public static void main(String[] args) {

        int[] array = {12, 3, 1, 2, -6, 5, -8, 6};
        int targetSum = 0;
        List<int[]> result = threeNumberSum(array, targetSum);
        int[][] expectedResult = {{-8, 2, 6}, {-8, 3, 5}, {-6, 1, 5}};
        boolean isEqual = Arrays.deepEquals(expectedResult, result.toArray());
        assert isEqual;

        array = new int[] {8, 10, -2, 49, 14};
        targetSum = 57;
        result = threeNumberSum(array, targetSum);
        expectedResult = new int[][] {{-2, 10, 49}};
        isEqual = Arrays.deepEquals(expectedResult, result.toArray());
        assert isEqual;

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 15};
        targetSum = 18;
        result = threeNumberSum(array, targetSum);
        expectedResult = new int[][] {{1, 2, 15}, {1, 8, 9}, {2, 7, 9}, {3, 6, 9}, {3, 7, 8}, {4, 5, 9}, {4, 6, 8}, {5, 6, 7}};
        isEqual = Arrays.deepEquals(expectedResult, result.toArray());
        assert isEqual;
    }

    // Time Complexity - O(n^2) | Space Complexity - O(n)
    public static List<int[]> threeNumberSum (int[] array, int targetSum) {

        Arrays.sort(array);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            int startIndex = i + 1;
            int endIndex = array.length - 1;
            while (startIndex < endIndex) {
                int currentSum = array[i] + array[startIndex] + array[endIndex];
                if (currentSum > targetSum) {
                    endIndex--;
                } else if (currentSum < targetSum) {
                    startIndex++;
                } else {
                    result.add(new int[]{array[i], array[startIndex], array[endIndex]});
                    startIndex++;
                }
            }
        }

        return result;
    }
}
