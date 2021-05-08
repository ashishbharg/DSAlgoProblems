package leetcode.dailyquestions.math.hard;

/**
 * https://leetcode.com/problems/super-palindromes/
 *
 * Let's say a positive integer is a super-palindrome if it is a palindrome, and it is also the square of a palindrome.
 *
 * Given two positive integers left and right represented as strings, return the number of super-palindromes integers in the inclusive range [left, right].
 *
 * Example 1:
 * Input: left = "4", right = "1000"
 * Output: 4
 * Explanation: 4, 9, 121, and 484 are superpalindromes.
 * Note that 676 is not a superpalindrome: 26 * 26 = 676, but 26 is not a palindrome.
 *
 * Example 2:
 * Input: left = "1", right = "2"
 * Output: 1
 *
 * Constraints:
 * 1 <= left.length, right.length <= 18
 * left and right consist of only digits.
 * left and right cannot have leading zeros.
 * left and right represent integers in the range [1, 1018].
 * left is less than or equal to right.
 */
public class SuperPalindromesInRange {

    public static void main(String[] args) {
        int superpalindromesCount = superpalindromesInRange("4", "1000");
        System.out.println("superpalindromesCount: " + superpalindromesCount);
        assert 4 == superpalindromesCount;

        superpalindromesCount = superpalindromesInRange("1", "2");
        System.out.println("superpalindromesCount: " + superpalindromesCount);
        assert 1 == superpalindromesCount;

        superpalindromesCount = superpalindromesInRange("40000000000000000", "50000000000000000");
        System.out.println("superpalindromesCount: " + superpalindromesCount);
        assert 2 == superpalindromesCount;
    }

    // This code is failing for few test cases with Time Limit Exceeded eror. Need to check the video again for more understanding.
    // https://www.youtube.com/watch?v=PWcmzhZMkrs&list=PLEvw47Ps6OBDOS9QhnA95PRvKxbEfMeP9&index=6
    public static int superpalindromesInRange(String left, String right) {

        long startRange = Long.parseLong(left);
        long endRange = Long.parseLong(right);

        startRange = (long) Math.sqrt(startRange);

        int count = 0;
        for (long i = startRange; i <= endRange; i++) {
            if (i * i > endRange) {
                break;
            }
            if (isPalindrome(i) && isPalindrome(i * i)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isPalindrome(long num) {
        return num == reverse(num);
    }

    private static long reverse(long num) {
        long reverseNum = 0;
        while (num != 0) {
            reverseNum = 10 * reverseNum + num % 10;
            num = num / 10;
        }
        return reverseNum;
    }
}
