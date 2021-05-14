package pepcoding.recursion.easy;

import java.util.ArrayList;

/**
 * 1. You are given a number n representing number of stairs in a staircase.
 * 2. You are standing at the bottom of staircase. You are allowed to climb 1 step, 2 steps or 3 steps in one move.
 * 3. Complete the body of getStairPaths function - without changing signature - to get the list of all paths that can
 * be used to climb the staircase up. Use sample input and output to take idea about output.
 *
 * Example:
 * Sample Input
 * 3
 * Sample Output
 * [111, 12, 21, 3]
 */
public class GetStairPaths {

    public static void main(String[] args) {

        ArrayList<String> stairPaths = getStairPaths(3);
        String expected = "[111, 12, 21, 3]";
        System.out.println(expected);
        assert expected.equals(stairPaths);
    }

    // Time Complexity - O(3^n) | Space Complexity - O(h)
    public static ArrayList<String> getStairPaths(int n) {
        return getStairPaths(n, "", new ArrayList<>());
    }

    private static ArrayList<String> getStairPaths(int n, String pathSoFar, ArrayList<String> result) {
        if (n <= 0) {
            if (n == 0) {
                result.add(pathSoFar);
            }
            return result;
        }

        getStairPaths(n - 1, pathSoFar + "1", result);
        getStairPaths(n - 2, pathSoFar + "2", result);
        getStairPaths(n - 3, pathSoFar + "3", result);
        return result;
    }
}
