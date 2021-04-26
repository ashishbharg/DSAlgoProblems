package algoexpert.arrays.normal;

import java.util.Arrays;

/**
 * Write a function that takes in a non-empty array of integers and returns an array of same length, where each element in
 * the output array is equal to the product of every other input in the array.
 *
 * In other words, the value at output[i] is equal to the product of every number in the input array other than input[i].
 *
 * Note that you are expected to solve this problem without division.
 *
 * Example 1:
 * array: [5, 1, 4, 2]
 * Output: [8, 40, 10, 20]
 *
 * Example 2:
 * array: [-5, 2, -4, 14, -6]
 * Output: [672, -1680, 840, -240, 560]
 *
 * Example 3:
 * array: [9, 3, 2, 1, 9, 5, 3, 2]
 * Output: [1620, 4860, 7290, 14580, 1620, 2916, 4860, 7290]
 */
public class ArrayOfProducts {

    public static void main(String[] args) {

        int[] array = new int[] {5, 1, 4, 2};
        int[] products = arrayOfProducts(array);
        String expected = "[8, 40, 10, 20]";
        assert expected.equals(Arrays.toString(products));

        array = new int[] {-5, 2, -4, 14, -6};
        products = arrayOfProducts(array);
        expected = "[672, -1680, 840, -240, 560]";
        assert expected.equals(Arrays.toString(products));

        array = new int[] {9, 3, 2, 1, 9, 5, 3, 2};
        products = arrayOfProducts(array);
        expected = "[1620, 4860, 7290, 14580, 1620, 2916, 4860, 7290]";
        assert expected.equals(Arrays.toString(products));
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static int[] arrayOfProducts(int[] array) {

        int[] products = new int[array.length];

        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < array.length; i++) {
            products[i] = leftProduct;
            leftProduct *= array[i];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            products[i] *= rightProduct;
            rightProduct *= array[i];
        }
        return products;
    }
}
