package algoexpert.arrays.normal;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers between 1 and n inclusive, where n is the length of the array, write a function that returns
 * the first integer that appears more than once (when the array is read from left to right).
 *
 * In other words, out of all the integers that might occur more than once in the input array, your function should return the
 * one whose first duplicate has the minimum index.
 *
 * If no integer appears more than once, your function should return -1.
 *
 * Note that you are allowed to mutate the array.
 *
 * Example 1:
 * array: [2, 1, 5, 2, 3, 3, 4]
 * Output: 2
 *
 * Example 2:
 * array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10]
 * Output: 10
 *
 * Example 3:
 * array: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 * Output: -1
 */
public class FirstDuplicateValue {

    public static void main(String[] args) {

        int[] array = new int[] {2, 1, 5, 2, 3, 3, 4};
        int number = firstDuplicateValue(array);
        assert number == 2;

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};
        number = firstDuplicateValue(array);
        assert number == 10;

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        number = firstDuplicateValue(array);
        assert number == -1;

        array = new int[] {2, 1, 5, 2, 3, 3, 4};
        number = firstDuplicateValueV2(array);
        assert number == 2;

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10};
        number = firstDuplicateValueV2(array);
        assert number == 10;

        array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        number = firstDuplicateValueV2(array);
        assert number == -1;
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static int firstDuplicateValue(int[] array) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (!set.add(array[i])) {
                return array[i];
            }
        }
        return -1;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static int firstDuplicateValueV2(int[] array) {

        // [2, 1, 5, 2, 3, 3, 4]
        for (int i = 0; i < array.length; i++) {
            int index = Math.abs(array[i]);
            if (array[index - 1] < 0) {
                return index;
            } else {
                array[index - 1] *= -1;
            }
        }
        return -1;
    }
}
