package com.kgprajwal.leetcodejavasolutions;

public class BinaryTreeTilt {
    int total = 0;

    public int dfs(TreeNode node) {
        if (node == null) return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        total += Math.abs(left - right);
        return node.val + left + right;
    }

    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }
}
