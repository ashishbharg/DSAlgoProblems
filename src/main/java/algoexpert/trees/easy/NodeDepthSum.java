package algoexpert.trees.easy;

/**
 * The distance between a node in a Binary Tree and the tree's root is called the node's depth. Write a function that
 * takes in a binary tree and returns the sum of it's node depths.
 */
public class NodeDepthSum {

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
        int result = nodeDepths(tree);
        assert result == 16;
    }

    // Time Complexity - O(n) | Space Complexity - O(h) where h is the height of the tree
    public static int nodeDepths(BinaryTree root) {
        return calculateNodeDepthSum(root, 0);
    }

    private static int calculateNodeDepthSum(BinaryTree node, int depthSum) {
        if (node == null) {
            return 0;
        }
        return depthSum + calculateNodeDepthSum(node.left, depthSum + 1) + calculateNodeDepthSum(node.right, depthSum + 1);
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
