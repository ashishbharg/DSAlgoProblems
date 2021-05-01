package algoexpert.bst.normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Write three functions that take in a Binary Search Tree (BST) and an empty array, traverse the BST, add it's nodes values
 * to the input array, and return that array. The three functions should traverse the BST using in-order, pre-order and
 * post-order tree-traversal techniques respectively.
 */
public class BSTTraversal {

    public static void main(String[] args) {
        BST tree = null;
        inOrderTraverse(tree, new ArrayList<>());
        preOrderTraverse(tree, new ArrayList<>());
        postOrderTraverse(tree, new ArrayList<>());
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        inOrderTraverse(tree, array);
        array.add(tree.value);
        inOrderTraverse(tree.right, array);
        return array;
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        array.add(tree.value);
        preOrderTraverse(tree.left, array);
        preOrderTraverse(tree.right, array);
        return array;
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree == null) {
            return array;
        }
        postOrderTraverse(tree.left, array);
        postOrderTraverse(tree.right, array);
        array.add(tree.value);
        return array;
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
