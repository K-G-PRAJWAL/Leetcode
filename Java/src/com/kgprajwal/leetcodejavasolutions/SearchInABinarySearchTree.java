package com.kgprajwal.leetcodejavasolutions;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        /*
        if (root == null) return root;
        if (root.val == val) return root;
        else return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
         */
        while (root != null && root.val != val) root = val < root.val ? root.left : root.right;
        return root;
    }
}
