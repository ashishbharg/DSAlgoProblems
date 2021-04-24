package leetcode.dailyquestions.dynamicprogramming.easy;


/**
 * https://leetcode.com/problems/fibonacci-number/
 *
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 * Example 1:
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * Example 2:
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * Example 3:
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * Constraints:
 * 0 <= n <= 30
 */
public class Fibonacci {

    public static void main(String[] args) {

        Fibonacci fib = new Fibonacci();

        int fibonaccci = fib.fib(5);
        assert "5".equals(fibonaccci);

        fibonaccci = fib.fib(15);
        assert "610".equals(fibonaccci);

        fibonaccci = fib.fib(2);
        assert "1".equals(fibonaccci);

        fibonaccci = fib.fib(8);
        assert "21".equals(fibonaccci);

        fibonaccci = fib.fib(30);
        assert "832040".equals(fibonaccci);

        fibonaccci = fib.fibWithMemoize(5);
        assert "5".equals(fibonaccci);

        fibonaccci = fib.fibWithMemoize(15);
        assert "610".equals(fibonaccci);

        fibonaccci = fib.fibWithMemoize(2);
        assert "1".equals(fibonaccci);

        fibonaccci = fib.fibWithMemoize(8);
        assert "21".equals(fibonaccci);

        fibonaccci = fib.fibWithMemoize(30);
        assert "832040".equals(fibonaccci);
    }


    /**
     * This method uses iterative way to solve fibonacci series.
     * @param n
     * @return
     * Time Complexity - O(n) | Space Complexity - O(1)
     */
    public int fib(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        int firstNum = 1;
        int secondNum = 1;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = result;
        }
        return result;
    }

    /**
     * This method uses dynamic programming technique memoization to solve the problem.
     * @param n
     * @return
     * Time Complexity - O(n) | Space Complexity - O(n)
     */
    public int fibWithMemoize(int n) {
        Integer[] memoize = new Integer[n + 1];
        memoize[0] = 0;
        memoize[1] = 1;
        fibWithMemoize(n, memoize);
        return memoize[n];
    }

    private int fibWithMemoize(int n, Integer[] memoize) {

        if (memoize[n] != null) {
            return memoize[n];
        }

        memoize[n] = fibWithMemoize(n - 1, memoize) + fibWithMemoize(n - 2, memoize);
        return memoize[n];
    }
}

