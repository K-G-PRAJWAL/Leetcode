package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class BalanceABinarySearchTree {
    List<TreeNode> arr = new ArrayList<>();

    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        return helper(0, arr.size() - 1);
    }

    void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        arr.add(node);
        inorder(node.right);
    }

    TreeNode helper(int s, int e) {
        if (s > e) return null;
        int mid = (s + e) / 2;
        TreeNode root = arr.get(mid);
        root.left = helper(s, mid - 1);
        root.right = helper(mid + 1, e);
        return root;
    }
}
