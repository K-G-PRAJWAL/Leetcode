package com.kgprajwal.leetcodejavasolutions;

public class RecoverBinarySearchTree {
    TreeNode first = null, second = null, prev = null;

    public void recoverTree(TreeNode root) {
        if (root == null) return;
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        if (first == null && (prev == null || prev.val >= root.val))
            first = prev;
        if (first != null && prev.val >= root.val)
            second = root;
        prev = root;
        helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n3;
        n3.right = n2;
        RecoverBinarySearchTree r = new RecoverBinarySearchTree();
        r.recoverTree(n1);
    }
}
