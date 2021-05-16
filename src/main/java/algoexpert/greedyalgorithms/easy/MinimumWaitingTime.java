package algoexpert.greedyalgorithms.easy;

import java.util.Arrays;

/**
 * You're given a non-empty array of positive integers representing the amounts of time that specific queries to
 * execute. Only one query can be executed at a time, but the queries can be executed in any order.
 *
 * A query's waiting time is defined as the amount of time that it must wait before it's execution starts. In other words,
 * if a query is executed second, then its waiting time is the duration of first query; if a query is executed third,
 * then its waiting time is the sum of the durations of first two queries.
 *
 * Write a function that returns the maximum amount of total waiting time for all the queries. For example, if you're
 * given the queries of duration [1, 4, 5], then the total waiting time if the queries were executed in the order of
 * [5, 1, 4] would be (0) + (5) + (5 + 1) = 11. The first query of duration 5 would be executed immediately, so its waiting
 * time would be 0, the second query of duration 1 would have to wait 5 seconds (duration of the first query) to be
 * executed, and the last query would have to wait the duration of the first two queries before being executed.
 *
 * Note: you're allowed to mutate the array.
 */
public class MinimumWaitingTime {

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int minimumWaitingTime = minimumWaitingTime(queries);
        assert 17 == minimumWaitingTime;

        queries = new int[] {25, 30, 2, 1};
        minimumWaitingTime = minimumWaitingTime(queries);
        assert 32 == minimumWaitingTime;

        queries = new int[] {1, 1, 1, 4, 5, 6, 8, 1, 1, 2, 1};
        minimumWaitingTime = minimumWaitingTime(queries);
        assert 81 == minimumWaitingTime;
    }

    // Time Complexity - O(n.log(n)) | Space Complexity - O(1)
    public static int minimumWaitingTime(int[] queries) {

        Arrays.sort(queries);
        int minimumWaitingTime = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            minimumWaitingTime += duration * (queries.length - i - 1);
        }
        return minimumWaitingTime;
    }
}
