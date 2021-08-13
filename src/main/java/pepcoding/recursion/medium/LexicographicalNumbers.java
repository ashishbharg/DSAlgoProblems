package pepcoding.recursion.medium;

import java.util.ArrayList;

/**
 * https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/recursion-and-backtracking/lexicographical-numbers-official/ojquestion
 *
 * 1. You are given a number.
 * 2. You have to print all the numbers from 1 to n in lexicographical order.
 */
public class LexicographicalNumbers {

    public static void main(String[] args) {
        int endNum = 199;
        ArrayList<Integer> result = solution(1, endNum);
        System.out.println(result);
    }

    private static ArrayList<Integer> solution(int startNum, int endNum) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            ArrayList<Integer> res = getLexicographicalNumbers(i, endNum);
            result.addAll(res);
        }
        return result;
    }

    private static ArrayList<Integer> getLexicographicalNumbers(int startNum, int endNum) {

        if (startNum > endNum) {
            return null;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(startNum);
        for (int i = 0; i <= 9; i++) {
            ArrayList<Integer> lexicographicalNumbers = getLexicographicalNumbers(startNum * 10 + i, endNum);
            if (lexicographicalNumbers != null) {
                result.addAll(lexicographicalNumbers);
            }
        }
        return result;

    }
}
