package com.kgprajwal.leetcodejavasolutions;

public class BinaryTreeMaximumPathSum {
    int maxVal;

    public int maxPathSum(TreeNode root) {
        maxVal = Integer.MIN_VALUE;
        helper(root);
        return maxVal;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        maxVal = Math.max(maxVal, left + right + root.val);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        BinaryTreeMaximumPathSum o = new BinaryTreeMaximumPathSum();
        System.out.println(o.maxPathSum(n1));
    }
}
