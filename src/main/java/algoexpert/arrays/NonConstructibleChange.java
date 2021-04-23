package algoexpert.arrays;

import java.util.Arrays;

/**
 * Given an array of positive integers representing the values in your possession, write a function that returns the minimum
 * amount of change (the minimum sum of money) that you cannot create. The given coins can have any positive integer value
 * and aren't necessarily unique (i.e. you can have multiple coins of the same value)
 *
 * For example, If you're given coins = [1,2,5], the minimum amount of change that you can't create is 4. If you're given
 * no coins, then minimum amount of change that you can't create is 1.
 */
public class NonConstructibleChange {

    public static void main(String[] args) {

        int[] coins = new int[] {1, 2, 5};
        int change = nonConstructibleChange(coins);
        assert change == 4;

        coins = new int[] {5, 7, 1, 1, 2, 3, 22};
        change = nonConstructibleChange(coins);
        assert change == 20;

        coins = new int[] {};
        change = nonConstructibleChange(coins);
        assert change == 1;

        coins = new int[] {87};
        change = nonConstructibleChange(coins);
        assert change == 1;
    }

    // Time Complexity - O(nlog(n)) | Space Complexity - O(1)
    public static int nonConstructibleChange(int[] coins) {

        int changeCreated = 0;

        Arrays.sort(coins);
        for (int coin : coins) {
            if (coin > changeCreated + 1) {
                return changeCreated + 1;
            }
            changeCreated += coin;
        }
        return changeCreated + 1;
    }
}
