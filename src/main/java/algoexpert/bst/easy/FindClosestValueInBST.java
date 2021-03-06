package algoexpert.bst.easy;

/**
 * Write a function that takes in a Binary Search Tree (BST) and a target value and returns the closest value to the target
 * value contained in the BST.
 *
 * You can assume there will only be one closest value.
 *
 * Example 1:
 * {
 *   "tree": {
 *     "nodes": [
 *       {"id": "10", "left": "5", "right": "15", "value": 10},
 *       {"id": "15", "left": "13", "right": "22", "value": 15},
 *       {"id": "22", "left": null, "right": null, "value": 22},
 *       {"id": "13", "left": null, "right": "14", "value": 13},
 *       {"id": "14", "left": null, "right": null, "value": 14},
 *       {"id": "5", "left": "2", "right": "5-2", "value": 5},
 *       {"id": "5-2", "left": null, "right": null, "value": 5},
 *       {"id": "2", "left": "1", "right": null, "value": 2},
 *       {"id": "1", "left": null, "right": null, "value": 1}
 *     ],
 *     "root": "10"
 *   },
 *   "target": 12
 * }
 * Output: 13
 *
 * Example 2:
 * {
 *   "tree": {
 *     "nodes": [
 *       {"id": "100", "left": "5", "right": "502", "value": 100},
 *       {"id": "502", "left": "204", "right": "55000", "value": 502},
 *       {"id": "55000", "left": "1001", "right": null, "value": 55000},
 *       {"id": "1001", "left": null, "right": "4500", "value": 1001},
 *       {"id": "4500", "left": null, "right": null, "value": 4500},
 *       {"id": "204", "left": "203", "right": "205", "value": 204},
 *       {"id": "205", "left": null, "right": "207", "value": 205},
 *       {"id": "207", "left": "206", "right": "208", "value": 207},
 *       {"id": "208", "left": null, "right": null, "value": 208},
 *       {"id": "206", "left": null, "right": null, "value": 206},
 *       {"id": "203", "left": null, "right": null, "value": 203},
 *       {"id": "5", "left": "2", "right": "15", "value": 5},
 *       {"id": "15", "left": "5-2", "right": "22", "value": 15},
 *       {"id": "22", "left": null, "right": "57", "value": 22},
 *       {"id": "57", "left": null, "right": "60", "value": 57},
 *       {"id": "60", "left": null, "right": null, "value": 60},
 *       {"id": "5-2", "left": null, "right": null, "value": 5},
 *       {"id": "2", "left": "1", "right": "3", "value": 2},
 *       {"id": "3", "left": null, "right": null, "value": 3},
 *       {"id": "1", "left": "-51", "right": "1-2", "value": 1},
 *       {"id": "1-2", "left": null, "right": "1-3", "value": 1},
 *       {"id": "1-3", "left": null, "right": "1-4", "value": 1},
 *       {"id": "1-4", "left": null, "right": "1-5", "value": 1},
 *       {"id": "1-5", "left": null, "right": null, "value": 1},
 *       {"id": "-51", "left": "-403", "right": null, "value": -51},
 *       {"id": "-403", "left": null, "right": null, "value": -403}
 *     ],
 *     "root": "100"
 *   },
 *   "target": 100
 * }
 * Output: 100
 */
public class FindClosestValueInBST {

    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.left.left.left = new BST(1);
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.right.left.right = new BST(14);
        int closestValueInBst = findClosestValueInBst(root, 12);
        assert closestValueInBst == 13;
    }

    // Time Complexity - O(log(n)) | Space Complexity - O(1)
    public static int findClosestValueInBst(BST tree, int target) {
        int closestValueInBST = tree.value;
        while (tree != null) {
            if (Math.abs(target - tree.value) < Math.abs(closestValueInBST - target)) {
                closestValueInBST = tree.value;
            }
            if (target > tree.value) {
                tree = tree.right;
            } else if (target < tree.value) {
                tree = tree.left;
            } else {
                return tree.value;
            }
        }
        return closestValueInBST;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
