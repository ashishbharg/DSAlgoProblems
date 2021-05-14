package algoexpert.graphs.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * You're given a Node class that has a name and an array of optional children nodes. When put togather, nodes form an
 * acyclic tree-like structure.
 *
 * Implement the depthFirstSearch method on the Node class, which takes in an empty array, traverse the tree using the
 * depth-first search approach (specifically navigating the tree from left to right), stores all of the nodes' names in
 * the input array, and returns it.
 *
 * Example:
 * Sample Input:
 *             A
 *           / | \
 *         B   C  D
 *       /  \    /  \
 *      E   F   G   H
 *         / \   \
 *        I  J    K
 * Output: ["A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"]
 */
public class DepthFirstSearch {

    public static void main(String[] args) {

    }


    static class Node{
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        // Time Complexity - O(v + e) | Space Complexity - O(v)
        public List<String> depthFirstSearch(List<String> array) {

            array.add(this.name);
            for (Node node: children) {
                node.depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
