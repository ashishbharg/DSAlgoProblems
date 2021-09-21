package leetcode.dailyquestions.trees.easy;

import leetcode.dailyquestions.trees.TreeNode;
import leetcode.dailyquestions.trees.hard.SerializeDeserializeBinaryTree;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 *
 * Given the root of a binary tree, return its maximum depth.
 *
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Example 1:
 * Input: root = [3,9,20,null,null,15,7]
 * Output: 3
 *
 * Example 2:
 * Input: root = [1,null,2]
 * Output: 2
 *
 * Example 3:
 * Input: root = []
 * Output: 0
 *
 * Example 4:
 * Input: root = [0]
 * Output: 1
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String[] args) {

        String inputTree = "3,9,null,null,20,15,null,null,7";
        TreeNode root = SerializeDeserializeBinaryTree.deserialize(inputTree);
        int maxDepth = maxDepth(root);
        System.out.println(maxDepth);
        assert 3 == maxDepth;
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);

        int maxDepth = Math.max(leftMaxDepth, rightMaxDepth) + 1;

        return maxDepth;
    }
}
