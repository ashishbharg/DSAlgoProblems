package pepcoding.timespace.easy;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to find the k-th smallest element in the given array using the quick-select algorithm.
 */
public class QuickSelect {

    public static void main(String[] args) {

        int[] array = new int[] {8, 5, 2, 9, 7, 6, 3};
        int k = 3;
        int result = quickSelect(array, 0, array.length - 1, k - 1);
        System.out.println("result: " + result);

        array = new int[] {8, 3, 2, 5, 1, 7, 4, 6};
        k = 1;
        result = quickSelect(array, 0, array.length - 1, k - 1);
        System.out.println("result: " + result);

        array = new int[] {8, 3, 2, 5, 1, 7, 4, 6};
        k = 8;
        result = quickSelect(array, 0, array.length - 1, k - 1);
        System.out.println("result: " + result);
    }

    /*
        Time Complexity | Space Complexity
        Best Case: O(n) | O(1)
        Average Case: O(n) | O(1)
        Worst Case: O(n^2) | O(1)
     */
    public static int quickSelect(int[] arr, int lo, int hi, int k) {

        int pivot = arr[hi];
        int partition = partition(arr, pivot, lo, hi);
        if (k < partition) {
            return quickSelect(arr, lo, partition - 1, k);
        } else if ( k > partition) {
            return quickSelect(arr, partition + 1, hi, k);
        } else {
            return pivot;
        }
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
}
