package algoexpert.trees.easy;

/**
 * Write a function that takes in a Binary Tree and inverts it. In other words, the function should swap every left node in
 * the tree for its corresponding right node.
 */
public class InvertBinaryTree {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.right = new BinaryTree(9);
        tree.left.right = new BinaryTree(5);
        tree.right = new BinaryTree(3);
        tree.right.left = new BinaryTree(6);
        tree.right.right = new BinaryTree(7);
        invertBinaryTree(tree);
    }

    // Time Complexity - O(n) | Space Complexity - O(h) where h is the height of the tree
    public static void invertBinaryTree(BinaryTree tree) {

        if (tree == null) {
            return;
        }
        BinaryTree temp = tree.left;
        tree.left = tree.right;
        tree.right = temp;

        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
