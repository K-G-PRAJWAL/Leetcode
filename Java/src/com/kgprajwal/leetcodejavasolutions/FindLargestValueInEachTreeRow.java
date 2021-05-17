package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        if (root != null) q.offer(root);
        while (!q.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int len = q.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = q.poll();
                max = Math.max(max, node.val);
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            ans.add(max);
        }
        return ans;
    }
}
