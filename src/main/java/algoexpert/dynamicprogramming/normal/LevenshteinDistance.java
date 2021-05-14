package algoexpert.dynamicprogramming.normal;

/**
 * Write a function that takes in two strings and returns the minimum number of edit operations that need to be performed
 * on the first string to obtain the second string.
 *
 * There are three edit operations: insertion of a character, deletion of a character and substitution of a character
 *
 * Example:
 * Input: String str1 = "abc", String str2 = "yabd"
 * Output: 2
 * Explaination: insert "y", substitute "c" for "d"
 */
public class LevenshteinDistance {

    public static void main(String[] args) {
        int distance = levenshteinDistance("abc", "yabd");
        assert 2 == distance;

        distance = levenshteinDistance("algoexpert", "algozexpert");
        assert 1 == distance;

        distance = levenshteinDistance("table", "bal");
        assert 3 == distance;
    }

    // Time Complexity - O(m.n) | Space complexity - O(m.n), where m is the length of str1 and n is the length of str2.
    public static int levenshteinDistance(String str1, String str2) {

        int[][] edits = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < str1.length() + 1; i++) {
            edits[i][0] = i;
        }
        for (int j = 0; j < str2.length() + 1; j++) {
            edits[0][j] = j;
        }

        for (int i = 1; i < str1.length() + 1; i++) {
            for (int j = 1; j < str2.length() + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    edits[i][j] = edits[i - 1][j - 1];
                } else {
                    edits[i][j] = 1 + Math.min(edits[i - 1][j - 1], Math.min(edits[i][j - 1], edits[i - 1][j]));
                }
            }
        }
        return edits[str1.length()][str2.length()];
    }
}
