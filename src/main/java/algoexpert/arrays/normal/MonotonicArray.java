package algoexpert.arrays.normal;

/**
 * Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic.
 *
 * An array is said to be monotonic if it's elements from left to right, are either non-increasing or non-decreasing.
 *
 * Non-increasing elements aren't necessarily exclusive decreasing; they simply don't increase.
 *
 * Note that empty arrays and arrays of one element are monotonic.
 *
 * Example 1:
 * array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
 * Output = true
 *
 * array = [-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11]
 * Output = false
 *
 * array = [1, 5, 10, 1100, 1101, 1102, 9001]
 * Output = true
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] array = {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        boolean result = isMonotonic(array);
        assert result;

        array = new int[] {-1, -1, -2, -3, -4, -5, -5, -5, -6, -7, -8, -7, -9, -10, -11};
        result = isMonotonic(array);
        assert !result;

        array = new int[] {1, 5, 10, 1100, 1101, 1102, 9001};
        result = isMonotonic(array);
        assert result;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static boolean isMonotonic(int[] array) {

        if (array.length <= 1) {
            return true;
        }
        int arrayDiff = 0;
        for (int i = 1; i < array.length; i++) {
            int currDiff = array[i] - array[i - 1];
            if (arrayDiff == 0 && currDiff != 0) {
                arrayDiff = currDiff;
            }
            if (arrayDiff > 0 && currDiff < 0) {
                return false;
            } else if (arrayDiff < 0 && currDiff > 0) {
                return false;
            }
        }
        return true;
    }
}
