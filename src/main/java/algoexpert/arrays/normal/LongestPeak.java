package algoexpert.arrays.normal;

/**
 * Write a function that takes in an array of integers and returns the length of the longest peak in the array.
 *
 * A peak is defined as adjacent integers of the array that are strictly increasing until they reach a tip (the highest value
 * in the peak), at which point they become strictly decreasing. At least three integers are required to form a peak.
 *
 * For example, the integers 1, 4, 10, 2 form a peak, but the integers 4, 0, 10 don't and neither do the integers 1, 2, 2, 0.
 * Similarly, the integers 1, 2, 3 don't form a peak because they aren't any strictly decreasing integers after the 3.
 *
 * Example 1:
 * array: [1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3]
 * Output: 6
 *
 * Example 2:
 * array: [5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10]
 * Output: 5
 *
 * Example 3:
 * array: [5, 4, 3, 2, 1, 2, 10, 12]
 * Output: 0
 */
public class LongestPeak {

    public static void main(String[] args) {

        int[] array = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        int count = longestPeak(array);
        assert count == 6;

        array = new int[] {5, 4, 3, 2, 1, 2, 10, 12, -3, 5, 6, 7, 10};
        count = longestPeak(array);
        assert count == 5;

        array = new int[] {5, 4, 3, 2, 1, 2, 10, 12};
        count = longestPeak(array);
        assert count == 0;
    }

    public static int longestPeak(int[] array) {

        int longestPeak = 0;
        int i = 1;
        while (i < array.length) {
            while (i < array.length && array[i - 1] == array[i]) {
                i++;
            }

            int up = 0;
            while (i < array.length && array[i - 1] < array[i]) {
                up++;
                i++;
            }

            int down = 0;
            while (i < array.length && array[i - 1] > array[i]) {
                down++;
                i++;
            }

            if (up > 0 && down > 0) {
                longestPeak = Math.max(longestPeak, up + down + 1);
            }
        }
        return longestPeak;
    }
}
