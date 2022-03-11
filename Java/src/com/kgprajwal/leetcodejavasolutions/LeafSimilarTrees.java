package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;

public class LeafSimilarTrees {
    private void dfs(TreeNode root, ArrayList<Integer> arr) {
        if (root != null) {
            if (root.left == null && root.right == null) arr.add(root.val);
            dfs(root.left, arr);
            dfs(root.right, arr);
        }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        dfs(root1, arr1);
        dfs(root2, arr2);
        return arr1.equals(arr2);
    }
}
