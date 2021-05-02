package algoexpert.trees.easy;

/**
 * Write a function that takes in a Binary Tree and returns its diameter. The diameter of a binary tree is defined as the
 * length of its longest path, even if that path doesn't pass through the root of the tree.
 *
 * A path is a collection of connected nodes in a tree, where no node is connected to more than two nodes. The length of
 * a path is the number of edges between the path's first node and its last node.
 */
public class BinaryTreeDiameter {

    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(3);
        tree.left.left = new BinaryTree(7);
        tree.left.left.left = new BinaryTree(8);
        tree.left.left.left.left = new BinaryTree(9);
        tree.left.right = new BinaryTree(4);
        tree.left.right.right = new BinaryTree(5);
        tree.left.right.right.right = new BinaryTree(6);
        tree.right = new BinaryTree(2);
        int diameter = binaryTreeDiameter(tree);
        assert diameter == 6;
    }

    // Time Complexity - O(n) | Space Complexity - O(h) where h is the height of the binary tree
    public static int binaryTreeDiameter(BinaryTree tree) {
        TreeInfo treeInfo = calculateBinaryTreeDiameter(tree);
        return treeInfo.diameter;
    }

    private static TreeInfo calculateBinaryTreeDiameter(BinaryTree node) {

        if (node == null) {
            return new TreeInfo(0, 0);
        }
        TreeInfo leftTree = calculateBinaryTreeDiameter(node.left);
        TreeInfo rightTree = calculateBinaryTreeDiameter(node.right);

        int longestPath = leftTree.height + rightTree.height;
        int longestDiameterSoFar = Math.max(leftTree.diameter, rightTree.diameter);
        int currentDiameter = Math.max(longestPath, longestDiameterSoFar);
        int currentHeight = 1 + Math.max(leftTree.height, rightTree.height);
        return new TreeInfo(currentDiameter, currentHeight);
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
