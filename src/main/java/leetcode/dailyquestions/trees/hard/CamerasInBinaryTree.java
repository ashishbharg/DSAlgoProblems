package leetcode.dailyquestions.trees.hard;

import leetcode.dailyquestions.trees.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-cameras/
 *
 * You are given the root of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor
 * its parent, itself, and its immediate children.
 *
 * Return the minimum number of cameras needed to monitor all nodes of the tree.
 *
 * Example 1:
 * Input: root = [0,0,null,0,0]
 * Output: 1
 * Explanation: One camera is enough to monitor all nodes if placed as shown.

 * Example 2:
 * Input: root = [0,0,null,0,null,0,null,null,0]
 * Output: 2
 * Explanation: At least two cameras are needed to monitor all nodes of the tree. The above image shows one of the valid configurations of camera placement.
 */
public class CamerasInBinaryTree {

    public static void main(String[] args) {
        String inputTree = "0,0,null,0,0,null,0,0";
        TreeNode root = SerializeDeserializeBinaryTree.deserialize(inputTree);
        int cameras = minCameraCover(root);
        System.out.println(cameras);
        assert 2 == cameras;
    }

    static int cameraCount;

    public static int minCameraCover(TreeNode root) {
        cameraCount = 0;

        if (cameraMonitor(root) == -1) {
            cameraCount++;
        }
        return cameraCount;
    }

    public static int cameraMonitor(TreeNode root) {

        if (root == null) {
            return 1;
        }

        int lChild = cameraMonitor(root.left);
        int rChild = cameraMonitor(root.right);

        if (lChild == -1 || rChild == -1) {
            cameraCount++;
            return 0;
        }

        if (lChild == 0 || rChild == 0) {
            return 1;
        }

        return -1;

    }
}
