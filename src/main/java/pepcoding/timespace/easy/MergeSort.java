package pepcoding.timespace.easy;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to sort the given array in increasing order using the merge sort.
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] result = mergeSort(array);
        display(result);

        array = new int[] {-4, 5, 10, 8, -10, -6, -4, -2, -5, 3, 5, -4, -5, -1, 1, 6, -7, -6, -7, 8};
        result = mergeSort(array);
        display(result);

        array = new int[] {8, -6, 7, 10, 8, -1, 6, 2, 4, -5, 1, 10, 8, -10, -9, -10, 8, 9, -2, 7, -2, 4};
        result = mergeSort(array);
        display(result);

        array = new int[] {3, 6, 8, 10, 34, 56};
        result = mergeSort(array);
        display(result);
    }

    /*
        Time Complexity | Space Complexity
        Best Case: O(nlog(n)) | O(n)
        Average Case: O(nlog(n)) | O(n)
        Worst Case: O(nlog(n)) | O(n)
     */
    public static int[] mergeSort(int[] array) {

        int[] aux = new int[array.length];
        mergeSort(array, aux, 0, array.length - 1);
        return array;
    }

    private static void mergeSort(int[] array, int[] aux, int lo, int hi) {

        if (lo >= hi) {
            return;
        }

        int mid = (lo + hi) / 2;
        mergeSort(array, aux, lo, mid);
        mergeSort(array, aux, mid + 1, hi);
        merge(array, aux, lo, mid, hi);
    }

    private static void merge(int[] array, int[] aux, int lo, int mid, int hi) {

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            aux[k] = array[k];
        }

        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j];
                j++;
            } else if (j > hi) {
                array[k] = aux[i];
                i++;
            } else if (aux[i] < aux[j]) {
                array[k] = aux[i];
                i++;
            }  else {
                array[k] = aux[j];
                j++;
            }
        }
    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
