package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int ans = 0;
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size();
            ans = 0;
            for (int i = 0; i < n; i++) {
                TreeNode curr = q.poll();
                ans += curr.val;
                if (curr.right != null) q.add(curr.right);
                if (curr.left != null) q.add(curr.left);
            }
        }
        return ans;
    }
}
