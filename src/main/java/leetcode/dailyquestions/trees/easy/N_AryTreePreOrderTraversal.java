package leetcode.dailyquestions.trees.easy;

import java.util.*;

/**
 * Given the root of an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal. Each group of children is separated by the null value (See examples)
 *
 * Example 1:
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 *
 * Example 2:
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * 0 <= Node.val <= 104
 * The height of the n-ary tree is less than or equal to 1000.
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class N_AryTreePreOrderTraversal {

    public static void main(String[] args) {

        List<Node> children = new ArrayList<>();
        children.add(new Node(5));
        children.add(new Node(6));
        Node parentNode= new Node(3, children);
        children = new ArrayList<>();
        children.add(parentNode);
        children.add(new Node(2));
        children.add(new Node(4));
        Node root = new Node(1, children);
        List<Integer> preOrderList = preorderRecursively(root);
        String expected = "[1, 3, 5, 6, 2, 4]";
        assert expected.equals(Arrays.toString(preOrderList.toArray()));

        preOrderList = preorderIteratively(root);
        expected = "[1, 3, 5, 6, 2, 4]";
        assert expected.equals(Arrays.toString(preOrderList.toArray()));
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static List<Integer> preorderIteratively(Node root) {

        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Deque<Node> stack = new LinkedList<>();
        stack.offerLast(root);
        while (!stack.isEmpty()) {
            Node node = stack.pollLast();
            list.add(node.val);
            if (node.children != null) {
                for (int i = node.children.size() - 1; i >= 0; i--) {
                    stack.offerLast(node.children.get(i));
                }
            }
        }

        return list;
    }

    // Time Complexity - O(n) | Space Complexity - O(n)
    public static List<Integer> preorderRecursively(Node root) {

        List<Integer> list = new ArrayList<>();
        preorderRecursively(root, list);
        return list;
    }

    private static void preorderRecursively(Node node, List<Integer> list) {

        if (node == null) {
            return;
        }

        list.add(node.val);
        for (int i = 0; node.children != null && i < node.children.size(); i++) {
            preorderRecursively(node.children.get(i), list);
        }
    }

    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
