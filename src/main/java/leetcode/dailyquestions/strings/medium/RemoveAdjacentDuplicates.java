package leetcode.dailyquestions.strings.medium;

/**
 * https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/
 *
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s
 * and removing them, causing the left and the right side of the deleted substring to concatenate together.
 *
 * We repeatedly make k duplicate removals on s until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 *
 * Example 1:
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 *
 * Example 2:
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 *
 * Example 3:
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 *
 * Constraints:
 *
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 */
public class RemoveAdjacentDuplicates {

    public static void main(String[] args) {
        RemoveAdjacentDuplicates rm = new RemoveAdjacentDuplicates();
        String str = rm.removeDuplicates("deeedbbcccbdaa", 3);
        assert "aa".equals(str);

        str = rm.removeDuplicates("pbbcggttciiippooaais", 2);
        assert "ps".equals(str);

        str = rm.removeDuplicates("abcd", 2);
        assert "abcd".equals(str);

        str = rm.removeDuplicatesV2("abcd", 2);
        assert "abcd".equals(str);
    }

    /**
     * This solution is using an array to denote if consecutive k characters are same or not and StringBuilder to
     * perform operations on string.
     *
     * Time Complexity - O(n) | Space Complexity - O(n)
     */
    public String removeDuplicates(String s, int k) {

        int[] count = new int[s.length()];
        StringBuilder sb = new StringBuilder();
        for (char ch: s.toCharArray()) {
            sb.append(ch);
            int lastIndex = sb.length() - 1;
            count[lastIndex] = 1 + ((lastIndex > 0 && sb.charAt(lastIndex) == sb.charAt(lastIndex - 1)) ? count[lastIndex -1] : 0);
            if (count[lastIndex] >= k) {
                sb.delete(sb.length() - k, sb.length());
            }
        }
        return sb.toString();
    }

    /**
     * This method also removes the adjacent duplicates from the string. However the below solution is failing for
     * larger strings with TimeExceededError as this solution is iterating for every character.
     * @param s
     * @param k
     * @return
     */
    public String removeDuplicatesV2(String s, int k) {

        int idx = 0;
        int length = s.length();
        boolean flag = false;
        while (true) {
            while (idx + k <= length) {
                String subStr = s.substring(idx, idx + k);
                boolean hasAllDuplicatesInSubStr = hasSubStrAllDuplicates(subStr);
                if (hasAllDuplicatesInSubStr) {
                    s = s.substring(0, idx) + s.substring(idx + k);
                    length = s.length();
                    flag = true;
                } else {
                    idx++;
                }
            }
            if (flag) {
                idx = 0;
            } else {
                break;
            }
            flag = false;
        }
        return s;
    }

    private boolean hasSubStrAllDuplicates(String subStr) {
        int i = 0;
        int j = subStr.length() - 1;
        while (i < j) {
            if (subStr.charAt(i) != subStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
