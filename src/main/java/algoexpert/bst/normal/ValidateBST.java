package algoexpert.bst.normal;

/**
 * Write a function that takes in a potentially invalid binary search tree (BST) and returns a boolean representing whether the BST is valid.
 *
 * Each BST node has an integer value, a left child, and a right child. A node is said to be a valid BST node if and only if it
 * satisfies the BST property: its value is strictly greater than the values of every node to its left; its values to be
 * less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves ot null.
 */
public class ValidateBST {

    public static void main(String[] args) {

        // Create a tree and validate it here.
        validateBst(null);
    }

    // Time Complexity - O(n) | Space Complexity - O(h) where h is the height of the tree
    public static boolean validateBst(BST root) {
        return validateBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean validateBst(BST root, int minValue, int maxValue) {

        if (root.value < minValue || root.value >= maxValue) {
            return false;
        }
        if (root.left != null && !validateBst(root.left, minValue, root.value)) {
            return false;
        }
        if (root.right != null && !validateBst(root.right, root.value, maxValue)) {
            return false;
        }
        return true;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
