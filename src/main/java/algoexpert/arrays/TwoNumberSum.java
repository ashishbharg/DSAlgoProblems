package algoexpert.arrays;

import java.util.Arrays;

/**
 * Given an array of integers nums and an integer target, return two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 *
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 *
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 */
public class TwoNumberSum {

    public static void main(String[] args) {

        TwoNumberSum tws = new TwoNumberSum();
        int[] result = tws.twoNumberSum(new int[]{2, 7, 11, 15}, 9);
        assert "[2, 7]".equals(Arrays.toString(result));

        result = tws.twoNumberSum(new int[]{3, 2, 4}, 6);
        assert "[2, 4]".equals(Arrays.toString(result));

        result = tws.twoNumberSum(new int[]{3, 3}, 6);
        assert "[3, 3]".equals(Arrays.toString(result));

        result = tws.twoNumberSum(new int[]{3, 5, -4, 8, 11, 1, -1, 6}, 10);
        assert "[-1, 11]".equals(Arrays.toString(result));

        result = tws.twoNumberSum(new int[]{14}, 14);
        assert "[-1, -1]".equals(Arrays.toString(result));

    }

    public int[] twoNumberSum(int[] array, int targetSum) {

        int[] result = new int[] {-1, -1};

        Arrays.sort(array);

        int i = 0;
        int j = array.length - 1;

        while (i < j) {
            if (array[i] + array[j] < targetSum) {
                i++;
            } else if (array[i] + array[j] > targetSum) {
                j--;
            } else {
                return new int[] {array[i], array[j]};
            }
        }

        return result;
    }
}
