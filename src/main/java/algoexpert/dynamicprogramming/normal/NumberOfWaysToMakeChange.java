package algoexpert.dynamicprogramming.normal;

/**
 * Given an array of distinct positive integers representing coin denominations and a single non-negative integer n
 * representing a target amount of money, write a function that returns the number of ways to make change for that target
 * amount using the given coin denominations.
 *
 * Note that an unlimited amount of coins is at your disposal.
 *
 * Example:
 * n = 6
 * denoms = [1, 5]
 * Output: 2
 * Possible combinations are 1 * 1 + 1 * 5 and 6 * 1
 */
public class NumberOfWaysToMakeChange {

    public static void main(String[] args) {
        int[] denoms = {1, 5};
        int waysToMakeChange = numberOfWaysToMakeChange(6, denoms);
        assert 2 == waysToMakeChange;

        denoms = new int[] {1, 5, 10, 25};
        waysToMakeChange = numberOfWaysToMakeChange(25, denoms);
        assert 13 == waysToMakeChange;

        denoms = new int[] {2, 3, 7};
        waysToMakeChange = numberOfWaysToMakeChange(12, denoms);
        assert 4 == waysToMakeChange;
    }

    // Time Complexity - O(n.d) | Space Complexity - O(n)
    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        int[] result = new int[n + 1];
        result[0] = 1;
        for (int denom: denoms) {
            for (int amount = 1; amount <= n; amount++) {
                if (denom <= amount) {
                    result[amount] += result[amount - denom];
                }
            }
        }
        return result[n];
    }
}
