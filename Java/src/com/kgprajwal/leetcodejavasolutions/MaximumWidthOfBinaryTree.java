package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;
import java.util.Queue;

class Pair662 {
    TreeNode node;
    int num;

    Pair662(TreeNode _node, int _num) {
        num = _num;
        node = _node;
    }
}

public class MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<Pair662> q = new LinkedList<>();
        q.offer(new Pair662(root, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            int min = q.peek().num;
            int first = 0;
            int last = 0;
            for (int i = 0; i < n; i++) {
                int _id = q.peek().num - min;
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0) first = _id;
                if (i == n - 1) last = _id;
                if (node.left != null) q.offer(new Pair662(node.left, _id * 2 + 1));
                if (node.right != null) q.offer(new Pair662(node.right, _id * 2 + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
