package algoexpert.graphs.normal;

/**
 * You're given an array of integers where each integer represents a jump of its value in the array. For instance, the integer 2
 * represents a jump of two indices forward in the array; the integer -3 represents a jump of three indices backward in the
 * array.
 *
 * If a jump spills past the array bounds, it wraps to the other side. For instance, a jump of -1 at index 0 brings us to the
 * last index of the array. Similarily, a jump of 1 at the last index in the array brings us to index 0.
 *
 * Write a function that returns a boolean representing whether the jumps in the array form a single cycle. A single cycle
 * occurs, if starting at any index in the array and following the jumps, every element in the array is visited exactly
 * once before landing back on the starting index.
 *
 * Example:
 * array = [2, 3, 1, -4, -4, 2]
 * Output: true
 *
 * Example = [3, 5, 5, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2]
 * Output: false
 */
public class SingleCycleCheck {

    public static void main(String[] args) {

        int[] array = new int[] {2, 3, 1, -4, -4, 2};
        boolean hasSingleCycle = hasSingleCycle(array);
        System.out.println(hasSingleCycle);
        assert hasSingleCycle;

        array = new int[] {3, 5, 5, -5, -2, -5, -12, -2, -1, 2, -6, 1, 1, 2, -5, 2};
        hasSingleCycle = hasSingleCycle(array);
        System.out.println(hasSingleCycle);
        assert !hasSingleCycle;

        array = new int[] {10, 11, -6, -23, -2, 3, 88, 908, -26};
        hasSingleCycle = hasSingleCycle(array);
        System.out.println(hasSingleCycle);
        assert hasSingleCycle;

        array = new int[] {1, 2, 3, 4, -2, 3, 7, 8, -26};
        hasSingleCycle = hasSingleCycle(array);
        System.out.println(hasSingleCycle);
        assert hasSingleCycle;
    }

    // Time Complexity - O(n) | Space Complexity - O(1)
    public static boolean hasSingleCycle(int[] array) {

        int numOfElementsVisited = 0;
        int currentIndex = 0;
        while (numOfElementsVisited < array.length) {
            if (numOfElementsVisited > 0 && currentIndex == 0) {
                return false;
            }
            numOfElementsVisited++;
            currentIndex = getNextIndex(currentIndex, array);
        }
        return currentIndex == 0;
    }

    private static int getNextIndex(int currentIndex, int[] array) {

        int jump = array[currentIndex];
        int nextIndex = (jump + currentIndex) % array.length;
        return nextIndex >= 0 ? nextIndex : nextIndex + array.length;
    }
}
