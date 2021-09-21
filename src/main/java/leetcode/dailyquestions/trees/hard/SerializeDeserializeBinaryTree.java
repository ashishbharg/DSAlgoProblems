package leetcode.dailyquestions.trees.hard;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
 * in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
 * another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 *
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 *
 * Your object will be instantiated and called as such:
 * SerializeDeserializeBinaryTree ser = new SerializeDeserializeBinaryTree();
 * SerializeDeserializeBinaryTree deser = new SerializeDeserializeBinaryTree();
 * TreeNode ans = deser.deserialize(ser.serialize(root));
 */
public class SerializeDeserializeBinaryTree {

    public static void main(String[] args) {

        String input = "1,2,3,null,null,4,5";
        String output = serialize(deserialize(input));
        System.out.println(output);
        assert input.equals(output);

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public static void serialize(TreeNode root, StringBuilder sb) {

        if (root == null) {
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    static int idx = 0;
    public static TreeNode deserialize(String data) {

        String[] chars = data.split(",");
        return deserialize(chars);
    }

    public static TreeNode deserialize(String[] data) {

        if (idx >= data.length) {
            return null;
        }

        if ("null".equals(data[idx])) {
            idx++;
            return null;
        }


        TreeNode node = new TreeNode(Integer.parseInt(data[idx++]));

        node.left = deserialize(data);
        node.right = deserialize(data);

        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
