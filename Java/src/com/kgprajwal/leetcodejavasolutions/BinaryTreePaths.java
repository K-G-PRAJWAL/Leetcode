package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    List<String> res = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {
            return res;
        }
        binaryTreePaths(root, String.valueOf(root.val));
        return res;
    }

    void binaryTreePaths(TreeNode root, String list) {
        if (root.left == null && root.right == null) {
            res.add(list);
            return;
        }
        if (root.left != null) {
            binaryTreePaths(root.left, list + "->" + String.valueOf(root.left.val));
        }
        if (root.right != null) {
            binaryTreePaths(root.right, list + "->" + String.valueOf(root.right.val));
        }
    }
}
