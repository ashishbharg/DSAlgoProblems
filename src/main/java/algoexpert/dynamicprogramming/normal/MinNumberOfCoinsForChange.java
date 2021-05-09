package algoexpert.dynamicprogramming.normal;

import java.util.Arrays;

/**
 * Given an array of positive integers representing coin denominations and a single non-negative integer n representing a
 * target amount of money, write a function that returns the smallest number of coins needed to make a change for (to sum
 * up to) that target amount using the given denominations.
 *
 * Note that you have access to an unlimited amount of coins. In other words, if the denominations are [1, 5, 10], you have
 * access to an unlimited amount of 1s, 5s and 10s.
 *
 * If it's impossible to make change for the target amount, return -1.
 *
 * Example:
 * n = 7
 * denoms = [1, 5, 10]
 * Output: 3
 * This is because 1x2 + 1x5
 */
public class MinNumberOfCoinsForChange {

    public static void main(String[] args) {
        int[] denoms = {1, 5, 10};
        int minNumberOfCoinsForChange = minNumberOfCoinsForChange(7, denoms);
        System.out.println(minNumberOfCoinsForChange);
        assert 3 == minNumberOfCoinsForChange;

        denoms = new int[] {2, 1};
        minNumberOfCoinsForChange = minNumberOfCoinsForChange(3, denoms);
        System.out.println(minNumberOfCoinsForChange);
        assert 2 == minNumberOfCoinsForChange;

        denoms = new int[] {2, 4};
        minNumberOfCoinsForChange = minNumberOfCoinsForChange(7, denoms);
        System.out.println(minNumberOfCoinsForChange);
        assert -1 == minNumberOfCoinsForChange;

        denoms = new int[] {39, 45, 130, 40, 4, 1};
        minNumberOfCoinsForChange = minNumberOfCoinsForChange(135, denoms);
        System.out.println(minNumberOfCoinsForChange);
        assert 3 == minNumberOfCoinsForChange;
    }

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] result = new int[n + 1];
        Arrays.fill(result, Integer.MAX_VALUE);
        result[0] = 0;
        for (int denom : denoms) {
            if (n < denom) {
                continue;
            }
            for (int i = denom; i <= n; i++) {
                int amount = Integer.MAX_VALUE;
                if (result[i - denom] != Integer.MAX_VALUE) {
                    amount = 1 + result[i - denom];
                }
                result[i] = Math.min(result[i], amount);
            }
        }
        return result[n] == Integer.MAX_VALUE ? -1 : result[n];
    }
}
