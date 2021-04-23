package pepcoding.recursion;

/**
 * Tower of Hanoi is a mathematical puzzle where we have three rods and n disks. The objective of the puzzle is to move
 * the entire stack to another rod, obeying the following simple rules:
 *
 * Only one disk can be moved at a time.
 * Each move consists of taking the upper disk from one of the stacks and placing it on top of another stack i.e.
 * a disk can only be moved if it is the uppermost disk on a stack.
 * No disk may be placed on top of a smaller disk.
 *
 * Time Complexity - O(2^n) | Space Complexity - O(n)
 */
public class TowerOfHanoi {

    public static void main(String[] args) {

        String startingRod = "A";
        String destinationRod = "B";
        String auxiliaryRod = "C";
        System.out.println("Tower of hanoi with 3 discs");
        toh(3, startingRod, destinationRod, auxiliaryRod);

        System.out.println("Tower of hanoi with 4 discs");
        toh(4, startingRod, destinationRod, auxiliaryRod);

    }

    public static void toh(int n, String startingRod, String destinationRod, String auxiliaryRod) {

        if (n == 0) {
            return;
        }
        toh (n-1, startingRod, auxiliaryRod, destinationRod);
        System.out.println("[" + startingRod + " -> " + destinationRod + "]");
        toh(n - 1, auxiliaryRod, destinationRod, startingRod);
    }
}
