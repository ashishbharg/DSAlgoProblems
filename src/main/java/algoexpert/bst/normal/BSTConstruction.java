package algoexpert.bst.normal;

/**
 * Write a BST class for a Binary Search Tree. The class should support:
 *  - Inserting values with "insert" method.
 *  - Removing values with "remove" method; this method should only remove the first instance of the given value.
 *  - Searching for values with "contains" method.
 *
 *  Note that you can't remove values from a single node tree. In other words, calling the remove method on a single node tree
 *  should simply not do anything.
 *
 *  Each BST node has an integer value, a left child, and a right child. A node is said to be a valid BST node if and only if it
 *  satisfies the BST property: its value is strictly greater than the values of every node to its left; its values to be
 *  less than or equal to the values of every node to its right; and its children nodes are either valid BST nodes themselves ot null.
 */
public class BSTConstruction {


    public static void main(String[] args) {

        BST root = new BST(10);
        root.insert(5);
        root.insert(15);
        root.insert(2);
        root.insert(5);
        root.insert(13);
        root.insert(22);
        root.insert(1);
        root.insert(14);
        root.insert(12);
        root.remove(10);
        root.contains(15);
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }

        // Average Time Complexity - O(log(n)) | Space Complexity - O(1)
        // Worst Time Complexity - O(n) | Space Complexity - O(1), when it's a skewed tree
        public BST insert(int value) {

            BST root = this;
            if (root == null) {
                root = new BST(value);
                return root;
            }
            while (root != null) {
                if (root.left != null && value < root.value) {
                    root = root.left;                                                                                     
                } else if (root.right != null && value >= root.value) {
                    root = root.right;
                } else if (root.left == null && value < root.value) {
                    root.left = new BST(value);
                    break;
                } else if (root.right == null && value >= root.value) {
                    root.right = new BST(value);
                    break;
                }
            }
            return this;
        }

        // Average Time Complexity - O(log(n)) | Space Complexity - O(1)
        // Worst Time Complexity - O(n) | Space Complexity - O(1), when it's a skewed tree
        public boolean contains(int value) {

            BST currentNode = this;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    currentNode = currentNode.right;
                } else {
                    return true;
                }
            }
            return false;
        }

        // Average Time Complexity - O(log(n)) | Space Complexity - O(1)
        // Worst Time Complexity - O(n) | Space Complexity - O(1), when it's a skewed tree
        public BST remove(int value) {

            BST currentNode = this;
            BST parentNode = null;
            while (currentNode != null) {
                if (value < currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.left;
                } else if (value > currentNode.value) {
                    parentNode = currentNode;
                    currentNode = currentNode.right;
                } else {
                    if (currentNode.left != null && currentNode.right != null) {
                        BST tempNode = getSmallestNode(currentNode.right, currentNode);
                        currentNode.value = tempNode.value;
                    } else if (parentNode == null) {
                        if (currentNode.right != null) {
                            BST tempNode = getSmallestNode(currentNode.right, currentNode);
                            currentNode.value = tempNode.value;
                        } else if (currentNode.left != null) {
                            currentNode.value = currentNode.left.value;
                            currentNode.right = currentNode.left.right;
                            currentNode.left = currentNode.left.left;
                        } else {
                            // do nothing. This is a single node
                        }
                    } else if (parentNode.left == currentNode) {
                        parentNode.left = currentNode.right == null ? currentNode.left: currentNode.right;
                    } else if (parentNode.right == currentNode) {
                        parentNode.right = currentNode.right == null ? currentNode.left : currentNode.right;
                    }
                    break;
                }
            }
            return this;
        }

        private BST getSmallestNode(BST childNode, BST parentNode) {
            BST currentNode = childNode;
            if (currentNode.left == null) {
                parentNode.right = currentNode.right;
                return currentNode;
            }

            while (currentNode.left!= null) {
                parentNode = currentNode;
                currentNode = currentNode.left;
            }
            parentNode.left = currentNode.right;
            return currentNode;
        }
    }
}
