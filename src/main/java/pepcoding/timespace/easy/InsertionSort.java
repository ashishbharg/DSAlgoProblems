package pepcoding.timespace.easy;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] result = insertionSort(array);
        display(result);

        array = new int[] {-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8};
        result = insertionSort(array);
        display(result);

        array = new int[] {8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4};
        result = insertionSort(array);
        display(result);

        array = new int[] {3, 6, 8, 10, 34, 56};
        result = insertionSort(array);
        display(result);
    }

    /*
        Time Complexity | Space Complexity
        Best Case: O(n) | O(1)
        Average Case: O(n^2) | O(1)
        Worst Case: O(n^2) | O(1)
     */
    public static int[] insertionSort(int[] array) {
        // Write your code here.
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
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
