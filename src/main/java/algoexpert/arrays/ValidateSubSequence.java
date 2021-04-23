package algoexpert.arrays;

/**
 * Given two non-empty array of integers, write a function that determins whether the second array is a subsequence of the first one.
 * A subsequence of an array is a set of numbers that aren't necessarily adjacent in the array but that are in the same order
 * as they appear in the array.
 *
 * Example 1:
 * array: [5, 1, 22, 25, 6, -1, 8, 10],
 * sequence: [1, 6, -1, 10]
 * Output : true
 *
 * Example 2:
 * array: [5, 1, 22, 25, 6, -1, 8, 10],
 * sequence: [1, 6, -1, -1]
 * Output: false
 *
 * Time Complexity - O(n) | Space Complexity - O(1)
 */
public class ValidateSubSequence {

    public static void main(String[] args) {


        int[] arr = new int[] {5, 1, 22, 25, 6, -1, 8, 10};
        int[] sequence = new int[] {1, 6, -1, 10};
        boolean isValidSubSequence = isValidSubSequence(arr, sequence);
        assert isValidSubSequence;

        arr = new int[] {5, 1, 22, 25, 6, -1, 8, 10};
        sequence = new int[] {1, 6, -1, -1};
        isValidSubSequence = isValidSubSequence(arr, sequence);
        assert !isValidSubSequence;
    }

    public static boolean isValidSubSequence(int[] array, int[] sequence) {

        int j = 0;
        for (int i = 0; i < array.length && j < sequence.length; i++) {
            if (array[i] == sequence[j]) {
                j++;
            }
        }

        return j == sequence.length;
    }
}
