package com.kgprajwal.leetcodejavasolutions;

public class DiameterOfBinaryTree {
    int maxDepth = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return maxDepth;
    }

    int helper(TreeNode node) {
        if (node == null) return 0;
        int left = helper(node.left);
        int right = helper(node.right);
        maxDepth = Math.max(maxDepth, left + right);
        return Math.max(left, right) + 1;
    }
}
