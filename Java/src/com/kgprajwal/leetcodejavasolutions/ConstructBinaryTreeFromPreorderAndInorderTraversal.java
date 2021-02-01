package com.kgprajwal.leetcodejavasolutions;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    /*
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length-1, preorder, inorder);
    }

    public TreeNode helper(int preorderStart, int inorderStart, int inorderEnd, int[] preorder, int[] inorder) {
        if(preorderStart > preorder.length-1 || inorderStart > inorderEnd) return null;
        TreeNode root = new TreeNode(preorder[preorderStart]);
        int inorderIndex = 0;
        for(int i=inorderStart;i<=inorderEnd;i++) {
            if(inorder[i]==root.val) inorderIndex = i;
        }
        root.left = helper(preorderStart+1, inorderStart, inorderIndex-1, preorder, inorder);
        root.right = helper(preorderStart+inorderIndex-inorderStart+1, inorderIndex+1, inorderEnd, preorder, inorder);
        return root;
    }*/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
        TreeNode root = helper(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
        return root;
    }

    TreeNode helper(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> map) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = map.get(root.val);
        int leftSub = inRoot - inStart;
        root.left = helper(preorder, inorder, preStart + 1, preStart + leftSub, inStart, inRoot - 1, map);
        root.right = helper(preorder, inorder, preStart + leftSub + 1, preEnd, inRoot + 1, inEnd, map);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal obj = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        System.out.println(obj.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7}));
    }
}
