package algoexpert.arrays.normal;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of integers and an integer. Write a function that moves all instances of that integer in the array to the
 * end of the array and returns the array.
 *
 * The function should perform this in place (i.e. it should mutate the input array) and doesn't need to maintain the order of
 * the other integers.
 *
 * Example 1:
 * array: [2, 1, 2, 2, 2, 3, 4, 2]
 * toMove: 2
 * Output: [1, 3, 4, 2, 2, 2, 2, 2]
 *
 * Example 2:
 * array: [1, 2, 4, 5, 6]
 * toMove: 3
 * Output: [1, 2, 4, 5, 6]
 *
 * Example 3:
 * array: [5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12]
 * toMove: 5
 * Output: [12, 11, 10, 9, 8, 7, 1, 2, 3, 4, 6, 5, 5, 5, 5, 5, 5]
 */
public class MoveElementToEnd {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2);
        int toMove = 2;
        String expected = "[4, 1, 3, 2, 2, 2, 2, 2]";
        List<Integer> result = moveElementToEnd(array, toMove);
        assert expected.equals(Arrays.toString(result.toArray()));

        array = Arrays.asList(1, 2, 4, 5, 6);
        toMove = 3;
        expected = "[1, 2, 4, 5, 6]";
        result = moveElementToEnd(array, toMove);
        assert expected.equals(Arrays.toString(result.toArray()));

        array = Arrays.asList(5, 5, 5, 5, 5, 5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12);
        toMove = 5;
        expected = "[12, 11, 10, 9, 8, 7, 1, 2, 3, 4, 6, 5, 5, 5, 5, 5, 5]";
        result = moveElementToEnd(array, toMove);
        assert expected.equals(Arrays.toString(result.toArray()));
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        int startIndex = 0;
        int endIndex = array.size() - 1;
        while(startIndex < endIndex) {
            while (startIndex < endIndex && array.get(startIndex) != toMove) {
                startIndex++;
            }
            while (startIndex < endIndex && array.get(endIndex) == toMove) {
                endIndex--;
            }
            swap(array, startIndex, endIndex);
            startIndex++;
            endIndex--;
        }
        return array;
    }

    private static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
