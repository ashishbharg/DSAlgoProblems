package algoexpert.trees.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Write a function that takes in a binary tree and returns a list of its branch sums ordered from left most branch sum to
 * right most branch sum. A branch sum is the sum of all values in a binary tree branch. A binary tree branch is a path of
 * nodes in a tree that starts at the root and ends at any leaf node.
 */
public class BranchSums {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right = new BinaryTree(5);
        tree.left.right.left = new BinaryTree(10);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        List<Integer> result = branchSums(tree);
        String expected = "[15, 16, 18, 10, 11]";
        assert expected.equals(result.toString());
    }

    // Time Complexity - O(n) | Space Complexity - O(h), where h is the height of the tree
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        branchSums(root, 0, result);
        return result;
    }

    private static void branchSums(BinaryTree node, int currentSum, List<Integer> result) {

        if (node == null) {
            return;
        }
        currentSum += node.value;
        if (node.left == null && node.right == null) {
            result.add(currentSum);
            return;
        }
        branchSums(node.left, currentSum, result);
        branchSums(node.right, currentSum, result);
    }

    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;


        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}
