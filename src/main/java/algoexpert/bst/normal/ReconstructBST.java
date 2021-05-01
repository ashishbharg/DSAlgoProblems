package algoexpert.bst.normal;

import java.util.Arrays;
import java.util.List;

/**
 * Given a non-empty array of integers representing pre-order traversal of a binary search tree(BST), write a function that
 * creates the relevant BST and returns the root node.
 *
 * The input array will contain the values of BST nodes in the order in which these nodes would be visited with a pre-order
 * traversal.
 */
public class ReconstructBST {

    public static void main(String[] args) {
        List<Integer> preOrderTraversalValues = Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18);
        reconstructBst(preOrderTraversalValues);
    }

    // Time Complexity = O(n) | Space Complexity - O(n)
    public static BST reconstructBst(List<Integer> preOrderTraversalValues) {
        if (preOrderTraversalValues.size() < 1) {
            return null;
        }
        BST root = new BST(preOrderTraversalValues.get(0));
        for (int i = 1; i < preOrderTraversalValues.size(); i++) {
            insertInBST(preOrderTraversalValues.get(i), root);
        }
        return root;
    }

    private static BST insertInBST(Integer number, BST node) {
        if (node == null) {
            return new BST(number);
        }
        if (number < node.value) {
            node.left = insertInBST(number, node.left);
        } else {
            node.right = insertInBST(number, node.right);
        }
        return node;
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
