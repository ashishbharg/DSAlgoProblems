package algoexpert.greedyalgorithms.normal;

import java.util.*;

/**
 * You're given an integer k representing a number of workers an an array of positive integers representing durations of
 * tasks that must be completed by the workers. Specifically, each worker must complete two unique tasks and can only
 * work on one task at a time. The number of tasks will always be equal to 2K such that each worker has exactly two tasks
 * to complete. All tasks are independent of each other and can be completed in any order. Workers will complete their
 * assigned tasks in parallel, and the time taken to complete all tasks will be equal to the time taken to complete the
 * longest pair of tasks (see the sample output for explanation).
 *
 * Write a function that returns the optimal assignment of tasks to each worker such that the tasks are completed as
 * fast as possible. Your function should return a list of pairs, where each pair stores the indices of the tasks that
 * should be completed by one worker. The pairs  should be in the following format: [task1, task2], where the order of
 * task1 and task2 doesn't matter. Your function should return the pairs in any order. If multiple assignments exist,
 * any correct answer will be accepted.
 *
 * Note: you'll be given at least one worker (i.e. k will always be greater than 0)
 *
 * Example:
 * k: 3,
 * tasks: [1, 3, 5, 3, 1, 4]
 * Sample Output:
 * [
 *   [0, 2], // tasks[0] = 1, tasks[2] = 5 | 1 + 5 = 6
 *   [4, 5], // tasks[4] = 1, tasks[5] = 4 | 1 + 4 = 5
 *   [1, 3] // tasks[1] = 3, tasks[3] = 3 | 3 + 3 = 6
 * ]
 * Note: there are multiple correct answers for this sample input. The following is an example of another correct answer:
 * [
 *   [2, 4], // tasks[2] = 5, tasks[4] = 1 | 5 + 1 = 6
 *   [0, 5], // tasks[0] = 1, tasks[5] = 4 | 1 + 4 = 5
 *   [1, 3] // tasks[1] = 3, tasks[3] = 3 | 3 + 3 = 6
 * ]
 */
public class TaskAssignment {

    public static void main(String[] args) {
        ArrayList<Integer> tasks = new ArrayList<>(Arrays.asList(1, 3, 5, 3, 1, 4));
        taskAssignment(3, tasks);

        tasks = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        taskAssignment(4, tasks);

    }

    // Time Complexity - O(n.log(n)) | Space Complexity - O(n)
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> durationIndexMapping = maintainDurationIndexing(tasks);
        Collections.sort(tasks);
        for (int i = 0; i < k; i++) {
            List<Integer> startDurationList = durationIndexMapping.get(tasks.get(i));
            List<Integer> endDurationList = durationIndexMapping.get(tasks.get(tasks.size() - i - 1));
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(startDurationList.remove(0));
            temp.add(endDurationList.remove(0));
            result.add(temp);
        }

        return result;
    }

    private static Map<Integer, List<Integer>> maintainDurationIndexing(ArrayList<Integer> tasks) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++) {
            List<Integer> list = map.get(tasks.get(i));
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(tasks.get(i), list);
        }
        return map;
    }
}
