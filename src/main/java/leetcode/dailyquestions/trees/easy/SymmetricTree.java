package leetcode.dailyquestions.trees.easy;

import leetcode.dailyquestions.trees.TreeNode;
import leetcode.dailyquestions.trees.hard.SerializeDeserializeBinaryTree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 * Example 1:
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 *
 * Example 2:
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 */
public class SymmetricTree {

    public static void main(String[] args) {

        String inputTree = "1,2,3,null,null,4,null,null,2,4,null,null,3";
        TreeNode root = SerializeDeserializeBinaryTree.deserialize(inputTree);
        boolean isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
        assert isSymmetric;

        inputTree = "1,2,null,3,null,null,2,null,3";
        root = SerializeDeserializeBinaryTree.deserialize(inputTree);
        isSymmetric = isSymmetric(root);
        System.out.println(isSymmetric);
        assert !isSymmetric;
    }

    public static boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode node1, TreeNode node2) {

        if (node1 == null && node2 == null) {
            return true;
        }

        if ((node1 == null && node2 != null) || (node1 != null && node2 == null)) {
            return false;
        }

        if (node1.val != node2.val) {
            return false;
        }

        boolean isSymmetric = isSymmetric(node1.left, node2.right);
        if(!isSymmetric) {
            return false;
        }
        isSymmetric = isSymmetric(node1.right, node2.left);
        if (!isSymmetric) {
            return false;
        }

        return true;
    }

}
