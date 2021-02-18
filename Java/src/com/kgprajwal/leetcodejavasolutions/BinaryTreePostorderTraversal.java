package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) return postorder;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode ptr = stack.pop();
            postorder.add(0, ptr.val);
            if (ptr.left != null) stack.push(ptr.left);
            if (ptr.right != null) stack.push(ptr.right);
        }
        return postorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        BinaryTreePostorderTraversal o = new BinaryTreePostorderTraversal();
        System.out.println(o.postorderTraversal(root));
    }
}
