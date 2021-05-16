package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class FindModeInBinarySearchTree {
    TreeNode prev;
    int cnt = 0;
    int max = Integer.MIN_VALUE;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> modes = new ArrayList<>();
        helper(root, modes);
        int[] ans = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) ans[i] = modes.get(i);
        return ans;
    }

    void helper(TreeNode node, List<Integer> modes) {
        if (node == null) return;
        helper(node.left, modes);
        if (prev == null || prev.val == node.val) cnt++;
        else cnt = 1;
        if (cnt == max) modes.add(node.val);
        else if (cnt > max) {
            modes.clear();
            modes.add(node.val);
            max = cnt;
        }
        prev = node;
        helper(node.right, modes);
    }
}
