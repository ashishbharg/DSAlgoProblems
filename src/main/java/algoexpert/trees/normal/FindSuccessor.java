package algoexpert.trees.normal;

/**
 * Write a function that takes in a binary tree (where nodes have an additional pointer to the parent node) as well as
 * node contained in that tree and returns the given node's successor.
 *
 * A node's successor is the next node to be visited immediately after the given node when traversing the tree using its
 * in-order tree traversal technique. A node has no successor if it's the last node to be visited in the in-order traversal.
 *
 * If a node has no successor, your function should return null.
 */
public class FindSuccessor {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(1);
        tree.left = new BinaryTree(2);
        tree.left.left = new BinaryTree(4);
        tree.left.left.left = new BinaryTree(6);
        tree.left.right = new BinaryTree(5);
        tree.right = new BinaryTree(3);
        BinaryTree successor = findSuccessor(tree, tree.left.right);
        System.out.println(successor.value);
        assert successor.value == 1;
    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

        if (node.right != null) {
            return getMinSuccessor(node.right);
        }
        if (node.parent != null && node.parent.left == node) {
            return node.parent;
        }
        BinaryTree temp = node;
        while (temp.parent != null && temp.parent.left != temp) {
            temp = temp.parent;
        }
        return temp.parent;
    }

    private static BinaryTree getMinSuccessor(BinaryTree node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
