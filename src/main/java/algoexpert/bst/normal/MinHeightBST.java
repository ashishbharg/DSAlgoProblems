package algoexpert.bst.normal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Write a function that takes in a non-empty array of distinct integers, constructs a BST from the integers, and returns
 * the root of the BST.
 * The function should minimize the height of the BST.
 * You have been provided with a BST class that you'll have to use to construct the BST. Note that BST class already has an
 * "insert" method which you can use if you want.
 */
public class MinHeightBST {

    public static void main(String[] args) {
        List<Integer> array = Arrays.asList(1, 2, 5, 7, 10, 13, 14, 15, 22);
        minHeightBst(array);
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static BST minHeightBst(List<Integer> array) {
        if (array.size() == 0) {
            return null;
        }
        int midIndex = array.size() / 2;
        BST root = new BST(array.get(midIndex));
        root.left = minHeightBst(array.subList(0, midIndex));
        root.right = minHeightBst(array.subList(midIndex + 1, array.size()));
        return root;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }
}
