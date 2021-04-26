package algoexpert.arrays.normal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Write a function that takes in a non-empty array of arbitrary intervals, and returns the new intervals in no particular order.
 *
 * Each interval is an array of two integers, with interval[0] as start of the interval and interval[1] as the end of the interval.
 *
 * Note that back to back intervals aren't considered to be overlapping. For example, [1,5] and [6,7] aren't overlapping,
 * however, [1,6] and [6,7] are indeed overlapping.
 *
 * Also note that start of the interval will always be less than or equal to the end of the interval.
 *
 * Example 1:
 * intervals: [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
 * Output: [[1, 2], [3, 8], [9, 10]]
 *
 * Example 2:
 * intervals: intervals": [[1, 10], [10, 20], [20, 30], [30, 40], [40, 50], [50, 60], [60, 70], [70, 80], [80, 90], [90, 100]]
 * Output: [[1, 100]]
 *
 * Example 3:
 * intervals": [[1, 10], [11, 20], [21, 30], [31, 40], [41, 50], [51, 60], [61, 70], [71, 80], [81, 90], [91, 100]]
 * Output: [[1, 10], [11, 20], [21, 30], [31, 40], [41, 50], [51, 60], [61, 70], [71, 80], [81, 90], [91, 100]]
 *
 * Example 4:
 * intervals: [[100, 105], [1, 104]]
 * Output: [[1, 105]]
 *
 */
public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = new int[][] {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] overlappingIntervals = mergeOverlappingIntervals(intervals);
        String expected = "[[1, 2], [3, 8], [9, 10]]";
        assert expected.equals(Arrays.deepToString(overlappingIntervals));

        intervals = new int[][] {{1, 10}, {10, 20}, {20, 30}, {30, 40}, {40, 50}, {50, 60}, {60, 70}, {70, 80}, {80, 90}, {90, 100}};
        overlappingIntervals = mergeOverlappingIntervals(intervals);
        expected = "[[1, 100]]";
        assert expected.equals(Arrays.deepToString(overlappingIntervals));

        intervals = new int[][] {{1, 10}, {11, 20}, {21, 30}, {31, 40}, {41, 50}, {51, 60}, {61, 70}, {71, 80}, {81, 90}, {91, 100}};
        overlappingIntervals = mergeOverlappingIntervals(intervals);
        expected = "[[1, 10], [11, 20], [21, 30], [31, 40], [41, 50], [51, 60], [61, 70], [71, 80], [81, 90], [91, 100]]";
        assert expected.equals(Arrays.deepToString(overlappingIntervals));

        intervals = new int[][] {{100, 105}, {1, 104}};
        overlappingIntervals = mergeOverlappingIntervals(intervals);
        expected = "[[1, 105]]";
        assert expected.equals(Arrays.deepToString(overlappingIntervals));
    }

    // Time Complexity - O(nlog(n)) | Space Complexity - O(n) where n is the length of input array.
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {

        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 1;
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        while (i < intervals.length) {
            if (intervals[i][0] <= result.get(result.size() - 1)[1]) {
                result.get(result.size() - 1)[1] = Math.max(intervals[i][1], result.get(result.size() - 1)[1]);
            } else {
                result.add(intervals[i]);
            }
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}
