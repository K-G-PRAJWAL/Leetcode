package com.kgprajwal.leetcodejavasolutions;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int a = p.val;
        int b = q.val;
        TreeNode ptr = root;
        while (ptr != null) {
            int parent = ptr.val;
            if (a > parent && b > parent) ptr = ptr.right;
            else if (a < parent && b < parent) ptr = ptr.left;
            else return ptr;
        }
        return null;
    }
}
