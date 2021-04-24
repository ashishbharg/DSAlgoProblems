package leetcode.dailyquestions.dynamicprogramming.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/combination-sum-iv/
 *
 * Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.
 *
 * The answer is guaranteed to fit in a 32-bit integer.

 * Example 1:
 * Input: nums = [1,2,3], target = 4
 * Output: 7
 * Explanation:
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * Note that different sequences are counted as different combinations.
 *
 * Example 2:
 * Input: nums = [9], target = 3
 * Output: 0
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * All the elements of nums are unique.
 * 1 <= target <= 1000
 *
 * Follow up: What if negative numbers are allowed in the given array? How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 */
public class FindAllCombinationsEqualToTargetSum {

    public static void main(String[] args) {

        int[] nums = new int[] {1,2,3};
        int target = 4;
        int count = combinationSum4(nums, target);
        assert count == 7;

        nums = new int[] {9};
        target = 3;
        count = combinationSum4(nums, target);
        assert count == 0;
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static int combinationSum4(int[] nums, int target) {

        Arrays.sort(nums);
        Integer[] memoize = new Integer[target + 1];
        memoize[0] = 1;
        return combinationSum4(nums, target, memoize);
    }

    public static int combinationSum4(int[] nums, int target, Integer[] memoize) {
        if (target < 0) {
            return 0;
        }
        if (memoize[target] != null) {
            return memoize[target];
        }
        if (target == 0)
            return 1;

        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            counter += combinationSum4(nums, target - nums[i], memoize);
        }
        memoize[target] = counter;
        return memoize[target];
    }
}
