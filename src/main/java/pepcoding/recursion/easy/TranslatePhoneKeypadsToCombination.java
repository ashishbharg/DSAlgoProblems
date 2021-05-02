package pepcoding.recursion.easy;

import java.util.ArrayList;

/**
 * 1. You are given a string str. The string str will contains numbers only, where each number stands for a key pressed on a mobile phone.
 * 2. The following list is the key to characters map :
 *     0 -> .;
 *     1 -> abc
 *     2 -> def
 *     3 -> ghi
 *     4 -> jkl
 *     5 -> mno
 *     6 -> pqrs
 *     7 -> tu
 *     8 -> vwx
 *     9 -> yz
 * 3. Complete the body of getKPC function - without changing signature - to get the list of all words that could be
 * produced by the keys in str.
 * Use sample input and output to take idea about output.
 *
 * Note -> The online judge can't force you to write the function recursively but that is what the spirit of question is.
 * Write recursive and not iterative logic. The purpose of the question is to aid learning recursion and not test you.
 *
 * Example:
 * Input: 78
 * Output: [tv, tw, tx, uv, uw, ux]
 */
public class TranslatePhoneKeypadsToCombination {

    public static void main(String[] args) {
        String str = "78";
        ArrayList<String> result = getKPC(str);
        String expected = "[tv, tw, tx, uv, uw, ux]";
        assert expected.equals(result.toString());
        System.out.println(result);

        str = "573";
        result = getKPC(str);
        expected = "[mtg, mth, mti, mug, muh, mui, ntg, nth, nti, nug, nuh, nui, otg, oth, oti, oug, ouh, oui]";
        assert expected.equals(result.toString());
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    public static ArrayList<String> getKPC(String str) {
        if (str == null || str.isEmpty()) {
            ArrayList<String> result = new ArrayList<>();
            result.add("");
            return result;
        }

        char ch = str.charAt(0);
        ArrayList<String> kpc = getKPC(str.substring(1));
        ArrayList<String> result = new ArrayList<>();

        String chCodes = codes[ch - '0'];
        for (char chCode: chCodes.toCharArray()) {
            for (String res : kpc) {
                result.add(chCode + res);
            }
        }
        return result;
    }
}
