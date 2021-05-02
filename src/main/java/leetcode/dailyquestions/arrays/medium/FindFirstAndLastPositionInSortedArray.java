package leetcode.dailyquestions.arrays.medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * Follow up: Could you write an algorithm with O(log n) runtime complexity?
 *
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 *
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
public class FindFirstAndLastPositionInSortedArray {

    public static void main(String[] args) {

        int[] nums = {5,7,7,8,8,10};
        int[] result =searchRange(nums, 8);
        String expected = "[3, 4]";
        assert expected.equals(Arrays.toString(result));

        nums = new int[] {5,7,7,8,8,10};
        result =searchRange(nums, 6);
        expected = "[-1, -1]";
        assert expected.equals(Arrays.toString(result));
    }

    // Time Complexity - O(log(n)) | Space Complexity - O()
    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[] {-1, -1};
        if (nums.length < 1) {
            return result;
        }
        searchRange(nums, target, 0, nums.length - 1, result);
        return result;
    }

    // Time Complexity - O(log(n)) | Space Complexity - O(log(n))
    public static void searchRange(int[] nums, int target, int startIndex, int endIndex, int[] result) {
        // return if startIndex is greater than endIndex
        if (startIndex > endIndex) {
            return;
        }
        // return if both the result indexes are filled up
        if (result[0] != -1 && result[1] != -1) {
            return;
        }
        int midIndex = startIndex + ((endIndex - startIndex) / 2);
        if (target < nums[midIndex]) {
            searchRange(nums, target, startIndex, midIndex - 1, result);
        } else if (target > nums[midIndex]) {
            searchRange(nums, target, midIndex + 1, endIndex, result);
        } else {
            // check if target is present in midIndex - 1 position. If it's there then startIndex is on left side of midIndex.
            if (midIndex > 0 && target == nums[midIndex - 1]) {
                searchRange(nums, target, startIndex, midIndex - 1, result);
            } else {
                result[0] = midIndex;
            }
            // check if target is present in midIndex + 1 position. If it's there then endIndex is on right side of midIndex.
            if (midIndex < nums.length - 1 && target == nums[midIndex + 1]) {
                searchRange(nums, target, midIndex + 1, endIndex, result);
            } else {
                result[1] = midIndex;
            }
        }
    }
}
