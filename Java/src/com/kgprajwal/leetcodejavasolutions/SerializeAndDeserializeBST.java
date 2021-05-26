package com.kgprajwal.leetcodejavasolutions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) return;
        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public TreeNode deserialize(Queue<String> q, int l, int h) {
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < l || val > h) return null;
        q.poll();
        TreeNode node = new TreeNode(val);
        node.left = deserialize(q, l, val);
        node.right = deserialize(q, val, h);
        return node;
    }
}
