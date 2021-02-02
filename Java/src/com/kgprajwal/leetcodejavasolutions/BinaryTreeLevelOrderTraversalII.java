package com.kgprajwal.leetcodejavasolutions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII {
    /* METHOD 1
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(ans, root, 0);
        return ans;
    }

    void helper(List<List<Integer>> ans, TreeNode root, int lvl) {
        if(root==null) return;
        if(lvl >= ans.size()) ans.add(0, new LinkedList<Integer>());
        helper(ans, root.left, lvl+1);
        helper(ans, root.right, lvl+1);
        ans.get(ans.size()-lvl-1).add(root.val);
    }*/

    // METHOD 2
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return ans;
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
                tmp.add(curr.val);
            }
            ans.add(0, tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;
        BinaryTreeLevelOrderTraversalII b = new BinaryTreeLevelOrderTraversalII();
        System.out.println(b.levelOrderBottom(n1));
    }
}
