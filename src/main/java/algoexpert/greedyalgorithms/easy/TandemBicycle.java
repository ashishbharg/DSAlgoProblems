package algoexpert.greedyalgorithms.easy;

import java.util.Arrays;

/**
 * A tandem bicycle is a bicycle that's operated by two people: person A and person B. Both people pedal the bicycle, but
 * the person that pedals faster dictates the speed of the bicycle. So if a person A pedals at a speed of 5, and person B
 * pedals at a speed of 4, the tandem bicycle moves at a speed of 5 (i.e. tandemSpeed = max(speedA, speedB)
 *
 * You're given two lists of positive integers; one that contains the speeds of riders wearing red shirts and one that
 * contains the speeds of riders wearing blue shirts. Each rider is represented by a single positive integer, which is the
 * speed that they pedal a tandem bicycle at. Both lists have the same length, meaning that there are as many red-shirt
 * riders as there are blue-shirt riders. Your goal is to pair every rider wearing a red shirt with a rider wearing a
 * blue shirt to operate a tandem bicycle.
 *
 * Write a function that returns the maximum possible total speed or the minimum possible total speed of all the tandem
 * bicycles being ridden on an input parameter. If fastest = true, your function should return the maximum possible total
 * speed; otherwise it should return the minimum total speed.
 *
 * "Total speed" is defined as the sum of the speeds of all the tandem bicycles being ridden. For example, if there are
 * 4 riders (2 red-shirt riders and 2 blue-short riders) who have speed of 1, 3, 4, 5, and if they are paired on
 * tandem bicycles as follows:
 * [1, 4] and [5, 3] then the total speed of these tandem bicycles is 4 + 5 = 9.
 *
 * Example 1:
 * redShirtSpeeds: [5, 5, 3, 9, 2],
 * blueShirtSpeeds: [3, 6, 7, 2, 1],
 * fastest: true
 * Output: 32
 *
 * Example 2:
 * redShirtSpeeds: [5, 5, 3, 9, 2],
 * blueShirtSpeeds: [3, 6, 7, 2, 1],
 * fastest: false
 * Output: 25
 */
public class TandemBicycle {

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        int bicycleSpeed = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, true);
        System.out.println(bicycleSpeed);
        assert 32 == bicycleSpeed;

        redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        bicycleSpeed = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, false);
        System.out.println(bicycleSpeed);
        assert 25 == bicycleSpeed;
    }

    // Time Complexity - O(n.log(n)) | Space Complexity - O(1)
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {

        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);

        if (fastest) {
            sortArrayInReverseOrder(blueShirtSpeeds);
        }
        int speed = 0;
        for (int i = 0; i < redShirtSpeeds.length; i++) {
            speed += Math.max(redShirtSpeeds[i], blueShirtSpeeds[i]);
        }
        return speed;
    }

    private static void sortArrayInReverseOrder(int[] blueShirtSpeeds) {

        int start = 0;
        int end = blueShirtSpeeds.length - 1;
        while (start < end) {
            int temp = blueShirtSpeeds[start];
            blueShirtSpeeds[start] = blueShirtSpeeds[end];
            blueShirtSpeeds[end] = temp;
            start++;
            end--;
        }
    }
}
