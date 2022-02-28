package com.kgprajwal.leetcodejavasolutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node559 {
    public int val;
    public List<Node559> children;

    public Node559() {
    }

    public Node559(int _val) {
        val = _val;
    }

    public Node559(int _val, List<Node559> _children) {
        val = _val;
        children = _children;
    }
};

public class MaximumDepthOfNaryTree {
    public int maxDepth(Node559 root) {
        if (root == null) return 0;
        Queue<Node559> q = new LinkedList<>();
        q.offer(root);

        int depth = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Node559 curr = q.poll();
                for (Node559 child : curr.children) q.offer(child);
            }
            depth++;
        }

        return depth;
    }
}
