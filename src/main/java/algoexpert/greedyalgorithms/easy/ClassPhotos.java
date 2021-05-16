package algoexpert.greedyalgorithms.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * It's photo day at the local school, and you are the photographer assigned to take class photos. The class that you'll
 * be photographing has an even number of students, and all these students are wearing red or blue shirts. In fact, exactly
 * half of the class is wearing red shirts, and the other half is wearing blue shirts. You're responsible for arranging the
 * students in two rows before taking the photos. Each row should contain the same number of the students and should
 * adhere to the following guidelines:
 *
 *      - All students wearing red shirts should be in same row.
 *      - All students wearing blue shirts should be in same row.
 *      - Each student in the back row must be strictly taller than the student directly in the front of them in front row.
 *
 * You're given two input arrays: one containing the heights of all students with red shirts and another one containing
 * the heights of all students in blue shirts. These arrays will always have the same length, and each height will be a
 * positive integer. Write a function that returns whether or not the class photo that follows the stated guidelines can
 * be taken.
 *
 * Note: you can assume that each class has at-least 2 students.
 *
 * Example:
 * redShirtHeights: [5, 8, 1, 3, 4],
 * blueShirtHeights: [6, 9, 2, 4, 5]
 * Output: true
 * Explaination: Place all students with blue shirts in the back row.
 */
public class ClassPhotos {

    public static void main(String[] args) {

        ArrayList<Integer> redShirtHeights = new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5));
        boolean canClassPhotoBeTaken = classPhotos(redShirtHeights, blueShirtHeights);
        assert canClassPhotoBeTaken;

        redShirtHeights = new ArrayList<>(Arrays.asList(6));
        blueShirtHeights = new ArrayList<>(Arrays.asList(6));
        canClassPhotoBeTaken = classPhotos(redShirtHeights, blueShirtHeights);
        assert !canClassPhotoBeTaken;
    }

    // Time Complexity - O(n.lon(n)) | Space Complexity - O(1)
    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        boolean isBlueRowInFront = blueShirtHeights.get(0) < redShirtHeights.get(0);
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (isBlueRowInFront && redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                return false;
            } else if (!isBlueRowInFront && blueShirtHeights.get(i) <= redShirtHeights.get(i)) {
                return false;
            }
        }
        return true;
    }
}
