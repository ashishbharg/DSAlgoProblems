package algoexpert.famousalgorithms.normal;

/**
 * Write a function that takes in a non-empty array of integers and returns the maximum sum that can be obtained
 * by summing up all of the integers in a non-empty subarray of the input array. A sub-array must only contain the
 * adjacent numbers (numbers next to each other in the input array).
 *
 * Example:
 * array: [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
 * Output: 19
 * Explaination: [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]
 */
public class KadaneAlgorithm {

    public static void main(String[] args) {
        int[] array = new int[] {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int result = kadanesAlgorithm(array);
        assert 19 == result;

        array = new int[] {-10, -2, -9, -4, -8, -6, -7, -1, -3, -5};
        result = kadanesAlgorithm(array);
        assert -1 == result;

        array = new int[] {3, 4, -6, 7, 8, -18, 100};
        result = kadanesAlgorithm(array);
        assert 100 == result;

        array = new int[] {8, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        result = kadanesAlgorithm(array);
        assert 23 == result;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static int kadanesAlgorithm(int[] array) {

        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
