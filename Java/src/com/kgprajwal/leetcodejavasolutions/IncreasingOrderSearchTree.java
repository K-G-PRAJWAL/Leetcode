package com.kgprajwal.leetcodejavasolutions;

public class IncreasingOrderSearchTree {
    /*
    public void inorder(TreeNode node, List<Integer> inOrderArr) {
        if (node == null) return;
        inorder(node.left, inOrderArr);
        inOrderArr.add(node.val);
        inorder(node.right, inOrderArr);
    }

    public TreeNode increasingBST(TreeNode root) {
        List<Integer> inOrderArr = new ArrayList<>();
        inorder(root, inOrderArr);
        TreeNode dummy = new TreeNode(0);
        TreeNode ptr = dummy;
        for (int n : inOrderArr) {
            ptr.right = new TreeNode(n);
            ptr = ptr.right;
        }
        return dummy.right;
    }
     */

    TreeNode ptr;

    private void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        ptr.right = node;
        ptr = node;
        inorder(node.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummy = new TreeNode(0);
        ptr = dummy;
        inorder(root);
        return dummy.right;
    }
}
