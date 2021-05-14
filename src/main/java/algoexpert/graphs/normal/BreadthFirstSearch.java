package algoexpert.graphs.normal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * You're given a Node class that has a name and an array of optional children nodes. When put togather, nodes form an
 * acyclic tree-like structure.
 *
 * Implement the breadthFirstSearch method on the Node class, which takes in an empty array, traverse the tree using the
 * breadth-first search approach (specifically navigating the tree from left to right), stores all of the nodes' names in
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
 * Output: ["A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"]
 */
public class BreadthFirstSearch {

    static class Node{
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            // Write your code here.
            Queue<Node> queue = new LinkedList<>();
            queue.offer(this);
            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);
                queue.addAll(node.children);
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
