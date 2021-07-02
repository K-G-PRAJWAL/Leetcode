package com.kgprajwal.leetcodejavasolutions;

public class LowestCommonAncestorOfDeepestLeaves {
    int max = 0;
    TreeNode lowestCommonNode;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        helper(root, 0);
        return lowestCommonNode;
    }

    int helper(TreeNode node, int depth) {
        max = Math.max(max, depth);
        if (node == null) return depth;
        int left = helper(node.left, depth + 1);
        int right = helper(node.right, depth + 1);
        if (left == max && right == max) lowestCommonNode = node;
        return Math.max(left, right);
    }
}
