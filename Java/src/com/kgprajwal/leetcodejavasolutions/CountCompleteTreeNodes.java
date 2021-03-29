package com.kgprajwal.leetcodejavasolutions;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if (leftDepth == rightDepth) return (1 << leftDepth) - 1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int rightDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.right;
            depth++;
        }
        return depth;
    }

    private int leftDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}
