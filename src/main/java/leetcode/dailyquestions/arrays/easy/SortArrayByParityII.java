package leetcode.dailyquestions.arrays.easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-array-by-parity-ii/
 *
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even. Sort the array so
 * that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 *
 * Return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: nums = [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 * Example 2:
 * Input: nums = [2,3]
 * Output: [2,3]
 */
public class SortArrayByParityII {

    public static void main(String[] args) {
        int[] nums = new int[] {4,2,5,7};
        int[] result = sortArrayByParityII(nums);
        System.out.println(Arrays.toString(result));
        String expected = "[4, 5, 2, 7]";
        assert expected.equals(Arrays.toString(result));
    }

    public static int[] sortArrayByParityII(int[] nums) {

        int even = 0;
        int odd = 1;

        int[] ans = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                ans[even] = nums[i];
                even += 2;
            } else {
                ans[odd] = nums[i];
                odd += 2;
            }
        }

        return ans;
    }
}
