package pepcoding.recursion.medium;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/abbreviation-suing-backtracking-official/ojquestion
 *
 * 1. You are given a word.
 * 2. You have to generate all abbrevations of that word.
 *
 * Use recursion as suggested
 *
 * Example:
 * Sample Input
 * pep
 *
 * Sample Output:
 * pep
 * pe1
 * p1p
 * p2
 * 1ep
 * 1e1
 * 2p
 * 3
 */
public class Abbreviation {

    public static void main(String[] args) {

        String str = "pep";
        abbreviate(str, 0, "", 0);
    }

    private static void abbreviate(String str, int index, String ans, int count) {

        if (index == str.length()) {
            if (count == 0) {
                System.out.println(ans);
            } else {
                System.out.println(ans + count);
            }
            return;
        }

        char ch = str.charAt(index);
        if (count > 0) {
            abbreviate(str, index + 1, ans + count + ch, 0);
        } else {
            abbreviate(str, index + 1, ans + ch, 0);
        }
        abbreviate(str, index + 1, ans, count + 1);
    }


}
