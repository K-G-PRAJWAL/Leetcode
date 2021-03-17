package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        helper(root, ans, 0);
        return ans;
    }

    public void helper(TreeNode curr, List<Integer> ans, int depth) {
        if (curr == null) return;
        if (depth == ans.size()) ans.add(curr.val);
        helper(curr.right, ans, depth + 1);
        helper(curr.left, ans, depth + 1);
    }
}
