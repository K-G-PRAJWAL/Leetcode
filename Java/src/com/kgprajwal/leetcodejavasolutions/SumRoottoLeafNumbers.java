package com.kgprajwal.leetcodejavasolutions;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }

    public int helper(TreeNode root, int sum) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return sum * 10 + root.val;
        return helper(root.left, sum * 10 + root.val) + helper(root.right, sum * 10 + root.val);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        SumRoottoLeafNumbers o = new SumRoottoLeafNumbers();
        n1.left = n2;
        n1.right = n3;
        System.out.println(o.sumNumbers(n1));
    }
}
