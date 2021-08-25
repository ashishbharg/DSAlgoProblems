package pepcoding.timespace.easy;

import java.util.Arrays;

public class RadixSort {

    public static void main(String[] args) {

        int[] array = {213, 97, 718, 1023, 123, 37, 9, 443, 982, 64, 375, 863};
        radixSort(array);
        display(array);
    }

    /**
     * Time complexity - O(d * (n + b)) where d is the count of digits in max number, n is the length of input array and b is base of numbering system used
     * Space Complexity - O(n + b) where n is the length of input array and b is base of numbering system used
     * @param arr
     */
    public static void radixSort(int[] arr) {

        int maxNumber = Arrays.stream(arr).max().getAsInt();
        int count = 1;
        while (count <= maxNumber) {
            countSort(arr, count);
            count = count * 10;
        }
    }

    private static void countSort(int[] arr, int modCount) {

        // Since the digit at any index can range from 0 to 9, hence fixing the size of frequency array to 10.
        int[] freqArr = new int[10];
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int index = arr[i] / modCount % 10;
            freqArr[index]++;
        }

        for (int i = 1; i < freqArr.length; i++) {
            freqArr[i] += freqArr[i - 1];
        }

        for (int i = arr.length - 1; i >=0; i--) {
            int val = arr[i];
            int pos = freqArr[val / modCount % 10];
            int index = pos - 1;
            result[index] = val;
            freqArr[val / modCount % 10]--;
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = result[i];
        }
    }

    private static void display(int[] array) {
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
