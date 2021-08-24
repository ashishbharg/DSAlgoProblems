package pepcoding.timespace.easy;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to sort the given array in increasing order using selection sort.
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] result = selectionSort(array);
        display(result);

        array = new int[] {-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8};
        result = selectionSort(array);
        display(result);

        array = new int[] {8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4};
        result = selectionSort(array);
        display(result);

        array = new int[] {3, 6, 8, 10, 34, 56};
        result = selectionSort(array);
        display(result);
    }

    /*
        Time Complexity | Space Complexity
        Best Case: O(n^2) | O(1)
        Average Case: O(n^2) | O(1)
        Worst Case: O(n^2) | O(1)
     */
    public static int[] selectionSort(int[] array) {

        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            swap(array, i, min);
        }
        return array;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
