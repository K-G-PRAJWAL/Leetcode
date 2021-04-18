package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return serializeHelper(new StringBuilder(), root).toString();
    }

    StringBuilder serializeHelper(StringBuilder s, TreeNode root) {
        if (root == null) return s.append("#");
        s.append(root.val).append(",");
        serializeHelper(s, root.left).append(",");
        serializeHelper(s, root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return deserializeHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }

    TreeNode deserializeHelper(Queue<String> q) {
        String curr = q.poll();
        if ("#".equals(curr)) return null;
        TreeNode root = new TreeNode(Integer.valueOf(curr));
        root.left = deserializeHelper(q);
        root.right = deserializeHelper(q);
        return root;
    }
}
