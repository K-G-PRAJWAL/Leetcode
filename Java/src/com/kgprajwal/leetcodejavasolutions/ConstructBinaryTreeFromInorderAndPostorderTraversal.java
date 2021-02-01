package com.kgprajwal.leetcodejavasolutions;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || inorder.length == 0 || postorder == null || postorder.length == 0)
            return null;
        return helper(postorder, inorder, postorder.length - 1, 0, inorder.length - 1);
    }

    TreeNode helper(int[] postorder, int[] inorder, int index, int start, int end) {
        if (start > end || index < 0) return null;
        TreeNode root = new TreeNode(postorder[index]);
        int i;
        for (i = start; i <= end; i++) {
            if (inorder[i] == root.val) break;
        }
        root.right = helper(postorder, inorder, index - 1, i + 1, end);
        root.left = helper(postorder, inorder, index - (end - i + 1), start, i - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal obj = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        System.out.println(obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
