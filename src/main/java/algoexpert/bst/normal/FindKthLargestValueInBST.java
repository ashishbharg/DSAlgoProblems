package algoexpert.bst.normal;

/**
 * Write a function that takes in a Binary Search Tree (BST) and a positive integer k and returns the kth largest
 * integer contained in the BST. You can assume there will only be integer values in the BST and k is less than or equal
 * to the number of nodes in the tree.
 *
 * Also, for the purpose of this question, duplicate integers will be treated as distinct values. In other words, the
 * second largest value in a BST containing values {5, 7, 7} will be 7, not 5.
 *
 * Example:
 * {
 *   "tree": {
 *     "nodes": [
 *       {"id": "15", "left": "5", "right": "20", "value": 15},
 *       {"id": "20", "left": "17", "right": "22", "value": 20},
 *       {"id": "22", "left": null, "right": null, "value": 22},
 *       {"id": "17", "left": null, "right": null, "value": 17},
 *       {"id": "5", "left": "2", "right": "5-2", "value": 5},
 *       {"id": "5-2", "left": null, "right": null, "value": 5},
 *       {"id": "2", "left": "1", "right": "3", "value": 2},
 *       {"id": "3", "left": null, "right": null, "value": 3},
 *       {"id": "1", "left": null, "right": null, "value": 1}
 *     ],
 *     "root": "15"
 *   },
 *   "k": 3
 * }
 * Output: 17
 */
public class FindKthLargestValueInBST {

    public static void main(String[] args) {
        BST tree= new BST(10);
        int result = findKthLargestValueInBst(tree, 1);
        assert result == 10;
    }

    // Time Complexity - O(h + k) | Space Complexity - O(n), where h is the height of the tree and k is the input parameter.
    public static int findKthLargestValueInBst(BST tree, int k) {
        TreeInfo treeInfo = new TreeInfo();
        reverseInOrderTraversal(tree, k, treeInfo);
        return treeInfo.latestNodeValue;
    }

    private static void reverseInOrderTraversal(BST treeNode, int k, TreeInfo treeInfo) {
        if (treeNode == null || treeInfo.numberOfNodesVisited >= k) {
            return;
        }
        reverseInOrderTraversal(treeNode.right, k, treeInfo);
        if (treeInfo.numberOfNodesVisited < k) {
            treeInfo.numberOfNodesVisited += 1;
            treeInfo.latestNodeValue = treeNode.value;
            reverseInOrderTraversal(treeNode.left, k, treeInfo);
        }

    }

    static class TreeInfo {
        public int latestNodeValue;
        public int numberOfNodesVisited;

        TreeInfo() {
            latestNodeValue = -1;
            numberOfNodesVisited = 0;
        }
    }

    static class BST {
        public int value;
        public BST left = null;
        public BST right = null;

        public BST(int value) {
            this.value = value;
        }
    }
}
