package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        TreeNode ptr = root;
        while (ptr != null || !stk.isEmpty()) {
            while (ptr != null) {
                stk.push(ptr);
                ptr = ptr.left;
            }
            ptr = stk.pop();
            ans.add(ptr.val);
            ptr = ptr.right;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(3);
        root.right = n1;
        n1.left = n2;
        BinaryTreeInorderTraversal b = new BinaryTreeInorderTraversal();
        System.out.println(b.inorderTraversal(root));
    }
}