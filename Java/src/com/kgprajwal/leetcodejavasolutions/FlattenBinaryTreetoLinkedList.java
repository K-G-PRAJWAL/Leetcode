package com.kgprajwal.leetcodejavasolutions;

public class FlattenBinaryTreetoLinkedList {
    TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    /*public void flatten(TreeNode root) {
        TreeNode ptr = root;
        while (ptr != null) {
            if (ptr.left != null) {
                TreeNode prev = ptr.left;
                while (prev.right != null)
                    prev = prev.right;
                prev.right = ptr.right;
                ptr.right = ptr.left;
                ptr.left = null;
            }
            ptr = ptr.right;
        }
    }*/

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        FlattenBinaryTreetoLinkedList b = new FlattenBinaryTreetoLinkedList();
        b.flatten(root);
    }
}
