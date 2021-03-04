package com.kgprajwal.leetcodejavasolutions;

import java.util.Stack;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack;

    public BinarySearchTreeIterator(TreeNode root) {
        this.stack = new Stack<TreeNode>();
        this.inorder(root);
    }

    void inorder(TreeNode root) {
        while (root != null) {
            this.stack.push(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode topmostNode = this.stack.pop();
        if (topmostNode.right != null) {
            this.inorder(topmostNode.right);
        }
        return topmostNode.val;
    }

    public boolean hasNext() {
        return this.stack.size() > 0;
    }
}
