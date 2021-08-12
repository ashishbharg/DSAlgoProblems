package pepcoding.recursion.easy;

import java.util.ArrayList;

/**
 * 1. You are given a string str.
 * 2. Complete the body of getSS function - without changing signature - to calculate all subsequences of str.
 * Use sample input and output to take idea about subsequences.
 *
 * Example:
 * Sample Input
 * abc
 * Sample Output
 * [, c, b, bc, a, ac, ab, abc]
 */
public class GetSubsequence {

    public static void main(String[] args) {

        String str = "abc";
        ArrayList<String> result = gss(str);
        System.out.println(result);
    }

    public static ArrayList<String> gss(String str) {

        ArrayList<String> result = gss(str, "");
        return result;
    }

    private static ArrayList<String> gss(String str, String result) {

        if (str.length() == 0) {
            ArrayList<String> list = new ArrayList<>();
            list.add(result);
            return list;
        }

        char ch = str.charAt(0);
        String remainingStr = str.substring(1);
        ArrayList<String> noResult = gss(remainingStr, result); // no call for ch
        ArrayList<String> yesResult = gss(remainingStr, result + ch); // yes call for ch

        ArrayList<String> mergedResult = new ArrayList<>();

        mergedResult.addAll(noResult);
        mergedResult.addAll(yesResult);
        return mergedResult;
    }
}
