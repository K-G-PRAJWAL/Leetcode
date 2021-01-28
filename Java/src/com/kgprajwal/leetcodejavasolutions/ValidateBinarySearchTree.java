package com.kgprajwal.leetcodejavasolutions;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long minimum, long maximum) {
        if (root == null) return true;
        if (root.val >= maximum || root.val <= minimum) return false;
        return helper(root.left, minimum, root.val) && helper(root.right, root.val, maximum);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n2.left = n1;
        n2.right = n3;
        ValidateBinarySearchTree r = new ValidateBinarySearchTree();
        System.out.println(r.isValidBST(n2));
    }
}
