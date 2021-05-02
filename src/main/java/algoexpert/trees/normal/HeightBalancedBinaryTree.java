package algoexpert.trees.normal;

/**
 * You are given the node of a binary tree. Write a function that returns true if this binary tree is height balanced and
 * false if it isn't.
 *
 * A binary tree is height balanced if for each node in the tree, the difference between the height of its left subtree and
 * the height of right subtree is at most 1.
 */
public class HeightBalancedBinaryTree {
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
        boolean isTreeHeightBalanced = heightBalancedBinaryTree(tree);
        assert isTreeHeightBalanced;
    }

    // Time Complexity - O(n) | Space Complexity - O(h) where h is the height of the tree.
    public static boolean heightBalancedBinaryTree(BinaryTree tree) {

        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    private static TreeInfo getTreeInfo(BinaryTree tree) {
         if (tree == null) {
             return new TreeInfo(-1, true);
         }

         TreeInfo leftTreeInfo = getTreeInfo(tree.left);
         TreeInfo rightTreeInfo = getTreeInfo(tree.right);
         boolean isCurrentTreeBalanced = leftTreeInfo.isBalanced && rightTreeInfo.isBalanced &&
                 Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1;
         int currentHeight = 1 + Math.max(leftTreeInfo.height, rightTreeInfo.height);
         return new TreeInfo(currentHeight, isCurrentTreeBalanced);
    }

    static class TreeInfo {
        int height;
        boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
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
