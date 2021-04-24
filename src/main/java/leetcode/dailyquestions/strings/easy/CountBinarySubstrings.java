package leetcode.dailyquestions.strings.easy;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 *
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 *
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 *
 * Note:
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 */
public class CountBinarySubstrings {

    public static void main(String[] args) {
        int count = countBinarySubstrings("00110011");
        assert count == 6;
        System.out.println(count);

        count = countBinarySubstrings("10101");
        assert count == 4;
        System.out.println(count);
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static int countBinarySubstrings(String s) {

        if (s.trim().isEmpty()) {
            return 0;
        }
        int counter = 0;
        int[] binaryCounter = {0,0};
        binaryCounter[s.charAt(0) - 48]++;
        boolean isNumberRevisited = false;
        for (int i = 1; i < s.length(); i++) {
            if (!isNumberRevisited && s.charAt(i) != s.charAt(i - 1)) {
                isNumberRevisited = true;
            } else if (isNumberRevisited && s.charAt(i) != s.charAt(i - 1)) {
                counter += Math.min(binaryCounter[0], binaryCounter[1]);
                binaryCounter[s.charAt(i) - 48] = 0;
            }
            binaryCounter[s.charAt(i) - 48]++;
        }
        counter += Math.min(binaryCounter[0], binaryCounter[1]);
        return counter;
    }

    /*
     * This is a solution provided by leetcode. Pasted here just to see the difference what I have done
     * and how they have implemented.
     */
    public int countBinarySubstringsV2(String s) {
        int ans = 0, prev = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            } else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }
}
