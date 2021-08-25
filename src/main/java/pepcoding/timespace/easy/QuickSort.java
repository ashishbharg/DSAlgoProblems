package pepcoding.timespace.easy;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to sort the given array in increasing order using quick-sort.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] result = quickSort(array);
        display(result);

        array = new int[] {-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8};
        result = quickSort(array);
        display(result);

        array = new int[] {8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4};
        result = quickSort(array);
        display(result);

        array = new int[] {3, 6, 8, 10, 34, 56};
        result = quickSort(array);
        display(result);
    }

    /*
        Time Complexity | Space Complexity
        Best Case: O(nlog(n)) | O(n)
        Average Case: O(nlog(n)) | O(n)
        Worst Case: O(nlog(n)) | O(n)
     */
    public static int[] quickSort(int[] array) {

        quickSort(array, 0, array.length - 1);
        return array;
    }

    private static void quickSort(int[] array, int lo, int hi) {

        if (lo > hi) {
            return;
        }

        int pivot = array[hi];
        int partition = partition(array, pivot, lo, hi);
        quickSort(array, lo, partition - 1);
        quickSort(array, partition + 1, hi);
    }

    private static int partition(int[] array, int pivot, int lo, int hi) {

        int i = lo;
        int j = lo;
        while (i <= hi) {
            if (array[i] <= pivot) {
                swap(array, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return (j - 1);
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
