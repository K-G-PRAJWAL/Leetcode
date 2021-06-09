package com.kgprajwal.leetcodejavasolutions;

public class MinimumAbsoluteDifferenceInBST {
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        if (prev != null) min = Math.min(min, node.val - prev.val);
        prev = node;
        inorder(node.right);
    }
}
