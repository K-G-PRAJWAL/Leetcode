package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                preorder.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return preorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        BinaryTreePreorderTraversal b = new BinaryTreePreorderTraversal();
        System.out.println(b.preorderTraversal(root));
    }
}
