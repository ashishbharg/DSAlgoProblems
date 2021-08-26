package pepcoding.dynamicprogramming.easy;

public class ClimbStairsWithMinimumMoves {

    public static void main(String[] args) {

        int[] array = {1, 1, 1, 4, 9, 8, 1, 1, 10, 1};
        int minMoves = findMinMoves(array);
        System.out.println(minMoves);

        array = new int[] {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        minMoves = findMinMoves(array);
        System.out.println(minMoves);
    }

    private static int findMinMoves(int[] array) {

        Integer[] dp = new Integer[array.length + 1];

        dp[array.length] = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= array[i] && (i + j < dp.length); j++) {
                    if (dp[i + j] != null) {
                        min = Math.min(min, dp[i + j]);
                    }
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = 1 + min;
                }
            }
        }

        return dp[0];
    }
}
