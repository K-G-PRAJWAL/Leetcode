package com.kgprajwal.leetcodejavasolutions;

public class LargestBSTSubtree {
    class Node {
        int size;
        int left, right;
        boolean checkBST;

        Node() {
            size = 0;
            checkBST = true;
            left = Integer.MAX_VALUE;
            right = Integer.MIN_VALUE;
        }
    }

    Node verifyBST(TreeNode root) {
        Node n = new Node();
        if (root == null) return n;
        Node l = verifyBST(root.left);
        Node r = verifyBST(root.right);
        n.left = Math.min(l.left, root.val);
        n.right = Math.max(r.right, root.val);

        if (l.checkBST && r.checkBST && l.right <= root.val && r.left >= root.val) {
            n.size = l.size + r.size + 1;
            n.checkBST = true;
        } else {
            n.size = Math.max(l.size, r.size);
            n.checkBST = false;
        }
        return n;
    }

    public int largestBSTSubtree(TreeNode root) {
        Node n = verifyBST(root);
        return n.size;
    }
}
