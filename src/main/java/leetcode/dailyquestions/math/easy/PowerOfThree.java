package leetcode.dailyquestions.math.easy;

/**
 * https://leetcode.com/problems/power-of-three/
 *
 * Given an integer n, return true if it is a power of three. Otherwise, return false.
 *
 * An integer n is a power of three, if there exists an integer x such that n == 3x.
 *
 * Example 1:
 * Input: n = 27
 * Output: true
 *
 * Example 2:
 * Input: n = 0
 * Output: false

 * Example 3:
 * Input: n = 9
 * Output: true

 * Example 4:
 * Input: n = 45
 * Output: false
 *
 * Constraints:
 * -231 <= n <= 231 - 1
 */
public class PowerOfThree {

    public static void main(String[] args) {

        boolean isPowerOfThree = isPowerOfThree(27);
        assert isPowerOfThree;

        isPowerOfThree = isPowerOfThree(0);
        assert !isPowerOfThree;

        isPowerOfThree = isPowerOfThree(9);
        assert isPowerOfThree;

        isPowerOfThree = isPowerOfThree(45);
        assert !isPowerOfThree;

        isPowerOfThree = isPowerOfThree(243);
        assert isPowerOfThree;

        isPowerOfThree = isPowerOfThreeV2(27);
        assert isPowerOfThree;

        isPowerOfThree = isPowerOfThreeV2(0);
        assert !isPowerOfThree;

        isPowerOfThree = isPowerOfThreeV2(9);
        assert isPowerOfThree;

        isPowerOfThree = isPowerOfThreeV2(45);
        assert !isPowerOfThree;

        isPowerOfThree = isPowerOfThreeV2(243);
        assert isPowerOfThree;
    }

    // Space Complexity - O(1) | Time Complexity - Unknown The expensive operation here is Math.log, which upper bounds the time complexity of our algorithm.
    // The implementation is dependent on the language we are using and the compiler
    public static boolean isPowerOfThree(int n) {

        double logValue = Math.log10(n) / Math.log10(3);
        return logValue == (int)logValue;
    }

    // Time Complexity - O(logn) where base is 3 | Space Complexity - O(1)
    public static boolean isPowerOfThreeV2(int n) {

        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }
        return n == 1;
    }
}
