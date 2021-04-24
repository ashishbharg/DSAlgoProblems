package algoexpert.arrays.normal;

import java.util.Arrays;

/**
 * Write a function that takes in two non-empty arrays of integers, find the pairs of numbers (one from each array) whose
 * absolute difference is closest to zero, and returns an array containing these two numbers, with the number from the
 * first array in the first position.
 *
 * Note that the absolute difference of two integers is the distance between them on the real number line. For example,
 * the absolute difference of -5 and 5 is 10 and absolute difference of -5 and -4 is 1.
 *
 * You can assume there will only be one pair of numbers with the smallest difference.
 *
 * Example:
 * "arrayOne": [-1, 5, 10, 20, 28, 3]
 * "arrayTwo": [26, 134, 135, 15, 17]
 * Output: [28,26] as the lowest difference is 2.
 */
public class SmallestDifference {

    public static void main(String[] args) {

        int[] arrayOne = new int[] {-1, 5, 10, 20, 28, 3};
        int[] arrayTwo = new int[] {26, 134, 135, 15, 17};
        String expected = "[28, 26]";
        int[] result = smallestDifference(arrayOne, arrayTwo);
        assert expected.equals(Arrays.toString(result));

        arrayOne = new int[] {10, 0, 20, 25};
        arrayTwo = new int[] {1005, 1006, 1014, 1032, 1031};
        expected = "[25, 1005]";
        result = smallestDifference(arrayOne, arrayTwo);
        assert expected.equals(Arrays.toString(result));

        arrayOne = new int[] {10, 1000, 9124, 2142, 59, 24, 596, 591, 124, -123};
        arrayTwo = new int[] {-1441, -124, -25, 1014, 1500, 660, 410, 245, 530};
        expected = "[-123, -124]";
        result = smallestDifference(arrayOne, arrayTwo);
        assert expected.equals(Arrays.toString(result));

    }

    // TimeComplexity - O(nlogn) + O(mlogm) | Space Complexity - O(1)
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int smallestDifference = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0, j = 0; i < arrayOne.length && j < arrayTwo.length;) {
            int currentDiff = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (currentDiff < smallestDifference) {
                smallestDifference = Math.min(smallestDifference, currentDiff);
                result[0] = arrayOne[i];
                result[1] = arrayTwo[j];
            }
             if (j < arrayTwo.length - 1 && currentDiff < Math.abs(arrayOne[i] - arrayTwo[j + 1])) {
                 i++;
                 j = 0;
             } else {
                 j++;
             }
        }
        return result;
    }
}
