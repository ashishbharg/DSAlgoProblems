package algoexpert.arrays.easy;

import java.util.Arrays;

/**
 * Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns a new
 * array of the same length with the squares of the original integers also sorted in ascending order.
 */
public class SortedSquaredArrays {

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 5, 6, 8, 9};
        arr = sortedSquaredArray(arr);
        assert "[1, 4, 9, 25, 36, 64, 81]".equals(Arrays.toString(arr));

        arr = new int[] {1, 2, 3, 5, 6, 8, 9};
        arr = sortedSquaredArrayV2(arr);
        assert "[1, 4, 9, 25, 36, 64, 81]".equals(Arrays.toString(arr));

        arr = new int[] {-5, -4, -3, -2, -1};
        arr = sortedSquaredArrayV2(arr);
        assert "[1, 4, 9, 16, 25]".equals(Arrays.toString(arr));

        arr = new int[] {-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20};
        arr = sortedSquaredArrayV2(arr);
        assert "[0, 0, 1, 1, 1, 4, 4, 9, 169, 361, 400, 2500]".equals(Arrays.toString(arr));

        arr = new int[] {-10};
        arr = sortedSquaredArrayV2(arr);
        assert "[100]".equals(Arrays.toString(arr));
    }

    // Time Complexity - O(nlog(n)) | Space Complexity - O(1)
    public static int[] sortedSquaredArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i];
        }

        Arrays.sort(array);
        return array;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static int[] sortedSquaredArrayV2(int[] array) {

        int leftIndex = 0;
        int rightIndex = array.length - 1;
        int[] result = new int[array.length];
        int idx = result.length - 1;
        while (leftIndex <= rightIndex) {
            int leftSquared = array[leftIndex] * array[leftIndex];
            int rightSquared = array[rightIndex] * array[rightIndex];
            if (leftSquared > rightSquared) {
                result[idx] = leftSquared;
                leftIndex++;
            } else {
                result[idx] = rightSquared;
                rightIndex--;
            }
            idx--;
        }
        return result;
    }
}
