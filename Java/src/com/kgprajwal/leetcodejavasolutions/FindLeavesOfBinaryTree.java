package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        helper(root, ans);
        return ans;
    }

    int helper(TreeNode node, List<List<Integer>> ans) {
        if (node == null) return -1;
        int left = helper(node.left, ans);
        int right = helper(node.right, ans);
        int depth = Math.max(left, right) + 1;
        if (ans.size() <= depth) ans.add(new ArrayList<Integer>());
        ans.get(depth).add(node.val);
        return depth;
    }
}
