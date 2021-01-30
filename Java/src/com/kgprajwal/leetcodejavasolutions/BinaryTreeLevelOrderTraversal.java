package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int lvl = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < lvl; i++) {
                TreeNode curr = q.poll();
                tmp.add(curr.val);
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            ans.add(tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        BinaryTreeLevelOrderTraversal b = new BinaryTreeLevelOrderTraversal();
        System.out.println(b.levelOrder(n1));
    }
}
