package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        Stack<TreeNode[]> stk = new Stack<>();
        stk.push(new TreeNode[]{root1, root2});
        while (!stk.isEmpty()) {
            TreeNode[] curr = stk.pop();
            if (curr[0] == null || curr[1] == null) continue;
            curr[0].val += curr[1].val;
            if (curr[0].left == null) curr[0].left = curr[1].left;
            else stk.push(new TreeNode[]{curr[0].left, curr[1].left});
            if (curr[0].right == null) curr[0].right = curr[1].right;
            else stk.push(new TreeNode[]{curr[0].right, curr[1].right});
        }
        return root1;
    }
}
