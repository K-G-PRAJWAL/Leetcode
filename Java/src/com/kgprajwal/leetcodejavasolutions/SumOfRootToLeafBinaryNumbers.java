package com.kgprajwal.leetcodejavasolutions;

public class SumOfRootToLeafBinaryNumbers {
    public static int dfs(TreeNode node, int n) {
        if (node == null) return 0;
        n = (n * 2) + node.val;
        return node.left == node.right ? n : dfs(node.left, n) + dfs(node.right, n);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
}
