package com.kgprajwal.leetcodejavasolutions;

public class SymmetricTree {
    // Recursive
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        if (left.val == right.val) return helper(left.left, right.right) && helper(left.right, right.left);
        else return false;
    }

    /* Iterative
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        while(!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left==null && right==null) continue;;
            if(left==null || right==null || left.val!=right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    } */

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(2);
        TreeNode n6 = new TreeNode(3);
        SymmetricTree s = new SymmetricTree();
        System.out.println(s.isSymmetric(n1));
    }
}
