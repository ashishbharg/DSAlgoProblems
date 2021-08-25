package pepcoding.timespace.easy;

/**
 * 1. You are given an array(arr) of integers.
 * 2. You have to sort the given array in increasing order using count sort.
 */
public class CountSort {

    public static void main(String[] args) {

        int[] array = {9, 6, 3, 5, 3, 4, 3, 9, 6, 4, 6, 5, 8, 9, 9};
        countSort(array, 3, 9);
        display(array);

        array = new int[] {7, -2, 4, 1, 3};
        countSort(array, -2, 7);
        display(array);
    }

    public static void countSort(int[] arr, int min, int max) {

        int range = max - min + 1;
        int[] freqArr = new int[range];
        for (int i = 0; i < arr.length; i++) {
            int idx = arr[i] - min;
            freqArr[idx]++;
        }

        for (int i = 1; i < freqArr.length; i++) {
            freqArr[i] += freqArr[i - 1];
        }

        int[] result = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int pos = freqArr[val - min];
            int idx = pos - 1;
            result[idx] = val;
            freqArr[val - min]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }

    }

    private static void display(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
